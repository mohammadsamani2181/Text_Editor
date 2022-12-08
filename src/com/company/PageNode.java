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

    // appends the given string to the end of the page (node)
    public void append(String[] strings) {
        for (String line : strings) {
            info.addLine(line);
        }
    }

    // inserts the given string to the nth line of the page (node)
    public void insert(String newLine, int n) {
        info.insert(newLine, n);
    }

    // removes the nth line of the page
    public void remove(int n) {
        info.remove(n);
    }

    // replaces the nth line of the page with the given string "newLine"
    public void replace(int n, String newLine) {
        info.replace(n, newLine);
    }

    // swaps line n with line m in the linkedList
    public void swap(int n, int m) {
        info.swap(n, m);
    }

    // search for a specific string in the page (node)
    public String find(String string) {
        return info.find(string);
    }

    // finds all usage of string "oldString" in the page (node)
    // and replace them with the string "newString"
    public void findAndReplace(String oldString, String newString) {
        info.findAndReplace(oldString, newString);
    }
}
