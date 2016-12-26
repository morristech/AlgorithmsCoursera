package com.dagger.weekTwo.stackAndQueue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Harshit on 24/12/16.
 */
public class Subset {

    public static void main(String[] args) {
        int i = 0;

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        while(!StdIn.isEmpty()){
            randomizedQueue.enqueue(StdIn.readString());

        }


        Iterator<String> iterator = randomizedQueue.iterator();

        int k = Integer.parseInt(args[0]);

        while (i < k) {
            StdOut.println(iterator.next());
            i++;
        }
    }

}
