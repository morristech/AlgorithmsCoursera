package com.dagger.weekTwo.stackAndQueue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Harshit on 22/12/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n = 0;

    public Deque() {

    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation not permitted");
            }

            @Override
            public Item next() {
                if (current == null) {
                    throw new NoSuchElementException("Reached the end of the queue");
                }
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private class Node {
        private Item item;
        private Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(Item i) {
        if (i == null)
            throw new NullPointerException("Can't enter null element to the queue");
        if (first == null) {
            first = new Node(i);
            last = first;
            n++;
            return;
        }
        Node newNode = new Node(i);
        newNode.next = first;
        first = newNode;
        n++;
    }

    public void addLast(Item i) {
        if (i == null)
            throw new NullPointerException("Can't enter null element to the queue");

        if (first == null) {
            first = new Node(i);
            last = first;
            n++;
            return;
        }
        if (last == null) {
            first.next = new Node(i);
            last = first.next;
            n++;
            return;
        }
        last.next = new Node(i);
        last = last.next;
        n++;
    }

    public Item removeFirst() {
        if (n == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        Node temp = first.next;
        Item firstItem = first.item;
        first.next = null;
        first = temp;
        n--;
        return firstItem;
    }

    public Item removeLast() {
        if (n == 0)
            throw new NoSuchElementException("Queue is empty");
        else if (n == 1) {
            Item item = first.item;
            first = null;
            n--;
            return item;
        }
        Item item = last.item;
        Node test = first;
        while (true) {
            if (test.next.next == null) {
                test.next = null;
                last = test;
                n--;
                return item;
            }
            test = test.next;
        }
    }

    public int size() {
        return n;
    }


    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("M");
        deque.addFirst("H");
        deque.addFirst("L");
        deque.removeLast();
        deque.addFirst("y");
        deque.addFirst("I");
        deque.addFirst("P");
        deque.removeLast();
        StdOut.println(deque.isEmpty());
//        deque.removeFirst();
//        deque.removeFirst();
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            StdOut.println(iterator.next());
        }
//        deque.addLast("P");
//        deque.addLast("K");
//        deque.addLast("L");
//        Iterator<String> iterator2 = deque.iterator();
        StdOut.println(deque.size());
    }

}
