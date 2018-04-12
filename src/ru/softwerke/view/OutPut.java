package ru.softwerke.view;

import ru.softwerke.model.Client;

public class OutPut {
    private OutPut outPut;

    public void listClientsIsEmpty() {
        System.out.println("List of clients is empty");
    }

    public void showClient (Client client){
        System.out.println("ID: " + client.getId() + client.getFirstName() +
        client.getLastName() + client.getPatronymic()+ client.getDataBirth());
    }
}
