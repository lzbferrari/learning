package me.lzb.common.utils;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by egan on 19/1/21
 */
public class AlgroithmUtils {

    /**
     * 创建一个长度为n，范围是0-n*2的不重复随机数组
     *
     * @param n 数组长度
     * @return
     */
    public static long[] createRandomArray(int n) {
        return new Random().longs(0, n * 2).distinct().limit(n).boxed().collect(Collectors.toList()).stream().mapToLong(t -> t).toArray();
    }

}
