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

    public String getInfo() {
        return info;
    }

    public void setInfo(String line) {
        this.info = line;
    }

    // replaces all usage of "oldString" in <<info>> with "newString"
    public void replace(String oldString, String newString) {
        setInfo(info.replace(oldString, newString));
    }

    public void print() {
        System.out.println(info);
    }
}
