package com.springbootpostgres.springbootpostgrespractise.util;

public class MultiDimensionalArray {

    public static void main(String[] args) {
        int[][] num = new int[3][4];
        int[][] num2 = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i=0; i < num.length; i++){
            for (int j=0; j < num[i].length; j++){
                System.out.print(num[i][j]+ " ");
            }
            System.out.println();
        }
        for (int[] x:num2){
            for (int y: x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
