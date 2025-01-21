package resource;

/**
 * ClassName: ResourceLoader
 * Package: resource
 * Description:
 * Author: gx
 * Creat: 2025/1/21 17:18
 * @author 11
 */
public interface ResourceLoader {
    /**
     * 获取具体的Resource
     * @param path
     * @return
     */
    public Resource getResource(String path);
}
