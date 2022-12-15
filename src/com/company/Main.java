package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor("input.txt");
        Scanner scan = new Scanner(System.in);
        String order = null;

        do {
            System.out.println(
                    "\n****************************************************************\n"
                    + "Please choose one of these orders : "
                    + "\n<<where>>, <<next page>>, "
                    + "<<previous page>>, <<lines>>, "

                    + "\n<<show>>, <<append>>, "
                    + "<<insert>>, <<remove>>, "

                    + "\n<<replace>>, <<swap>>, "
                    + "<<find>>, <<find and replace>>"

                    + "\n****************************************************************\n");

            order = scan.nextLine();

            if (order.equals("where")) {
                editor.where();
            }

            else if (order.equals("next page")) {
                editor.nextPage();
            }

            else if (order.equals("previous page")) {
                editor.previousPage();
            }

            else if (order.equals("lines")) {
                System.out.println("This page has <<" + editor.lines() + ">> line/lines");
            }

            else if (order.equals("show")) {
                System.out.println("Please enter the number of lines : ");

                editor.show(scan.nextInt());

                // just to scans \n
                scan.nextLine();
            }

            else if (order.equals("append")) {
                System.out.println("Please enter the number of lines : ");
                int n = scan.nextInt();
                scan.nextLine();

                String[] lines = new String[n];

                for (int i = 0; i < n; i++) {
                    System.out.println("Please enter the " + (i+1) +  "th line : ");
                    lines[i] = scan.nextLine();
                }

                editor.append(lines);
            }

            else if (order.equals("insert")) {
                System.out.println("Please enter the new line : ");
                String newLine = scan.nextLine();

                System.out.println("Please enter the line number : ");
                int n = scan.nextInt() - 1;
                scan.nextLine();

                editor.insert(newLine, n);
            }

            else if (order.equals("remove")) {
                System.out.println("Please enter the line number : ");

                editor.remove(scan.nextInt() - 1);

                scan.nextLine();
            }

            else if (order.equals("replace")) {
                System.out.println("Please enter the new line : ");
                String newLine = scan.nextLine();

                System.out.println("Please enter the line number : ");
                int n = scan.nextInt() - 1;
                scan.nextLine();

                editor.replace(n, newLine);
            }

            else if (order.equals("swap")) {
                System.out.println("Please enter the number of two lines (like ? ?) : ");
                int n = scan.nextInt() - 1;
                int m = scan.nextInt() - 1;
                scan.nextLine();

                editor.swap(n, m);
            }

            else if (order.equals("find")) {
                System.out.println("Please enter the string : ");

                editor.find(scan.nextLine());
            }

            else if (order.equals("find and replace")) {
                System.out.println("Please enter the string that you want to replace it : ");
                String oldString = scan.nextLine();

                System.out.println("Please enter the new string : ");
                String newString = scan.nextLine();

                editor.findAndReplace(oldString, newString);
            }

            else if (order.equals("undo")) {
                editor.undo();
            }

            else if (order.equals("redo")) {
                editor.redo();
            }

            else if (order.equals("save")) {
                System.out.println("Please enter file address : ");
                String address = scan.nextLine();

                editor.save(address);
            }

            else {
                System.out.println("!!  Undefined order  !!");
            }

        }while (order != "save");
    }
}
