package ru.softwerke.view.clientsmenu;

import static ru.softwerke.view.main.Output.output;

/**
 * Created by DS on 10.05.2018.
 */
public class ClientsMenuItems {
    public final static String ADD_CLIENT = "1";
    public final static String SHOW_CLIENTS_LIST = "2";
    public final static String FIND_CLIENT_LASTNAME = "3";
    public final static String DELETE_CLIENT_FROM_LIST_BY_LASTNAME = "4";
    public final static String SORT_CLIENTS_BY_LASTNAME = "4";


    public final static String DELETE_CLIENT_FROM_LIST_BY_ID = "999";
    public void displayClientMenu(){
        output.printTheString("1 - add the client");
        output.printTheString("2 - show clients list");
        output.printTheString("3 - find client by last name");
        output.printTheString("4 - delete client from list by last name");
        //output.printTheString("5 - sort clients by last name");
    }
}
