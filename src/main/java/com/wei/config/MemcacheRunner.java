package com.wei.config;

import com.wei.properties.MemcacheSource;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MemcacheRunner  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MemcacheSource memcacheSource;
    private MemCachedClient client;

    @Bean
    public SockIOPool sockIOPool() {
        SockIOPool pool = SockIOPool.getInstance();
        String[] servers = new String[]{memcacheSource.getIp() + ":" + memcacheSource.getPort()};
        pool.setServers(servers);
        pool.initialize();
        return pool;
    }

    @Bean
    public MemCachedClient getClient() {
        return new MemCachedClient();
    }

}
