package resource;

import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.PriorityQueue;

/**
 * ClassName: UrlResource
 * Package: resource
 * Description:
 * Author: gx
 * Creat: 2025/1/21 17:11
 * @author 11
 */
@Data
@AllArgsConstructor
public class UrlResource implements Resource{
    private URL url;
    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        try {
            URLConnection urlConnection = this.url.openConnection();
            return urlConnection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
