package me.lzb.algroithm.Interview;

/**
 * 本题要求将给定的 N 个正整数按非递增的顺序，填入“螺旋矩阵”。
 * 所谓“螺旋矩阵”，是指从左上角第 1 个格子开始，按顺时针螺旋方向填充。
 * 要求矩阵的规模为 m 行 n 列，满足条件：m×n 等于 N；m≥n；且 m−n 取所有可能值中的最小值。
 * 输入格式：
 * 输入在第 1 行中给出一个正整数 N，第 2 行给出 N 个待填充的正整数。
 * <p>
 * 输出格式：
 * 输出螺旋矩阵。每行 n 个数字，共 m 行。相邻数字以 1 个空格分隔，行末不得有多余空格。
 * 输入样例：
 * 12
 * 37 76 20 98 76 42 53 95 60 81 58 93
 * 输出
 * 98 95 93
 * 42 37 81
 * 53 20 76
 * 58 60 76
 * <p>
 * Created by lzb on 19/2/11
 */
public class HelixMatrix {

    public static void main(String[] args) {

        int[] array = {37, 76, 20, 98, 76, 42, 53, 95, 60, 81, 58, 93};

        sort(array, 0, array.length - 1);

        int[][] matrix = createHelixMatrix(array);

        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.print("\r\n");//换行
        }
    }


    /**
     * 输出螺旋矩阵
     *
     * @param array
     */
    private static int[][] createHelixMatrix(int[] array) {
        int size = array.length;
        int[] rowColumn = factorization(size);
        int[][] matrix = new int[rowColumn[0]][rowColumn[1]];
        fillMatrix(matrix, array, array.length - 1, 0);
        return matrix;
    }


    /**
     * 填充矩阵
     *
     * @param matrix
     * @param array
     * @param arrayIndex
     */
    private static void fillMatrix(int[][] matrix, int[] array, int arrayIndex, int loopIndex) {
        if (arrayIndex < 0) {
            return;
        }

        int r = matrix.length - loopIndex - loopIndex;
        int c = matrix[0].length - loopIndex - loopIndex;

        //右
        //横坐标不变，纵坐标增加
        int idx1 = loopIndex;
        for (int i = 0; i < c; i++) {
            matrix[idx1][loopIndex + i] = array[arrayIndex];
            arrayIndex = arrayIndex - 1;
        }

        //下
        //纵坐标不变，横坐标增加
        int idx2 = matrix[0].length - 1 - loopIndex;
        for (int i = 1; i < r; i++) {
            matrix[loopIndex + i][idx2] = array[arrayIndex];
            arrayIndex = arrayIndex - 1;
        }

        //左
        //横坐标不变，纵坐标减少
        int idx3 = matrix.length - 1 - loopIndex;
        for (int i = 1; i < c; i++) {
            matrix[idx3][matrix[0].length - 1 - loopIndex - i] = array[arrayIndex];
            arrayIndex = arrayIndex - 1;
        }

        //上
        //纵坐标不变，横坐标减少
        int idx4 = loopIndex;
        for (int i = 1; i < r - 1; i++) {

            matrix[matrix.length - 1 - loopIndex - i][idx4] = array[arrayIndex];
            arrayIndex = arrayIndex - 1;
        }

        loopIndex = loopIndex + 1;

        fillMatrix(matrix, array, arrayIndex, loopIndex);
    }

    /**
     * 因式分解，获取差最小的两个因数
     * 试除法
     *
     * @param product
     * @return
     */
    private static int[] factorization(int product) {
        int m = product;
        int n = product / m;

        int c = m - n;

        int tmpM = m;
        int tmpN = n;

        while (tmpM >= tmpN) {
            tmpM = tmpM - 1;

            if (tmpM < 1) {
                break;
            }
            int remainder = product % tmpM;
            if (remainder != 0) {
                continue;
            }

            tmpN = product / tmpM;

            if (tmpM < tmpN) {
                break;
            }

            int tmpC = tmpM - tmpN;
            if (tmpC > c) {
                break;
            }

            m = tmpM;
            n = product / m;
            tmpN = n;
        }
        int[] rowColumn = new int[2];
        rowColumn[0] = m;
        rowColumn[1] = n;
        return rowColumn;
    }


    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int i = lo;
        int j = hi;
        //切分元素就选数组头部的元素
        int v = a[lo];

        while (i != j) {
            //先从右边找一个放到左边
            while (j > i) {
                if (a[j] < v) {
                    a[i] = a[j];
                    break;
                }
                j--;
            }
            //再从左边找一个放到右边
            while (i < j) {
                if (a[i] > v) {
                    a[j] = a[i];
                    break;
                }
                i++;
            }
        }

        a[i] = v;
        sort(a, j + 1, hi);
        sort(a, lo, j - 1);
    }
}
