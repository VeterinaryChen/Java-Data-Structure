package com.BST;

import java.util.Queue;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private int size;
    private Node root;

    public BST(){
        size=0;
        root=null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        if(root==null){
            root = new Node(e);
            size++;
            return;
        }
        else{
            add(root,e);
        }
    }

    private void add(Node node ,E e){
        if(e.equals(node.e)){
            return;
        }
        else if(e.compareTo(node.e) < 0 && node.left ==null){
            node.left = new Node(e);
            size++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }

        if(e.compareTo(node.e) < 0 ){
            add(node.left , e);
        }
        else{
            add(node.right,e);
        }
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node ,E e){
        if (node == null ){
            return false;
        }
        if (node.e.compareTo(e)==0){
            return true;
        }
        else if (e.compareTo(node.e)<0){
            return contains(node.left,e);
        }
        else{
            return contains(node.right,e);
        }
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node ==null ){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树层序遍历
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            if (cur.left!=null)
                q.add(cur.left);
            if (cur.right!=null)
                q.add(cur.right);
        }
    }

    //求二分搜索树的最小值
    public E minmum(){
        if (size==0)
            throw new IllegalArgumentException("BST is Empty!");
        return minmum(root).e;
    }

    private Node minmum(Node node){
        if (node.left == null)
            return node;
        return minmum(node.left);
    }

    //求二分搜索树的最大值
    public E max(){
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty!");
        return max(root).e;
    }

    private Node max(Node node){
        if (node.right==null)
            return node;
        return max(node.right);
    }

    //删除二分搜索树的最小值结点,并返回
    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node noderight = node.right;
            node.right = null;
            size--;
            return noderight;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //删除二分搜索树的最大值结点,并返回
    public E removeMax(){
        E ret = max();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if (node.right == null){
            Node nodeleft = node.left;
            node.left = null;
            size--;
            return nodeleft;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //删除二分搜索树中的任意值
    public void removeNode(E e){
        root = removeNode(root,e);
    }

    private Node removeNode(Node node,E e){
        if (node == null){
            return null;
        }
        if (e.compareTo(node.e)<0) {
            node.left = removeNode(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e)>0){
            node.right = removeNode(node.right,e);
            return node;
        }
        else {
            if (node.left == null) {
                Node rightnode = node.right;
                node.right = null;
                size--;
                return rightnode;
            }
            if (node.right == null){
                Node nodeleft = node.left;
                node.left = null;
                size--;
                return nodeleft;
            }

            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        generateBST(root,0,str);
        return str.toString();
    }

    private void generateBST(Node node ,int depth , StringBuilder str){
        if (node == null){
            str.append(generatedepth(depth)+"null\n");
            return;
        }
        str.append(generatedepth(depth)+node.e+"\n");
        generateBST(node.left,depth+1,str);
        generateBST(node.right,depth+1,str);
    }

    private String generatedepth(int depth){
        StringBuilder res = new StringBuilder();
        for (int i=0 ; i<depth ; i++){
            res.append("--");
        }
        return res.toString();
    }
}
