package java112.utilities;
import java.util.*;
import java.io.*;

/**
 * @author Eric Knapp
 * interface PropertiesLoaderInterface
 */
public interface PropertiesLoaderInterface {

  default Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException inputOutputException) {
            inputOutputException.printStackTrace();
            return null;
        } catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return properties;
    }

}
