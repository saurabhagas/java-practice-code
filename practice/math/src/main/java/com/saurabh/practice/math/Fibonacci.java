package com.saurabh.practice.math;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Count of fibonacci numbers to be printed? ");
        int n = scanner.nextInt();

        int first = 0;
        int second = 1;
        for (int i = 0; i <= n; i++) {
            System.out.println(first);
            int curr = first + second;
            first = second;
            second = curr;
        }
    }
}
