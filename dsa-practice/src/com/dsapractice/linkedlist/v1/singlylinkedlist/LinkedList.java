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
    //inserts at end
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
    //inserts at beginning
    public synchronized void insertAtBeginning(Object data){
        Node newNode = new Node(data);
        newNode.next = header;
        header = newNode;
    }
    //displays the linked list data
    public void display(){
        Node temp = header;
        while (temp != null){
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    //deletes the element provided
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
    //search the element
    public Object search(Object key){
        Node temp = header;
        while(temp != null){
            if(temp.data == key) return temp.data;
            temp = temp.next;
        }
        return "Value " + key + " not found in the list.";
    }
    //reverse the list
    public void reverse(){
        Node prev = null;
        Node current = header;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        header = prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert("Sunil");
        list.insert("Pragati");
        list.insert("Alok");
        System.out.println("Linked List : ");
        list.display();
        System.out.println("***********************************");
        list.delete("Alok");
        System.out.println("Linked List : ");
        list.display();
        list.insert("Alok");
        list.delete("xyz");
        System.out.println("Linked List : ");
        list.display();
        System.out.println("***********************************");
        LinkedList list1 = new LinkedList();
        list1.insertAtBeginning("Sunil");
        list1.insertAtBeginning("Pragati");
        list1.insertAtBeginning("Alok");
        System.out.println("Linked List : ");
        list1.display();
        System.out.println("***********************************");
        //to search the element
        System.out.println(String.valueOf(list1.search("Sunil")));
        System.out.println(String.valueOf(list1.search("xyz")));
        System.out.println(String.valueOf(list1.search(10)));
        System.out.println("***********************************");
        //reverse a linkedlist
        LinkedList list2 = new LinkedList();
        list2.insert("Sunil");
        list2.insert("Pragati");
        list2.insert("Alok");
        System.out.println("Linked List : ");
        list2.reverse();
        list2.display();
    }
}
