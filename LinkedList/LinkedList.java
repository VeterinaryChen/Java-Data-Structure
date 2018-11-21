package com.company;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(){
            this.e = null;
            this.next = null;
        }

        public Node(E e){
            this.e = e;
            this.next = null;
        }

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    private Node dummyhead;
    private int size;

    public LinkedList(){
        dummyhead = new Node();
        size =0;
    }
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e,int index){
        if (index<0 || index>size)
            throw new IllegalArgumentException("Add failed! invalid index!");
        Node current = dummyhead;
        for (int i=0 ; i<index ; i++){
            current = current.next;
        }

        current.next = new Node(e,current.next);
        size++;
    }

    public void addFirst(E e){
        add(e,0);
    }

    public void addLast(E e){
        add(e,size);
    }

    public E get(int index){
        Node current = dummyhead;
        for (int i=0 ; i<index ; i++)
            current = current.next;
        return current.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index , E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("invalid index!");
        }
        Node current = dummyhead.next;
        for (int i=0 ;i<index ; i++){
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e){
        Node current = dummyhead.next;
        while(current!=null){
            if(current.e.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node current = dummyhead.next;
        while (current!=null){
            str.append(current.e+"->");
            current = current.next;
        }
        str.append("Null");

        return str.toString();
    }
}