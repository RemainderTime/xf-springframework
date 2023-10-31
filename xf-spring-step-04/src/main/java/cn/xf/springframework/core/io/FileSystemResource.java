package cn.xf.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  15:22
 * @Description: TODO 本地文件资源获取
 * @Version: 1.0
 */
public class FileSystemResource implements Resource{

    private final String path;

    private final File file;

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    public FileSystemResource(File file){
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {

        return new FileInputStream(file);
    }
}
