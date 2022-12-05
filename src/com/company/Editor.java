package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Editor {
    private PagesLinkedList pagesList;
    private int currentPageNumber;

    // creates a linkedList of pages and parse a text file into it
    public Editor(String address) {
        pagesList = new PagesLinkedList();
        currentPageNumber = 0;
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

            // pages separate from each other with "####" sign in the text file
            while (!line.equals("####")) {
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

}
