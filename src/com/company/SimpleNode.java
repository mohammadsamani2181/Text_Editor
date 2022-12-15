package com.company;

public class SimpleNode {
    private PagesLinkedList info;
    private SimpleNode next;

    public SimpleNode(PagesLinkedList list) {
        this.info = list;
        next = null;
    }

    public PagesLinkedList getInfo() {
        return info;
    }

    public void setInfo(PagesLinkedList info) {
        this.info = info;
    }

    public SimpleNode getNext() {
        return next;
    }

    public void setNext(SimpleNode next) {
        this.next = next;
    }
}
