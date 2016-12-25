package com.dagger.weekTwo.stackAndQueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by Harshit on 24/12/16.
 */
public class Subset {

    public static void main(String[] args) {
        int i = 0;

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        String in = StdIn.readString();

        String[] arr = in.split(" ");

        while (i < arr.length)
            randomizedQueue.enqueue(arr[i++]);

        Iterator<String> iterator = randomizedQueue.iterator();

        int k = Integer.parseInt(args[0]);

        while (i <= k) {
            i++;
            StdOut.println(iterator.next());
        }
    }

}
