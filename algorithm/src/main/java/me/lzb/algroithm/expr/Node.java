package me.lzb.algroithm.expr;

/**
 * @author LZB
 */
public class Node {
    float number;
    String symbol;
    int calLevel;//加减1，乘除2, ()3, 数字-1

    public Node(float number, String symbol, int calLevel) {
        this.number = number;
        this.symbol = symbol;
        this.calLevel = calLevel;
    }

    public boolean isLevel2() {
        return calLevel == 2;
    }

    public boolean isLevel3() {
        return calLevel == 3;
    }

    public boolean isNumber() {
        return calLevel == -1;
    }
}
