package com.dagger.weekTwo.sorts;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by Harshit on 14/01/17.
 */
public class AllInOneSort {
    public static void main(String[] args) {
        StdOut.print("\nEnter the number of elements to sort\n");
        int n = StdIn.readInt();
        int[] a = new int[n];
        int i = 0;
        while (i < n) {
            a[i++] = StdIn.readInt();
        }
        StdOut.print("\nEnter the sort to perform :\n1. Selection\n2. Insertion\n3. Shell\n4. Shuffle\n");
        int choice = StdIn.readInt();
        switch (choice) {
            case 1:
                a = selecionSort(a);
                break;
            case 2:
                a = insertionSort(a);
                break;
            case 3:
//                a = shellSort(a);
                break;
            case 4:
                a = shuffle(a);
                break;
            default:
                StdOut.print("Unexpected Input");
        }
        StdOut.println("\nThe output is :\n");
        for (int j = 0; j < n; j++)
            StdOut.println(a[j]);
    }

    private static int[] selecionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] <= a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }

    private static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] <= a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else
                    break;
            }
        }
        return a;
    }

//    private static int[] shellSort(int[] a) {
//        int h = 1;
//        while (h < a.length / 3) {
//            h = 3 * h + 1;
//        }
//        while (h >= 1) {
//            for (int i = h; i < a.length; i++) {
//                for (int j = i; j > h; j -= h) {
//                    if (a[j] >)
//                }
//            }
//        }
//        return a;
//    }

    private static int[] shuffle(int[] a) {
        for (int i=1;i<a.length;i++){
            int r = StdRandom.uniform(0,i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        return a;
    }
}
