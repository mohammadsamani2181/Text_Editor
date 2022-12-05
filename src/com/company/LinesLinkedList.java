package com.company;

public class LinesLinkedList {
    private LineNode first; // first node in the likedList
    private LineNode last; // last node in the linkedList

    public LinesLinkedList() {
        first = last = null;
    }

    // add new line(new node) to the linkedList
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

    // print all lines (nodes) in the linkedList
    public void print() {
        if (!isEmpty()) {
            LineNode temp = first;

            do {

                temp.print();
                temp = temp.getNext();

            }while (!(temp == null));
        }
    }
}
