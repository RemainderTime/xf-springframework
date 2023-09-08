import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author xiongfeng
 * @date 2023/9/1 14:54
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void getUserInfo() {
        System.out.println("成功打印用户信息");
    }
}
