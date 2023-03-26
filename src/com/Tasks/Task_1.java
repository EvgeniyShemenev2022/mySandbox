package com.Tasks;

/**
 * Написать программу, которая печатает шаблон (7*7) как этот:
 * 1000000
 * 0200000
 * 0030000
 * 0004000
 * 0000500
 * 0000060
 * 0000007
 */
public class Task_1 {

    public static void main(String[] args) {

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                if (j == i){
                    System.out.print(i);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
