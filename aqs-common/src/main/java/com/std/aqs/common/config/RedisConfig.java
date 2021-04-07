package com.std.aqs.common.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;


@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * spring cache管理缓存
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                // 默认策略，未配置的 key 会使用这个
                this.getRedisCacheConfigurationWithTtl(Duration.ofSeconds(120)),

                // 指定 key 策略
                this.getRedisCacheConfigurationMap()
        );

    }

    /**
     * 配置key缓存失效策略
     *
     * @return
     */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("test", this.getRedisCacheConfigurationWithTtl(Duration.ofSeconds(60)));
        return redisCacheConfigurationMap;
    }

    /**
     * 缓存策略
     *
     * @param duration
     * @return
     */
    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Duration duration) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(this.redisSerializer())
        ).entryTtl(duration);

        return redisCacheConfiguration;
    }

    /**
     * 定义 StringRedisTemplate ，指定序列化和反序列化的处理类
     *
     * @param factory
     * @return
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        //序列化 值时使用此序列化方法
        template.setValueSerializer(this.redisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 序列化
     *
     * @return
     */
    private Jackson2JsonRedisSerializer<Object> redisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
                Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }
}