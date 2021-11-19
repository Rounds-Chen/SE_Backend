package com.rounds.experimentalteachingsystm;


import org.springframework.boot.autoconfigure.cache.CacheProperties;
import redis.clients.jedis.Jedis;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("106.14.97.109",6379);
        jedis.auth("tssgrgxz");	// redis密码
        System.out.println(jedis.ping());	// 结果输出应该为：PONG
    }

}
