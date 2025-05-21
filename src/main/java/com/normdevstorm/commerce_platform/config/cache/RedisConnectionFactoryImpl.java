//package com.normdevstorm.commerce_platform.config.cache;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisClusterConnection;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisSentinelConnection;
//
//public class RedisConnectionFactoryImpl implements RedisConnectionFactory {
//    @Bean
//    public RedisConnectionFactory connectionFactory(){
//        return new RedisConnectionFactoryImpl();
//    };
//
//    @Override
//    public boolean getConvertPipelineAndTxResults() {
//        return false;
//    }
//
//    @Override
//    public RedisConnection getConnection() {
//        return null;
//    }
//
//    @Override
//    public RedisClusterConnection getClusterConnection() {
//        return null;
//    }
//
//    @Override
//    public RedisSentinelConnection getSentinelConnection() {
//        return null;
//    }
//
//    @Override
//    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
//        return null;
//    }
//}
