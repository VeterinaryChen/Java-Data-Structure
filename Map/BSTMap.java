package com.map;

public class BSTMap<K extends Comparable<K>,V> implements Imap<K,V>{

    public class Node{
        public K key;
        public V value;
        public Node left, right;


        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0 ;
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key ,value);
    }

    private Node add(Node node , K key , V value){
        if (node == null){
            size++;
            return new Node(key,value);
        }

        if (key.compareTo(node.key)<0){
            node.left = new Node(key,value);
        }
        else if(key.compareTo(node.key)>0){
            node.right = new Node(key,value);
        }
        else{
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public void Set(K key, V newvalue) {
        Node node = getNode(root,key);
        if (node == null){
            throw new IllegalArgumentException(key+"doesn't exist!");
        }

        node.value = newvalue;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node==null?null:node.value;
    }

    //定义寻找key对应的结点
    private Node getNode(Node node , K key){
        if (node == null){
            return null;
        }

        if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }
        else if(key.compareTo(node.key)>0){
            return getNode(node.right,key);
        }
        else{
            return node;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
