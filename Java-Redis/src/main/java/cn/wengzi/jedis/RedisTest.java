package cn.wengzi.jedis;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RedisTest {
    private static Properties properties = new Properties();
    private static InputStream inputStream = null;

    /**
     * 通过Properties读取配置文件
     */
    static {
        try {
            inputStream = RedisTest.class.getResourceAsStream("/Jedis.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private final static String host = properties.getProperty("host");
    private final static Integer port = Integer.parseInt(properties.getProperty("port"));
    private final static String password = properties.getProperty("password");

    /**
     * 测试redis连接
     * 打开Linux端口：firewall-cmd --zone=public --add-port=6379/tcp --permanent
     */
    public static void RedisConnector() {
        Jedis jedis = null;
        try {
            jedis = new Jedis(host, port);
            jedis.auth(password);

            //System.out.println(jedis.ping());

            String name = jedis.get("name");
            System.out.println(name);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    public static void showMysql() {
        Jedis jedis = null;
        try {
            jedis = new Jedis(host, port);
            jedis.auth(password);

            String key = "add";

            //如果key存在直接获取,没有则从数据库中查询出来存进去
            if (jedis.exists(key)) {
                System.out.println(jedis.get(key));
            } else {
                jedis.set(key, "山西");
                System.out.println(jedis.get(key));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    public static void main(String[] args) {
        RedisConnector();
//        showMysql();
    }
}
