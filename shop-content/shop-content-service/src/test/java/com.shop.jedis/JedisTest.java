package com.shop.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/12/13 0013.
 */
public class JedisTest {

    @Test
    public void testJedisSingle(){
        Jedis jedis = new Jedis("192.168.235.8",6379);
        jedis.set("mytestJedis","10000");

        String mytestJedis = jedis.get("mytestJedis");

        System.out.println(mytestJedis);

        jedis.close();
    }

    @Test
    public void testJedisPool(){
        JedisPool jedisPool = new JedisPool("192.168.235.8",6379);
        Jedis jedis = jedisPool.getResource();

        String mytestJedis = jedis.get("mytestJedis");
        System.out.println(mytestJedis);

        jedis.close();

        jedisPool.close();
    }

    @Test
    public void testJedisCluster(){

        Set<HostAndPort> set = new HashSet<HostAndPort>();
        set.add(new HostAndPort("192.168.235.8",7001));
        set.add(new HostAndPort("192.168.235.8",7002));
        set.add(new HostAndPort("192.168.235.8",7003));
        set.add(new HostAndPort("192.168.235.8",7004));
        set.add(new HostAndPort("192.168.235.8",7005));
        set.add(new HostAndPort("192.168.235.8",7006));

        JedisCluster cluster = new JedisCluster(set);

        cluster.set("testJedisCluster","aaaaaa");

        String jedisCluster = cluster.get("testJedisCluster");
        System.out.println(jedisCluster);
        try {
            cluster.close();
        }catch (Exception e){

        }

    }
}
