package com.dagger.weekTwo.stackAndQueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by Harshit on 24/12/16.
 */
public class Subset {

    public static void main(String[] args) {
        int k = StdIn.readInt();
        int N = StdIn.readInt();
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        int i = 0;
        while (i < N){
            randomizedQueue.enqueue(StdIn.readString());
            i++;
        }
        i = 0;

        Iterator<String> iterator = randomizedQueue.iterator();
        while (i < k){
            i++;
            StdOut.println(iterator.next());
        }
    }

}
