package ru.softwerke.view.clientsmenu;

import static ru.softwerke.view.main.Output.getOutput;

/**
 * Created by DS on 10.05.2018.
 */
public class ClientsMenuItems {
    public final static String ADD_CLIENT = "1";
    public final static String SHOW_CLIENTS_LIST = "2";
    public final static String FIND_CLIENT_LAST_NAME = "3";
    public final static String DELETE_CLIENT_FROM_LIST_BY_LAST_NAME = "4";
    public final static String SORT_CLIENTS_BY_LAST_NAME = "5";
    public final static String SORT_CLIENTS_BY_BIRTH_DATE = "6";


    public final static String DELETE_CLIENT_FROM_LIST_BY_ID = "999";
    public void displayClientMenu(){
        getOutput().printTheString("0 - back to main menu");
        getOutput().printTheString("1 - add the client");
        getOutput().printTheString("2 - show clients list");
        getOutput().printTheString("3 - find client by last name");
        getOutput().printTheString("4 - delete client from list by last name");
       getOutput().printTheString("5 - sort clients by last name");
       getOutput().printTheString("6 - sort clients by date of birth");
    }
}
