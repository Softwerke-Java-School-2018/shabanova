package ru.softwerke.view;

import java.util.Scanner;

public class Output {

    private Scanner sc = new Scanner(System.in);

    public void listClientsIsEmpty() {
        printTheString("List of clients is empty");
    }

    public void printTheString (String string){
        System.out.println(string);
    }

    public String readInputLine(){
        return sc.nextLine();
    }
    public long readInputLong(){
        return sc.nextLong();
    }
    public int readInputInt(){return sc.nextInt(); }

    public void printFormattedString5(String string1, String string2, String string3, String string4, String string5){
        System.out.printf(string1, string2, string3, string4, string5);
    }
    public void printFormattedString6(String string1, String string2, String string3,
                                      String string4, String string5, String string6){
        System.out.printf(string1, string2, string3, string4, string5, string6);
    }
    public void printFormattedString8(String string1, String string2, String string3,
             String string4, String string5, String string6, String string7, String string8){
        System.out.printf(string1, string2, string3, string4,
                string5, string6, string7, string8);
    }
    public void printNamesOfDevice(){
        printFormattedString6("|%5s| |%20s| |%12s| |%12s| |%12s| \n",
                "ID", "Device","Color", "Release date", "Price");
    }
    public void printNamesOfClients(){
        printFormattedString5("|%5s| |%12s| |%12s| |%14s| \n",
                "ID", "Name","Last name", "Date of birth");
    }

    public void printNamesOfInvoice(){
        printFormattedString8("|%5s| |%20s| |%12s| |%12s| |%10s| |%5s| |%25s| \n",
                "ID", "Device","Color", "Release date", "Price",
                "Sold", "Sold date");
    }
}
