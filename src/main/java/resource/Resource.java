package resource;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * ClassName: Resource
 * Package: resource
 * Description:
 * Author: gx
 * Creat: 2025/1/21 17:01
 * @author 11
 */
public interface Resource {
    /**
     * 读取资源内容
     */
    public InputStream getInputStream() throws FileNotFoundException;
}
