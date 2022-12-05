package com.company;

import java.util.ArrayList;

public class PagesLinkedList {
    private PageNode first; // first page (node) in the linkedList
    private PageNode last; // last page (node) in the linkedList

    public PagesLinkedList() {
        first = last = null;
    }

    // add new page (new node) to the linkedList
    public void addPage(ArrayList<String> page) {
        PageNode newPage = new PageNode(page);

        if (isEmpty()) {
            first = last = newPage;
        }
        else {
            last.setNext(newPage);
            last = newPage;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }
}
