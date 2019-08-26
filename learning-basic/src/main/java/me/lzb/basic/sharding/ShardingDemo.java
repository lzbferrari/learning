package me.lzb.basic.sharding;

import java.util.*;

/**
 * 在每天产生的数据量变化不大的情况下，多级分片策略
 * Created by lzb on 19/8/26
 */
public class ShardingDemo {


    /**
     * 一级队列数量
     */
    private static final int LEVEL_1_COUNT = 16;

    /**
     * 二级队列数量
     */
    private static final int LEVEL_2_COUNT = 64;


    public static void main(String[] args) {
        Map<String, Integer> level1Map = getMap(LEVEL_1_COUNT);
        Map<String, Map<String, Integer>> level2Map = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            int a = getRandom();
            String key = getMinKey(level1Map);
            add(level1Map, key, a);

            Map<String, Integer> l2M = level2Map.get(key);
            if (l2M == null) {
                l2M = getMap(LEVEL_2_COUNT);
                level2Map.put(key, l2M);
            }
            String l2Key = getMinKey(l2M);
            add(l2M, l2Key, a);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList(level1Map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        list.forEach(entry -> {
            System.out.println("Q:" + entry.getKey() + " --> " + entry.getValue());
            print(level2Map.get(entry.getKey()), "      ");

        });
    }


    private static void print(Map<String, Integer> map, String tab) {

        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        StringBuilder s = new StringBuilder(tab);
        list.forEach(e -> {
            s.append(e.getValue().toString()).append(" -> ");
        });
        System.out.println(s.toString());
    }

    private static Map<String, Integer> getMap(int size) {
        Map<String, Integer> map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            map.put(String.valueOf(i), 0);
        }
        return map;
    }

    private static String getMinKey(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        return list.get(0).getKey();
    }

    public static void add(Map<String, Integer> map, String key, int a) {
        int b = map.get(key) + a;
        map.put(key, b);
    }


    private static int getRandom() {
        Random random = new Random();
        return random.nextInt(100);
    }


}
