/*

Aim : Create Program For Selection sort using Iterative and Recursive Approach.

Author : Jaimik Chauhan

*/

import java.io.*;
import java.util.*;
// import com.google.common.base.Stopwatch;

class selectionSort {
    static int[] a;
    static Scanner sc = new Scanner(System.in);

    // take array input
    static void getArray(int a[]) {
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            a[i] = j;
            j--;
        }
    }

    // print array elements
    static void printArray(int a[]) {
        System.out.println("Array Elements : \n");
        for (int i : a) {
            System.out.println(i + " ");
        }
    }

    // selection sort iterative approach
    static void iterateSelectionSort(int a[]) {

        for (int i = 0; i < a.length - 1; i++) {
            int min_index = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            int temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }
    }

    // find min index for recursive function
    static int minIndex(int a[], int i, int j) {
        if (i == j)
            return i;

        int k = minIndex(a, i + 1, j);

        return a[k] < a[i] ? k : i;
    }

    // recursive selection sort
    static void recursiveSelectionSort(int a[], int start) {
        if (start == a.length - 1)
            return;

        int minInd = minIndex(a, start, a.length - 1);

        if (minInd != start) {
            int temp = a[minInd];
            a[minInd] = a[start];
            a[start] = temp;
        }
        recursiveSelectionSort(a, start + 1);
    }

    public static void main(String[] args) {
        int choice, size;

        boolean flag = true;

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

                    long startTime = new Date().getTime();
                    System.out.println();

                    iterateSelectionSort(a);
                    long endTime = new Date().getTime();

                    printArray(a);

                    System.out.format("Starting Time : " + startTime + " Millisecond \n");
                    System.out.println("Ending Time : " + endTime + " Millisecond");
                    System.out.println("Total Execution Time : " + (endTime - startTime) + " Millisecond");
                } else if (choice == 2) {

                    System.out.println("Enter Size Of Array : ");
                    size = sc.nextInt();

                    a = new int[size];
                    getArray(a);

                    // Instant startTime = java.time.Instant.now();
                    // long startTime = System.currentTimeMillis();
                    long startTime = new Date().getTime();
                    System.out.println();
                    recursiveSelectionSort(a, 0);

                    long endTime = new Date().getTime();
                    // long endTime = System.currentTimeMillis();
                    // Instant endTime = java.time.Instant.now();
                    // Duration bet = java.time.Duration.between(startTime, endTime);
                    // System.out.format("Ending Time : .%04d", bet.toMillis());
                    printArray(a);

                    System.out.format("Starting Time : " + startTime + "Millisecond \n");
                    System.out.println("Ending Time : " + endTime + " Millisecond");
                    System.out.println("Total Execution Time : " + (endTime - startTime) + " Millisecond");
                } else {

                    flag = false;
                }
            } while (flag);

        } catch (Exception e) {
            System.out.println("Enter Numeric Value Only.");
        }
    }
}