package com.company;

import java.util.ArrayList;

public class PageNode {
    private LinesLinkedList info; // contains all lines in this page
    private PageNode next; // next page (node) after this page in linkedList

    public PageNode(ArrayList<String> page) {
        info = createNewPage(page);
        next = null;
    }

    public PageNode getNext() {
        return next;
    }

    public void setNext(PageNode next) {
        this.next = next;
    }

    // creates a new LinesLinkedList and adds all lines of new page to it
    public LinesLinkedList createNewPage(ArrayList<String> page) {
        LinesLinkedList newPage = new LinesLinkedList();

        for (int i = 0; i < page.size(); i++) {
            newPage.addLine(page.get(i));
        }

        return newPage;
    }

    public int getNumberOfPageLines() {
        return info.getNumberOfLines();
    }

    // prints all lines in the page
    public void print() {
        info.print();
    }

    // prints the first n lines in the page
    public void print(int n) {
        info.print(n);
    }
}
