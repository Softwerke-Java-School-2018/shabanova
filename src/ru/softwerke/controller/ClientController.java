package ru.softwerke.controller;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import ru.softwerke.model.*;
import ru.softwerke.view.OutPut;
import sun.awt.image.ImageWatched;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

public class ClientController {
    private ClientsList clientsList = new ClientsList();
    OutPut outPut = new OutPut();

    public void addClient(String firstName, String lastName, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateBirth = LocalDate.parse(birth, formatter);
        Client client = new Client(firstName, lastName, dateBirth);
        clientsList.addClientToList(client);
    }

    public void showListOfClients(){
        ArrayList<Client> clients = (ArrayList<Client>) clientsList.getClients();
        if (clients.size() == 0){
            outPut.listClientsIsEmpty();
        }
        else {
            for (Client client : clients) {
                outPut.showClient(client);
            }
        }
    }
    public void deleteClientId (long id){
        ArrayList<Client> clients = (ArrayList<Client>) clientsList.getClients();
        clientsList.deleteClientFromListById(id);
    }
    public boolean checkEmptyListClient(){
        ArrayList<Client> clients = (ArrayList<Client>) clientsList.getClients();
        if (clients.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}
