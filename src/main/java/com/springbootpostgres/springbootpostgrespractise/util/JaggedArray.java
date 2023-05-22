package com.springbootpostgres.springbootpostgrespractise.util;

public class JaggedArray {
    public static void main(String[] args) {
        int[][] num = new int[5][];
        num[0] = new int[6];
        num[1] = new int[4];
        num[2] = new int[8];
        num[3] = new int[12];
        num[4] = new int[3];
        System.out.println("Size of outer Array: "+num.length);
        for(int i=0;i < num.length; i++){
            System.out.println("Size of Inner Array "+i+": " +num[i].length);
        }
    }
}
