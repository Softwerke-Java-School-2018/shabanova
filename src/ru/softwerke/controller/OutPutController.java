package ru.softwerke.controller;

import ru.softwerke.view.Output;

import static ru.softwerke.view.Output.output;

public class OutPutController {

    public void listClientsIsEmpty(){
        output.listClientsIsEmpty();
    }

    public void printString(String string){output.printTheString(string);}
}
