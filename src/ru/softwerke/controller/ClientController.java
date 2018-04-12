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
    OutPut outPut;

    public void addClient(String firstName, String lastName, String patronymic, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateBirth = LocalDate.parse(birth, formatter);
        Client client = new Client.Builder().firstName(firstName)
                .lastName(lastName)
                .dataBirth(dateBirth)
                .patronymic(patronymic)
                .id().build();
        clientsList.addClientToList(client);
    }

    public void addClient(String firstName, String lastName, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateBirth = LocalDate.parse(birth, formatter);
        Client client = new Client.Builder().firstName(firstName)
                .lastName(lastName)
                .dataBirth(dateBirth)
                .id().build();
        clientsList.addClientToList(client);
    }

    public void showListOfClients(){
        ArrayList<Client> clients = (ArrayList<Client>) clientsList.getClients();
        if (clients.size() == 0){
            outPut.listClientsIsEmpty();
        }
        else {
            for (Client c : clients) {
                System.out.println("Client: " + c.getFirstName() + " " + c.getLastName()+ " "
                        + c.getDataBirth()+ " ID: " + c.getId() + "\n");
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
