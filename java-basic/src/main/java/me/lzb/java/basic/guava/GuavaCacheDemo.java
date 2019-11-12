package me.lzb.java.basic.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by lzb on 19/11/7
 */
public class GuavaCacheDemo {

    Cache<String, Object> cache = CacheBuilder.newBuilder().maximumSize(100000).expireAfterWrite(10, TimeUnit.MINUTES).build();


}
