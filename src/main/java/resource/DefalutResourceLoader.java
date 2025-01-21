package resource;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ClassName: DefalutResourceLoader
 * Package: resource
 * Description:
 * Author: gx
 * Creat: 2025/1/21 17:19
 * @author 11
 */
public class DefalutResourceLoader implements ResourceLoader{
    private static final String CLASSPATH_PERFIX = "classpath:";
    @Override
    public Resource getResource(String path) {
        if (path.startsWith(CLASSPATH_PERFIX)) {
            return new ClassPathResource(path.substring(CLASSPATH_PERFIX.length()));
        }
        try {
            URL url = new URL(path);
            return new UrlResource(url);
        } catch (MalformedURLException e) {
            return new FileSystemResource(path);
        }
    }
}
