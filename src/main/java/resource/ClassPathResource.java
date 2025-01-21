package resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * ClassName: ClassPathResource
 * Package: resource
 * Description:
 * Author: gx
 * Creat: 2025/1/21 17:02
 * @author 11
 */
@Data
@AllArgsConstructor
public class ClassPathResource implements Resource{
    public String path;


    @Override
    public InputStream getInputStream() throws FileNotFoundException{
        // 需要传入去掉classpath前缀
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }
}
