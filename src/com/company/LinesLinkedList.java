package com.company;

public class LinesLinkedList {
    private LineNode first; // first node in the likedList
    private LineNode last; // last node in the linkedList

    public LinesLinkedList() {
        first = last = null;
    }

    // adds new line(new node) to the linkedList
    public void addLine(String line) {
        LineNode newLine = new LineNode(line);

        if (isEmpty()) {
            first = last = newLine;
        }
        else {
            last.setNext(newLine);
            last = newLine;
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // returns number of lines (nodes) in the linkedList
    public int getNumberOfLines() {
        LineNode temp = first;
        int n;
        for (n = 0; temp != null; n++) {
            temp = temp.getNext();
        }

        return n;
    }

    // prints all lines (nodes) in the linkedList
    public void print() {
        if (!isEmpty()) {
            LineNode temp = first;

            do {

                temp.print();
                temp = temp.getNext();

            }while (temp != null);
        }
    }
    // prints the first n lines (nodes) of the linkedList
    public void print(int n) {
        LineNode temp = first;

        for (int i = 0; i < n && temp != null; i++) {
            temp.print();
        }
    }
}
