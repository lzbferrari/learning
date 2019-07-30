package me.lzb.other.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by egan on 19/7/29
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> count = list.stream().reduce((a, b) -> (a + b));
        Integer count2 = list.stream().reduce(2, (a, b) -> (a * b));
        System.out.println(count.get());

    }


}
