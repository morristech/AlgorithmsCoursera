package com.dagger.weekOne;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Harshit on 18/12/16.
 */
public class Percolation {

    static int[][] a;

    WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                a[i][j] = 0;
            }
        }
        Stack stack = new Stack();
    }

    public void open(int row, int col)       // open site (row, col) if it is not open already
    {

    }

    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        return false;
    }

    public boolean isFull(int row, int col) // is site (row, col) full?
    {
        return false;
    }

    public boolean percolates()              // does the system percolate?
    {
        return false;
    }

    public static void main(String[] args)   // test client (optional)
    {
        Percolation percolation = new Percolation(5);
        System.out.print("" + a[0][1]);
    }
}
