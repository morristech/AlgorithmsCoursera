package com.dagger.weekTwo;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

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

            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private class Node{
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void addFirst(Item i){
        Node newNode = new Node(i);
        newNode.next = first;
        first = newNode;
        n++;
    }

    public void addLast(Item i){
        if(last == null){
            Node newNode = new Node(i);
            first.next = newNode;
            last = first.next;
            n++;
            return;
        }
        Node newNode = new Node(i);
        last.next = newNode;
        last = last.next;
        n++;
    }

    public Item removeFirst() {
        if(n == 0){
            return null;
        }
        Item firstItem = first.item;
        first = first.next;
        n--;
        return firstItem;
    }

    public Item removeLast(){
        if(n == 0)
            return null;
        else if (n == 1){
            Item item = first.item;
            first = null;
            n--;
            return item;
        }
        Item item = last.item;
        Node test = first;
        while (true){
            if(test.next.next == null){
                test.next = null;
                last = test;
                n--;
                return item;
            }
            test = test.next;
        }
    }

    public int size(){
        return n;
    }

    public void print(){
        Node test = first;
        while(test != null){
            StdOut.print(test.item);
            test = test.next;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(1);
        deque.addFirst(7);
        deque.addLast(8);
//        deque.removeFirst();
//        deque.removeFirst();
//        deque.removeFirst();
//        deque.removeFirst();
//        deque.removeFirst();
//        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
        deque.addLast(4);
        deque.removeFirst();
        StdOut.println(deque.size());
        StdOut.println(deque.isEmpty());
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()){
            StdOut.println(iterator.next());
        }
        deque.print();
    }

}
