package cn.jedis.test;

import cn.jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest2 {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","zhangsan");

        jedis.close();
    }
    @Test
    public void testpool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);//最大活动对像
        jedisPoolConfig.setMaxIdle(10);//最大连接数

        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("hehei","haha");
        jedis.close();
    }

    @Test
    public void testpool1() {

        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hehei", "hahai");
        jedis.close();
    }
}
