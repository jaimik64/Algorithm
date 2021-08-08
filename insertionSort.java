/*

Aim : Create Program For Insertion sort using Iterative and Recursive Approach.

Author : Jaimik Chauhan

*/

import java.io.*;
import java.util.*;

class insertionSort {

    static int[] a;
    static Scanner sc = new Scanner(System.in);

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
        System.out.println("Printing Elements : \n");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // iterative approach
    static void iterativeInsertionSort(int a[]) {
        int key = 0;

        for (int i = 0; i < a.length; i++) {
            key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    // method to return index of j
    static int recurse(int a[], int j, int key) {
        if (j < 0) {
            return j;
        }
        if (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            return recurse(a, j - 1, key);
        }
        return j;
    }

    // recursive insertion sort
    static void recursiveInsertionSort(int a[], int start) {
        if (start >= a.length) {
            return;
        }

        int key = a[start];
        int j = recurse(a, start - 1, key);

        a[j + 1] = key;

        recursiveInsertionSort(a, start + 1);
    }

    public static void main(String[] args) {
        boolean flag = true;
        long startTime, endTime;

        do {
            System.out.println("\n1. Iterative Approach");
            System.out.println("2. Recursive Approach");
            System.out.println("3. Exit\n");

            System.out.println("Enter Choice : ");
            int size, choice = sc.nextInt();

            switch (choice) {
            case 1:

                System.out.println("Enter Size Of an array : ");
                size = sc.nextInt();
                a = new int[size];

                getArray(a);

                startTime = new Date().getTime();
                System.out.println();

                iterativeInsertionSort(a);

                endTime = new Date().getTime();

                printArray(a);

                System.out.format("Starting Time : " + startTime + " Millisecond \n");
                System.out.println("Ending Time : " + endTime + " Millisecond");
                System.out.println("Total Execution Time : " + (endTime - startTime) + " Millisecond");
                break;

            case 2:
                System.out.println("Enter Size Of an array : ");
                size = sc.nextInt();
                a = new int[size];

                getArray(a);

                startTime = new Date().getTime();
                System.out.println();

                recursiveInsertionSort(a, 0);

                endTime = new Date().getTime();
                printArray(a);

                System.out.format("Starting Time : " + startTime + " Millisecond \n");
                System.out.println("Ending Time : " + endTime + " Millisecond");
                System.out.println("Total Execution Time : " + (endTime - startTime) + " Millisecond");
                break;
            case 3:
                flag = false;
                break;
            default:
                System.out.println("Enter Correct Choice");
                break;
            }
        } while (flag);
    }
}
