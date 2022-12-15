package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Editor {
    private PagesLinkedList pagesList;
    private int currentPageNumber;
    private Stack undoStack;
    private Stack redoStack;

    // creates a linkedList of pages and parse a text file into it
    public Editor(String address) {
        pagesList = new PagesLinkedList();
        currentPageNumber = 0;
        undoStack = new Stack();
        redoStack = new Stack();
        parse(address);
    }

    // parse the target text file into a linkedList
    private void parse(String address) {
        File inputFile = new File(address);
        Scanner scan = null;
        ArrayList<String> page;

        try {
            scan = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNext()) {
            page = new ArrayList<>();
            String line = scan.nextLine();

            // pages separate from each other with "$" sign in the text file
            while (!line.equals("$")) {
                page.add(line);

                if (scan.hasNext()) {
                    line = scan.nextLine();
                }
                else {
                    break;
                }
            }

            pagesList.addPage(page);
        }
    }

    // saves the changed linkedList in a file
    public void save(String address) {
        ArrayList<PageNode> pages = pagesList.getAllNodes();
        FileWriter writer = null;
        try {
            writer = new FileWriter(address);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < pages.size(); i++) {
            ArrayList<String> allLinesInPage = pages.get(i).getAllLinesInPage();

            for (String line : allLinesInPage) {
                try {
                    writer.write(line + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (i < pages.size() - 1) {
                try {
                    writer.write("$\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // shows the page we are currently in
    public int where() {
        pagesList.printSpecificPage(currentPageNumber);
        return currentPageNumber;
    }

    // move to the next page in the linkedList
    public void nextPage() {
        if (currentPageNumber + 1 <= pagesList.getNumberOfPages())
            currentPageNumber++;
        else
            System.out.println("there isn't any next page");
    }

    // move to the previous page in the linkedList
    public void previousPage() {
        if (currentPageNumber - 1 >= 0)
            currentPageNumber--;
        else
            System.out.println("there isn't any previous page");
    }

    // returns the number of lines in the current page
    public int lines() {
        PageNode currentPage = pagesList.getSpecificPage(currentPageNumber);
        return currentPage.getNumberOfPageLines();
    }

    // prints the first n lines of the current page
    public void show(int n) {
        PageNode currentPage = pagesList.getSpecificPage(currentPageNumber);
        currentPage.print(n);
    }

    // appends the given string to the end of the current page
    public void append(String[] liens) {
        PageNode currentPage = pagesList.getSpecificPage(currentPageNumber);
        currentPage.append(liens);
}

    // inserts the given string "newLine" to the nth line of the current page
    public void insert(String newLine, int n) {
        PageNode currentPage = pagesList.getSpecificPage(currentPageNumber);
        currentPage.insert(newLine, n);
    }

    // removes nth line of the current page
    public void remove(int n) {
        PageNode currentPage = pagesList.getSpecificPage(currentPageNumber);
        currentPage.remove(n);
    }

    // replaces the string currently in line n with the given string "newLine"
    public void replace(int n, String newLine) {
        PageNode currentNode = pagesList.getSpecificPage(currentPageNumber);
        currentNode.replace(n, newLine);
    }

    // swaps line n with line m in the current page
    public void swap(int n, int m) {
        PageNode currentPage = pagesList.getSpecificPage(currentPageNumber);
        currentPage.swap(n, m);
    }

    // search every page in the linkedList and print :
    // <<the page number>> , <<the line number>> , <<the text of the line>>
    public void find(String string) {
        pagesList.find(string);
    }

    // finds all instance of string "oldString" in the linkedList (file)
    // and replace them with string "newString"
    public void findAndReplace(String oldString, String newString) {
        pagesList.findAndReplace(oldString, newString);
    }

    // undo the last change
    public void undo() {
        pushIntoRedoStack(pagesList);
        pagesList = popFromUndoStack();
    }

    public void redo() {
        pushIntoUndoStack(pagesList);
        pagesList = popFromRedoStack();
    }

    // pushes the given PagesLinkedList into the undoStack
    private void pushIntoUndoStack(PagesLinkedList list) {
        PagesLinkedList listCopy = (PagesLinkedList) list.deepCopyUsingSerialization();

        undoStack.push(listCopy);
    }

    // pops the top PagesLinkedList from undoStack
    private PagesLinkedList popFromUndoStack() {
        return undoStack.pop();
    }

    // pushes the given PagesLinkedList into the redoStack
    private void pushIntoRedoStack(PagesLinkedList list) {
        PagesLinkedList listCopy = (PagesLinkedList) list.deepCopyUsingSerialization();

        redoStack.push(listCopy);
    }

    // pops the top PagesLinkedList from redoStack
    private PagesLinkedList popFromRedoStack() {
        return redoStack.pop();
    }

}
