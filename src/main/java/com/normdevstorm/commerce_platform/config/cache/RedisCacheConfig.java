package com.normdevstorm.commerce_platform.config.cache;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.time.Duration;

@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(BasicPolymorphicTypeValidator.builder().allowIfBaseType(Object.class).build(), ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(objectMapper);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30)).serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));


        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .serializeKeysWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(serializer))
                .disableCachingNullValues();

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfig)
                .withCacheConfiguration("products", cacheConfig.entryTtl(Duration.ofMinutes(2)))
                .build();

    }//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
//        redisConfig.setHostName(redisHost);
//        redisConfig.setPort(redisPort);
//        redisConfig.setUsername(redisUsername);
//        redisConfig.setPassword(redisPassword);
//        redisConfig.setDatabase(redisDatabase);
//
//        return new LettuceConnectionFactory(redisConfig);
//    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate( RedisConnectionFactory redisConnectionFactory){

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(BasicPolymorphicTypeValidator.builder().allowIfBaseType(Object.class).build(), ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(objectMapper);

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(serializer);
        return redisTemplate;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory(@Value("${spring.data.redis.host}") String host,
                                                         @Value("${spring.data.redis.port}") int port,
                                                         @Value("${spring.data.redis.database}") int database
    ) {

        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
        config.setDatabase(database);
        return new LettuceConnectionFactory(config);
    }
}