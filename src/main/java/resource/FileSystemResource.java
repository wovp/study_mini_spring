package resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ClassName: FileSystemResource
 * Package: resource
 * Description:
 * Author: gx
 * Creat: 2025/1/21 17:07
 */
@Data
@AllArgsConstructor
public class FileSystemResource implements Resource{
    private String path;
    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        Path pa = new File(path).toPath();
        try {
            return Files.newInputStream(pa);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
