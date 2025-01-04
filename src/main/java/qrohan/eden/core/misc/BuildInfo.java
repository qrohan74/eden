package qrohan.eden.core.misc;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 * Class providing some common build information
 */
public class BuildInfo {
    /**
     * Default constructor
     */
    public BuildInfo() {
        // empty
    }

    /**
     * Get the user
     * @return current user
     */
    public static String getUser() {
        return System.getProperty("user.name");
    }

    /**
     * Get the data
     * @return current date in format yyyy/mm/dd
     */
    public static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /**
     * Get the version of the module
     * @return current version
     * @throws IOException if an error occurred when reading the version
     */
    public static String getVersion() throws IOException {
        final Properties properties = new Properties();
        properties.load(BuildInfo.class.getResourceAsStream("/project.properties"));
        return properties.getProperty("version");
    }

    /**
     * Get the project (i.e. module) name
     * @return project module name
     * @throws IOException if an error occurred when reading the module
     */
    public static String getModule() throws IOException {
        final Properties properties = new Properties();
        properties.load(BuildInfo.class.getResourceAsStream("/project.properties"));
        return properties.getProperty("artifactId");
    }
}
