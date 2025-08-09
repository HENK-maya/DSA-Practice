package com.dsapractice.linkedlist;

public class Test {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBeginning("String 1");
        list.insertAtBeginning("String 3");
        list.insertAtEnd("String 2");
        System.out.println("LinkedList : ");
        list.display();
    }
}
