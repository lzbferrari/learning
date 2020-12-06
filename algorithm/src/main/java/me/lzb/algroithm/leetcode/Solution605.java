package me.lzb.algroithm.leetcode;

public class Solution605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int a = 0;
        boolean pre = true;
        boolean thisBed = true;
        boolean next = true;

        for(int i = 0; i < flowerbed.length; i++){
            if(i - 1 >= 0){
                pre = flowerbed[i - 1] == 0;
            }

            if(i + 1 < flowerbed.length){
                next = flowerbed[i+1] == 0;
            }else if(i + 1 == flowerbed.length){
                next = true;
            }

            thisBed = flowerbed[i] == 0;
            if(thisBed && pre && next){
                flowerbed[i] = 1;
                a = a + 1;
            }
            if(a == n){
                break;
            }
        }
        return a == n;
    }

    public static void main(String[] args) {
        int[] f = new int[] {1,0,0,0,0,1};
        boolean b = canPlaceFlowers(f, 2);
        System.out.println(b);
    }

}
