package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvReaderTwitter {

    private static Properties properties = new Properties();

    static {
        InputStream is = EnvReaderTwitter.class.getClassLoader().getResourceAsStream("env.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUriTwitter() {
        return properties.getProperty("baseUri");
    }

    public static String getBasePathTwitter() {
        return properties.getProperty("basePath");
    }

    public static String getConsumerKey() { return properties.getProperty("consumerKey"); }

    public static String getConsumerSecret() { return properties.getProperty("consumerSecret"); }

    public static String getAccessToken() { return properties.getProperty("accessToken"); }

    public static String getTokenSecret() { return properties.getProperty("tokenSecret"); }

}

