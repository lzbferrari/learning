package me.lzb.other.test.p;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T {

    public static void main(String[] args) {


        System.out.println(JSON.toJSONString("11111".split(",")));


        List<Father> list = new ArrayList<>();
        list.stream().collect(Collectors.toMap(Father::getFf, Function.identity()));
        list.stream().collect(Collectors.toMap(Father::getFf, Function.identity(), (key1, key2) -> key2));
    }
}
