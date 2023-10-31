package cn.xf.springframework.bean.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.xf.springframework.bean.pojo.BeanDefinition;
import cn.xf.springframework.bean.pojo.BeanReference;
import cn.xf.springframework.bean.pojo.PropertyValue;
import cn.xf.springframework.bean.pojo.PropertyValues;
import cn.xf.springframework.bean.support.AbstractBeanDefinitionReader;
import cn.xf.springframework.bean.support.BeanDefinitionRegister;
import cn.xf.springframework.core.io.Resource;
import cn.xf.springframework.core.io.ResourceLoader;
import com.sun.xml.internal.ws.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  16:03
 * @Description: TODO
 * @Version: 1.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegister register) {
        super(register);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegister register, ResourceLoader resourceLoader) {
        super(register, resourceLoader);
    }

    @Override
    public BeanDefinitionRegister getBeanDefinitionRegistry() {
        return null;
    }

    @Override
    public void loadBeanDefinition(Resource resource) throws IOException, ClassNotFoundException {
        doLoadBeanDefinition(resource.getInputStream());
    }

    @Override
    public void loadBeanDefinition(Resource... resources) throws IOException, ClassNotFoundException {
        for (Resource resource : resources) {
            loadBeanDefinition(resource);
        }
    }

    @Override
    public void loadBeanDefinition(String location) throws IOException, ClassNotFoundException {
        loadBeanDefinition(getResourceLoader().getResource(location));
    }

    public void doLoadBeanDefinition(InputStream inputStream) throws IOException, ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element documentElement = document.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (!(item instanceof Element)) continue;
            if (!("bean".equals(item.getNodeName()))) continue;

            String id = ((Element) item).getAttribute("id");
            String aClass = ((Element) item).getAttribute("class");
            String name = ((Element) item).getAttribute("name");

            //获取class
            Class<?> beanClass = Class.forName(aClass);
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(beanClass.getSimpleName());
            }
            BeanDefinition beanDefinition = new BeanDefinition(beanClass);
            //获取属性
            for (int j = 0; j < item.getChildNodes().getLength(); j++) {
                Node propertyNode = item.getChildNodes().item(j);
                if (!(propertyNode instanceof Element)) continue;
                if (!("property".equals(propertyNode.getNodeName()))) continue;

                String name1 = ((Element) propertyNode).getAttribute("name");
                String attValue = ((Element) propertyNode).getAttribute("value");
                String ref = ((Element) propertyNode).getAttribute("ref");

                Object value = StrUtil.isNotEmpty(ref) ? new BeanReference(ref) : attValue;
                PropertyValue propertyValue = new PropertyValue(name1, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            //校验是否存在
            if (getRegister().containsBeanDefinition(beanName)) {
                throw new ClassNotFoundException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            //注册beanDefinition
            getRegister().registerBeanDefinition(beanName, beanDefinition);
        }

    }

}
