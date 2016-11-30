package com.zva.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    public static String db_host;
    public static String db_port;
    public static String db_name;
    public static String db_username;
    public static String db_password;

    public static String data_dir;
    public static String app_path;

    static {
        try {
            //LOGS
            System.out.println("Tomcat home: " + System.getProperty("catalina.home"));

            app_path = new File(System.getProperty("catalina.home") + "/webapps").getAbsolutePath();

            Properties prop = new Properties();
            File propertyFile = new File(app_path + "/zva.properties");
            prop.load(new FileInputStream(propertyFile));

            data_dir = app_path + "/" + prop.getProperty("data_dir") + "/";
            db_username = prop.getProperty("db_username");
            db_password = prop.getProperty("db_password");
            db_host = prop.getProperty("db_host");
            db_port = prop.getProperty("db_port");
            db_name = prop.getProperty("db_name");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getLocalizedMessage());
            System.out.println("Can not read property file...");
        }
    }
}
