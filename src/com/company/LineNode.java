package com.company;

public class LineNode {
    private String info; // a line of text
    private LineNode next; // next node after this node in linkedList
    
    public LineNode(String line) {
        this.info = line;
        this.next = null;
    }

    public LineNode getNext() {
        return next;
    }

    public void setNext(LineNode next) {
        this.next = next;
    }



    public void print() {
        System.out.println(info);
    }
}
