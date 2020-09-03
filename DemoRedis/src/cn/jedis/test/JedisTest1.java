package cn.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest1 {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","zhangsan");

//        String username = jedis.get("username");
//        System.out.println(username);
//        jedis.setex("activecode",20,"hehe");//20秒后过期

        jedis.hset("user","username","lisi");
        String username = jedis.hget("user", "username");
        System.out.println(username);

        jedis.close();
    }
}
