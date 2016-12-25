package com.dagger.weekTwo.stackAndQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Harshit on 23/12/16.
 */

@SuppressWarnings("unchecked")
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int curr = 0;
    private Item[] array;

    public RandomizedQueue() {
        array = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return curr == 0;
    }

    public int size() {
        return curr;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException("Can't enter null element to the queue");
        array[curr] = item;
        curr++;
        if (curr >= array.length) {
            resize(array.length);
        }
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[2 * length];
        System.arraycopy(array, 0, temp, 0, length);
        array = temp;
    }

    public Item sample() {
        if (curr == 0)
            throw new NoSuchElementException("Queue is empty");
        StdRandom.shuffle(array, 0, curr - 1);
        return array[0];
    }

    public Item dequeue() {
        if (curr == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int position = StdRandom.uniform(0, curr);
        Item removedItem = array[position];
        array[position] = null;
        for (int i = position; i < curr - 1; i++) {
            array[i] = array[i + 1];
        }
        if (curr < array.length / 4)
            shrink();
        curr--;
        return removedItem;
    }

    private void shrink() {
        Item[] testArray = (Item[]) new Object[array.length / 2];
        System.arraycopy(array, 0, testArray, 0, curr);
        array = testArray;
    }

    @Override
    public Iterator<Item> iterator() {

        Item[] temp = array;

        if (curr > 1)
            StdRandom.shuffle(temp, 0, curr - 1);

        return new Iterator<Item>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < curr;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation not permitted");
            }

            @Override
            public Item next() {
                if (i < curr)
                    return temp[i++];
                else
                    throw new NoSuchElementException("Reached the end of the queue");
            }
        };
    }

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("H");
        randomizedQueue.enqueue("K");
        randomizedQueue.enqueue("L");
        randomizedQueue.enqueue("P");
        randomizedQueue.enqueue("D");
        randomizedQueue.enqueue("O");
        Iterator<String> iterator2 = randomizedQueue.iterator();

        while (iterator2.hasNext()) {
            StdOut.println("I2 " + iterator2.next());
        }
    }
}
