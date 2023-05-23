package com.exercise.helper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;
public class PropertiesConfiguration {

        public static final Properties properties;

        private static final Logger log = LogManager.getLogger(PropertiesConfiguration.class);

        static {
            properties = new Properties();

            try {
                ClassLoader classLoader = PropertiesConfiguration.class.getClassLoader();
                InputStream applicationPropertiesStream = classLoader.getResourceAsStream("application.properties");
                properties.load(applicationPropertiesStream);
            } catch (Exception e) {
                log.error("Failed to load application.properties", e);
            }
        }

    }

