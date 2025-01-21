package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ClassName: IoUtil
 * Package: utils
 * Description:
 * Author: gx
 * Creat: 2025/1/21 17:31
 */
public class IoUtil {
    public static String readUtf8(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            int c;
            while ((c = reader.read())!= -1) {
                sb.append((char) c);
            }
        }
        return sb.toString();
    }
}
