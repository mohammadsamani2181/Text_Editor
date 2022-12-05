package com.company;

import java.util.ArrayList;

public class PagesLinkedList {
    private PageNode first; // first page (node) in the linkedList
    private PageNode last; // last page (node) in the linkedList

    public PagesLinkedList() {
        first = last = null;
    }

    // adds new page (new node) to the linkedList
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

    // returns number of pages (nodes) in the linkedList
    public int getNumberOfPages() {
        PageNode temp = first;
        int n;

        for (n = 0; temp != null; n++) {
            temp = temp.getNext();
        }

        return n;
    }

    // returns a page in specific index(page Number) in the likedList
    public PageNode getSpecificPage(int pageNumber) {
        PageNode temp = first;

        for (int i = 0; i < pageNumber && temp != null; i++) {
            temp = temp.getNext();
        }

        return temp;
    }

    public void printAllPages() {
        if (!isEmpty()) {
            PageNode temp = first;

            do {

                temp.print();
                temp = temp.getNext();

                if (temp != null) {
                    System.out.println("####");
                }

            }while (temp != null);
        }
    }

    public void printSpecificPage(int pageNumber) {
        PageNode page = getSpecificPage(pageNumber);
        if (page != null) {
            page.print();
        }
    }
}
