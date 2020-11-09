package me.lzb.algroithm.Interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在一个长度为n的数组里的所有数字都在0->n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，输入长度为7的数字{2,3,1,0,2,5,3}，输出2或者3
 */
public class RepeatedNumber {


    public static int hasRepeatedNumber(int[] numberArray) {
        if (numberArray == null || numberArray.length <= 1) {
            return -1;
        }

        for (int i = 0; i < numberArray.length; i++) {
            while (i != numberArray[i]) {
                //下标越界问题
                if(numberArray[i] < 0 || numberArray[i] > numberArray.length - 1){
                    break;
                }
                if(numberArray[i] == numberArray[numberArray[i]]){
                    return numberArray[i];
                }

                int a = numberArray[numberArray[i]];
                numberArray[numberArray[i]] = numberArray[i];
                numberArray[i] = a;
            }
        }
        return -1;
    }
//
//    /**
//     * 不改变原数组，二分查找法
//     * @param numberArray
//     * @return
//     */
//
//    public static int hasRepeatedNumber(int[] numberArray) {
//        if (numberArray == null || numberArray.length <= 1) {
//            return -1;
//        }
//
//        int start = 0;
//        int end = numberArray.length - 1;
//        while (start <= end){
//            int middle = ((end - start) >> 1) + start;
//
//        }
//
//    }


    @Test
    public void hasTest(){
        int a = hasRepeatedNumber(new int[]{2,3,1,0,2,5,3});
        Assert.assertTrue(a ==2 || a == 3);
    }
    @Test
    public void notHasTest(){
        int a = hasRepeatedNumber(new int[]{6,4,1,0,2,5,3});
        Assert.assertEquals(-1, a);
    }

    @Test
    public void outOfBoundTest(){
        int a = hasRepeatedNumber(new int[]{2,4,-1,0,2,5,3});
        Assert.assertEquals(2, a);

    }
}
