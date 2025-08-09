package com.dsapractice.linkedlist;

public class LinkedList {

    private int length = 0;
    ListNode head;

    public LinkedList() {
        this.length = 0;
    }

    public synchronized  void insertAtBeginning(Object data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public synchronized void insertAtEnd(Object node){
        ListNode listNode = new ListNode(node);
        if(head == null){
            head = listNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = listNode;
    }

    public void display(){
        ListNode current = head;
        if(current == null){
            System.out.println("Linked List is Empty !!");
            return;
        }
        while(current != null){
            System.out.println(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
