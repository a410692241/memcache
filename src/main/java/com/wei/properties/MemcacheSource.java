package com.wei.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "memcache")
@Data
public class MemcacheSource {
    private String ip;
    private String port;


}
