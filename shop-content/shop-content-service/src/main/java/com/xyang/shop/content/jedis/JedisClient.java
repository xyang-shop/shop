package com.xyang.shop.content.jedis;

/**
 * Created by Administrator on 2018/12/13 0013.
 */
public interface JedisClient {
    String set(String key, String value);
    String get(String key);
    /**
     *  检查给定key是否存在
     */
    Boolean exists(String key);

    /**
     * 设置key生存时间，当key过期时，它会被自动删除。
     * @param key
     * @param seconds
     * @return
     */
    Long expire(String key, int seconds);

    /**
     * 当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。
     * 否则，以毫秒为单位，返回 key 的剩余生存时间。
     * @param key
     * @return
     */
    Long ttl(String key);

    /**
     * key进行加1操作
     * @param key
     * @return
     */
    Long incr(String key);

    /**
     * 哈希表key中的域field的值设为value。
     * @param key
     * @param field
     * @param value
     * @return
     */
    Long hset(String key, String field, String value);

    /**
     * 返回哈希表key中给定域field的值
     * @param key
     * @param field
     * @return
     */
    String hget(String key, String field);

    /**
     * 删除哈希表key中的一个或多个指定域
     * @param key
     * @param field
     * @return
     */
    Long hdel(String key, String... field);

}
