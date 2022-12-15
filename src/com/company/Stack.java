package com.company;

public class Stack {
    private SimpleNode top;

    public Stack() {
        top = null;
    }

    public void push(PagesLinkedList list) {
        SimpleNode newNode = new SimpleNode(list);

        if (top == null) {
            top = newNode;
        }
        else {
            newNode.setNext(top);
            top = newNode;
        }
    }

    public PagesLinkedList pop() {
        PagesLinkedList list = null;

        if (top == null) {
            System.out.println("You can't do it !");
        }
        else {
            list = top.getInfo();
            top = top.getNext();
        }

        return list;
    }
}
