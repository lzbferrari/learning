package me.lzb.algroithm.topk;

import me.lzb.common.utils.AlgroithmUtils;
import me.lzb.common.utils.OtherUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


/**
 * Created by lzb on 19/1/21
 */
public class TopkQuicksortTest {

    @Test
    public void getTopK() {
        int length = 100;
        int k = 20;
        long[] a = AlgroithmUtils.createRandomArray(length);
        long[] top = TopkQuicksort.getTopK(a, k);
        long[] actual = OtherUtils.cutTail(a, k);
        Assert.assertEquals(Arrays.toString(top), Arrays.toString(actual));
    }
}