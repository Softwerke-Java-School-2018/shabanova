package ru.softwerke.controller;

import ru.softwerke.view.Output;

public class OutPutController {
    private Output out;

    public void listClientsIsEmpty(){
        out.listClientsIsEmpty();
    }

    public void printString(String string){out.printTheString(string);}
}
