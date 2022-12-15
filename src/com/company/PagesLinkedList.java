package com.company;

import java.io.*;
import java.util.ArrayList;

public class PagesLinkedList implements Serializable{
    private PageNode first; // first page (node) in the linkedList
    private PageNode last; // last page (node) in the linkedList

    public PagesLinkedList() {
        first = last = null;
    }

    public PageNode getFirst() {
        return first;
    }

    public PageNode getLast() {
        return last;
    }

    public ArrayList<PageNode> getAllNodes() {
        PageNode temp = first;
        ArrayList<PageNode> nodes = new ArrayList<>();

        while (temp != null) {
            nodes.add(temp);
            temp = temp.getNext();
        }

        return nodes;
    }

    // makes a deep copy of the object and returns it
    public PagesLinkedList deepCopyUsingSerialization() {
        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(arrayOutputStream);
            outputStream.writeObject(this);

            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
            ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream);

            return (PagesLinkedList) inputStream.readObject();

        } catch (Exception e) {
            return  null;
        }
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

    public void removeLineINSpecificPage(int pageNumber, int lineNumber) {
        PageNode node = getSpecificPage(pageNumber);
        boolean wasTheLastLineInPage = node.remove(lineNumber);

        if (wasTheLastLineInPage) {
            removeSpecificPage(pageNumber);
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

    // search every page (node) in the linkedList (file) and prints :
    // <<the page number>> , <<the line number>> , <<the text of the line>>
    public void find(String string) {
        PageNode temp = first;

        for (int i = 0; temp != null; i++) {
            String result = "";
            result += temp.find(string);
            temp = temp.getNext();

            if (!result.equals("")) {
                System.out.println("Page <<" + (i+1) + ">> : ");
                System.out.println(result);
            }
        }
    }

    // finds all instance of string "oldString" in the likedList (file)
    // and replace them with "newString"
    public void findAndReplace(String oldString, String newString) {
        PageNode temp = first;

        while (temp != null) {
            temp.findAndReplace(oldString, newString);
            temp = temp.getNext();
        }
    }

    private void removeSpecificPage(int pageNumber) {
        if (isEmpty()) {
            System.out.println("The linked list is empty");
            return;
        }

        PageNode currentNode = first;
        PageNode previousNode = null;

        for (int i = 0; i < pageNumber && currentNode != null; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previousNode == null) {
            first = first.getNext();
        }
        else {
            previousNode.setNext(currentNode.getNext());
        }
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
