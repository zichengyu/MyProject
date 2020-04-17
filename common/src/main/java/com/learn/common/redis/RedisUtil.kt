package com.learn.common.redis

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.script.DefaultRedisScript
import org.springframework.stereotype.Component
import java.util.Collections

@Component
class RedisUtil(
    private val redisTemplate: RedisTemplate<String, String>
) {

    /**
     * 通过lua脚本 加锁并设置过期时间
     * @param key 锁key值
     * @param value 锁value值
     * @param expire 过期时间，单位秒
     * @return true：加锁成功，false：加锁失败
     */
    fun getLock(key: String, value: String, expire: Long): Boolean {
        val redisScript = DefaultRedisScript<String>()
        redisScript.resultType = String::class.java
        var strScript = ""
        strScript += "if redis.call('setNx',KEYS[1],ARGV[1])==1 then "
        strScript += "  return redis.call('expire',KEYS[1],ARGV[2]) "
        strScript += "else"
        strScript += "  return 0 "
        strScript += "end "
        redisScript.setScriptText(strScript)
        try {
            val result = this.redisTemplate.execute(
                redisScript,
                redisTemplate.stringSerializer,
                redisTemplate.stringSerializer,
                Collections.singletonList(key),
                value,
                expire
            )
            println("redis get lock返回：$result")
            return "1" == "" + result
        } catch (e: Exception) {
            println { "分布式锁获取失败,key: $key, value: $value, expire: $expire}, ex: $e" }
            return false
        }
    }

    /**
     * 通过lua脚本释放锁
     * @param key 锁key值
     * @param value 锁value值（仅当redis里面的value值和传入的相同时才释放，避免释放其他线程的锁）
     * @return true：释放锁成功，false：释放锁失败（可能已过期或者已被释放）
     */
    fun releaseLock(key: String, value: String) {
        val redisScript = DefaultRedisScript<String>()
        redisScript.resultType = String::class.java
        var strScript = ""
        strScript += "if redis.call('get',KEYS[1]) == ARGV[1] then "
        strScript += "    return redis.call('del',KEYS[1]) "
        strScript += "else "
        strScript += "    return 0 "
        strScript += "end "
        redisScript.setScriptText(strScript)
        try {
            val result = this.redisTemplate.execute(
                redisScript,
                redisTemplate.stringSerializer,
                redisTemplate.stringSerializer,
                Collections.singletonList(key),
                value
            )
        } catch (e: Exception) {
            println { "分布式锁释放失败,key: $key, value: $value, ex: $e" }
        }
    }
}
