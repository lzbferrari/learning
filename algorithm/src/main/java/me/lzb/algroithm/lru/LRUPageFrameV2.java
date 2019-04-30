package me.lzb.algroithm.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * High-Throughput, Thread-Safe, LRU Caching
 *
 * 参考
 * https://blog.csdn.net/maoyeqiu/article/details/50502410
 *
 * Created by LZB on 19/4/17
 */
public class LRUPageFrameV2 {


    private static Map<String, Object> map = new ConcurrentHashMap<>(100000, 1);








}
