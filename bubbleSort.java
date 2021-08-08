/*

Aim : Create Program For Bubble sort using Iterative and Recursive Approach.

Author : Jaimik Chauhan

*/

import java.io.*;
import java.util.*;

public class bubbleSort {
    static Scanner sc = new Scanner(System.in);
    static int[] a;

    // inserting elements into array
    static void getArray(int a[]) {
        System.out.println("Enter Array Elements : ");
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            a[i] = j;
            j--;
        }
    }

    // printing array elements
    static void printArray(int a[]) {
        System.out.println("Array Elements : \n");
        for (int i : a) {
            System.out.println(i);
        }
    }

    // bubble sort iterative approach
    static void iterativeBubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    // recurse method to swap elements
    static void recurse(int a[], int start, int end) {
        if (end < 0) {
            return;
        }
        if (start == end) {
            return;
        }
        if (a[start] > a[start + 1]) {
            int temp = a[start];
            a[start] = a[start + 1];
            a[start + 1] = temp;
        }
        recurse(a, start + 1, end);
    }

    // recursive Bubble sort
    static void recursiveBubbleSort(int a[], int start) {
        if (start >= a.length) {
            return;
        }

        recurse(a, 0, a.length - start - 1);

        recursiveBubbleSort(a, start + 1);
    }

    public static void main(String[] args) {
        int choice, size;
        boolean flag = true;
        long startTime, endTime;

        try {
            do {

                System.out.println("\n1. Iterative Approach");
                System.out.println("2. Recursive Approach");
                System.out.println("3. Exit");

                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.println("Enter Size Of Array : ");
                    size = sc.nextInt();

                    a = new int[size];

                    getArray(a);

                    startTime = new Date().getTime();
                    System.out.println();

                    iterativeBubbleSort(a);

                    endTime = new Date().getTime();

                    printArray(a);

                    System.out.format("Starting Time : " + startTime + " Millisecond \n");
                    System.out.println("Ending Time : " + endTime + " Millisecond");
                    System.out.println("Total Execution Time : " + (endTime - startTime) + " Millisecond");
                } else if (choice == 2) {

                    System.out.println("Enter Size Of Array : ");
                    size = sc.nextInt();

                    a = new int[size];
                    getArray(a);

                    startTime = new Date().getTime();
                    System.out.println();

                    recursiveBubbleSort(a, 0);

                    endTime = new Date().getTime();

                    printArray(a);

                    System.out.format("Starting Time : " + startTime + " Millisecond \n");
                    System.out.println("Ending Time : " + endTime + " Millisecond");
                    System.out.println("Total Execution Time : " + (endTime - startTime) + " Millisecond");

                } else {

                    flag = false;
                }
            } while (flag);

        } catch (Exception e) {
            System.out.println("Enter Numeric Value Only");
        }
    }
}
