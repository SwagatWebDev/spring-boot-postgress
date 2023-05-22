package com.springbootpostgres.springbootpostgrespractise.util;

import java.util.Scanner;

public class ReportCard {

    public static void main(String[] args) {
        getReportCard();
    }

    static void getReportCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name:");
        String name = sc.next();
        System.out.println("Enter Number of Subjects:");
        int subjectCount = sc.nextInt();
        int subjectMark = 100;

        int[] marks = new int[subjectCount];

        for (int i=0; i < marks.length; i++){
            System.out.println("Enter Mark Obtained on Subject:"+ (i+1));
            marks[i] = sc.nextInt();
        }
        System.out.println("------------------------------------");
        System.out.println("\t\tREPORT CARD");
        System.out.println("Name:" +name);
        System.out.println("------------------------------------");
        System.out.println("SUBJECT \t\t MARKS");
        System.out.println("------------------------------------");

        int total = 0;
        for(int i = 0; i < marks.length; i++){
            total = total+marks[i];
            System.out.println("Subject-"+ (i+1) + "\t\t  " +marks[i]);
        }

        System.out.println("------------------------------------");
        float avg = ((float) total/ subjectCount);
        System.out.printf("Total: %d \t Average: %.2f\n", total, avg);
        System.out.println("------------------------------------");
        float percent = ((float) total / (subjectCount*subjectMark))*100;
        System.out.printf("Percentage: " +percent +"\n");
        System.out.println("------------------------------------");
    }

}
