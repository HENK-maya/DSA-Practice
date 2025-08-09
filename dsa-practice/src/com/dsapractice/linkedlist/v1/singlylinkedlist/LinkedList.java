package com.dsapractice.linkedlist.v1.singlylinkedlist;

import java.awt.*;

public class LinkedList {

    static  class Node{
        Object data;
        Node next;
        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    Node header = null;

    public synchronized void insert(Object data){
        Node newNode = new Node(data);
        if(header == null){
            header = newNode;
        }else{
            Node temp = header;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display(){
        Node temp = header;
        while (temp != null){
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void delete(Object key){
        if(header == null)return;
        //if header node itself holds the key
        if(header.data == key){
            header = header.next;
            return;
        }
        Node temp = header;
        while (temp.next != null && temp.next.data != key){
            temp = temp.next;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
        }else{
            System.out.println("Value " + key + " not found in the list.");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert("Sunil");
        list.insert("Pragati");
        list.insert("Alok");
        System.out.println("Linked List : ");
        list.display();
        list.delete("Alok");
        System.out.println("Linked List : ");
        list.display();
        list.insert("Alok");
        list.delete("xyz");
        System.out.println("Linked List : ");
        list.display();
    }
}
