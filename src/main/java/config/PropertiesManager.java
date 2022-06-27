package config;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertiesManager {
    private static final String PROPERTIES_FILE = "properties.xml";
    private XMLConfiguration config = null;
    private static PropertiesManager instance;

    public PropertiesManager(){
        loadProperties();
    }

    public static PropertiesManager getInstance(){
        if(instance == null){
            instance = new PropertiesManager();
        }
        return instance;
    }
    private void loadProperties() {
        Configurations configs = new Configurations();

        try {
            config = configs.xml(PropertiesManager.PROPERTIES_FILE);
            System.out.println("XD");
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getProperty(String name) {
        return config.getString(name);
    }
}
