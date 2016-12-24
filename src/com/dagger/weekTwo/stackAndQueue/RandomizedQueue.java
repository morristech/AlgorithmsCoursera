package com.dagger.weekTwo.stackAndQueue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Harshit on 23/12/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    int curr = 0;
    private Item[] array;

    public RandomizedQueue() {
        array = (Item[]) new Object[2];
    }

    public boolean isEmpty(){
        return curr == 0;
    }

    public int size(){
        return curr;
    }

    public void enqueue(Item item){
        if (item == null)
            throw new NullPointerException("Can't enter null element to the queue");
        array[curr] = item;
        curr++;
        if(curr >= array.length){
            resize(array.length);
        }
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[2 * length];
        for (int i = 0; i < length ; i++){
            temp[i] = array[i];
        }
        array = temp;//        StdOut.println("Resized");
    }

    public Item sample(){
        if (curr == 0)
            throw new NoSuchElementException("Queue is empty");
        StdRandom.shuffle(array,0,curr-1);
        return array[0];
    }

    public Item dequeue(){
        if (curr == 0){
            throw new NoSuchElementException("Queue is empty");
        }
        int position = StdRandom.uniform(0,curr);
        Item removedItem = array[position];
        array[position] = null;
        for(int i = position;i < curr - 1;i++){
            array[i] = array[i + 1];
        }
        curr--;
        return removedItem;
    }

    @Override
    public Iterator<Item> iterator() {

        StdRandom.shuffle(array,0,curr-1);

        return new Iterator<Item>() {

            int i = 0;

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
                if(i < curr)
                    return array[i++];
                else
                    throw new NoSuchElementException("Reached the end of the queue");
            }
        };
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(5);
        randomizedQueue.enqueue(6);
        randomizedQueue.enqueue(8);
        randomizedQueue.enqueue(10);
        randomizedQueue.enqueue(11);
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        StdOut.println("Size of the queue is " + randomizedQueue.size());
        Iterator<Integer> iterator = randomizedQueue.iterator();
        while (iterator.hasNext()) {
            StdOut.println(iterator.next());
        }
    }
}
