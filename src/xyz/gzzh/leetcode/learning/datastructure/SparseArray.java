package xyz.gzzh.leetcode.learning.datastructure;

public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        //输出原棋盘数据
        System.out.println("原棋盘数组");
        for (int[] ints : chessArray) {
            for (int data : ints) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //获取行数，列数，个数
        int rowCount = chessArray.length;
        int columnCount = chessArray[0].length;
        int dataCount = 0;
        for (int[] ints : chessArray) {
            for (int data : ints) {
                if (data != 0) {
                    dataCount++;
                }
            }
        }

        System.out.printf("row count = %d , column count = %d , data count = %d\n", rowCount, columnCount, dataCount);

        System.out.println("\n打印稀疏数组，原棋盘数组 --> 稀疏数组");
        //初始化稀疏数组
        int[][] sparseArray = new int[dataCount + 1][3];

        //稀疏数组赋值
        sparseArray[0][0] = rowCount;
        sparseArray[0][1] = columnCount;
        sparseArray[0][2] = dataCount;

        int sparseRow = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseRow++;
                    sparseArray[sparseRow][0] = i;
                    sparseArray[sparseRow][1] = j;
                    sparseArray[sparseRow][2] = chessArray[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("行\t列\t值");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        //稀疏数组还原
        int[][] restoreArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            restoreArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //打印还原稀疏数组
        System.out.println("\n打印还原数组，稀疏数组 --> 原棋盘数字");
        for (int[] ints : restoreArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
