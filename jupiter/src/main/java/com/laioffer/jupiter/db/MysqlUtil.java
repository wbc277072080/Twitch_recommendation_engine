package com.laioffer.jupiter.db;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MysqlUtil {
    private static final String INSTANCE = "twitch-project-database.cigbc2pqyr6g.us-east-2.rds.amazonaws.com";
    private static final String PORT_NUM = "3306";
    private static final String DB_NAME = "twitch";
    public static String getMySQLAddress() throws IOException {
        Properties prop = new Properties();
        String propFileName = "mysqlConfig.properties";

        //相对路径
        InputStream inputStream = MysqlUtil.class.getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);


        String username = prop.getProperty("user");
        String password = prop.getProperty("password");
        return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&autoReconnect=true&serverTimezone=UTC&createDatabaseIfNotExist=true",
                INSTANCE, PORT_NUM, DB_NAME, username, password);
    }

}
