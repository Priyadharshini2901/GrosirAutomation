package ApplicationPropertyReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationPropertiesReader {
    public static Properties properties = new Properties();
    public static FileInputStream fileInputStream;

    static {
        try {
            fileInputStream = new FileInputStream("/Users/priyadharshini/IdeaProjects/BliBliGrocery/src/main/resources/application.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
