package com.map;

import java.util.LinkedList;
import java.util.Map;

public class LinkedListMap<K,V> implements Imap<K,V> {
    private class Node {
        public K key;
        public V value;
        public Node next;


        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){this(key,null,null);}

        public Node(){this(null,null,null);}

        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyhead;
    private int size;

    public LinkedListMap(){
       dummyhead = new Node();
       size=0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    public Node getNode(K key){
        Node cur = dummyhead;
        while(cur!=null){
            if (cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key){
        return getNode(key)!=null;
    }

    @Override
    public V get(K key){
        Node node = getNode(key);
        return node == null? null : node.value;
    }

    @Override
    public void add(K key,V value){
        Node node = getNode(key);
        if (node == null){
            dummyhead.next = new Node(key,value,dummyhead.next);
            size++;
        }
        else{
            node.value = value;
        }
    }

    @Override
    public void Set(K key,V newvalue){
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist!");
        node.value = newvalue;
    }

    @Override
    public V remove(K key){
        Node prev = dummyhead;
        while(prev.next!=null){
            if (prev.next.key.equals(key)){break;}
            prev = prev.next;
        }

        if (prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode = null;
            size--;
            return delNode.value;
        }

        return null;
    }

}
