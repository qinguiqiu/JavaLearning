package cn.jedis.test;

import jdk.jfr.StackTrace;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","zhangsan");
        jedis.close();
    }
}
