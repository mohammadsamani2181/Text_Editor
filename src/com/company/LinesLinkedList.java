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

    // gets a specific line base on its number
    private LineNode getSpecificLine(int lineNumber) {
        LineNode temp = first;

        for (int i = 0; i < lineNumber && temp != null; i++) {
            temp = temp.getNext();
        }

        return temp;
    }

    // inserts the given string "newLine" to the nth line of the page
    public void insert(String newLine, int lineNumber) {
        LineNode node = getSpecificLine(lineNumber);
        node.setInfo(newLine);
    }

    // removes the nth line of the page
    public void remove(int n) {
        LineNode currentNode = first;
        LineNode previousNode = null;

        for (int i = 0; i < n && currentNode != null; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        try {
            previousNode.setNext(currentNode.getNext());
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // replaces the string currently in line n with the given string "newLine"
    public void replace(int n, String newLine) {
        LineNode currentNode = first;
        LineNode previousNode = null;
        LineNode newNode = new LineNode(newLine);

        for (int i = 0; i <n && currentNode != null; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        try {
            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
        }catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    // swaps line n with line m in the linkedList
    public void swap(int n, int m) {
        LineNode nthLine = getSpecificLine(n);
        LineNode mthLine = getSpecificLine(m);
        LineNode temp = nthLine;

        nthLine.setInfo(mthLine.getInfo());
        mthLine.setInfo((temp.getInfo()));
    }

    //  finds all lines(nodes) with the given string "str" and return the "result" string
    // "result" string contains : <<the line number>> and <<the text of the line>>
    public String find(String str) {
        String result = "";
        LineNode temp = first;

        for (int i = 0; temp != null; i++) {
            if (temp.getInfo().contains(str)) {

                result += "found in line " + i + "th"
                        + "\nline : " + temp.getInfo()
                        + "\n----------------------------\n";

            }
            temp = temp.getNext();
        }

        return result;
    }


    // finds all lines(nodes) with the "oldString" and replace them with the "newString"
    public void findAndReplace(String oldString, String newString) {
        LineNode temp = first;

        while (temp != null) {
            temp.replace(oldString, newString);
            temp = temp.getNext();
        }
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
