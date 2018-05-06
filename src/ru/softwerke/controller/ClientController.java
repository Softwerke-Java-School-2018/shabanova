package ru.softwerke.controller;

import ru.softwerke.model.*;
import ru.softwerke.view.Output;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private ClientsList clientsList = new ClientsList();
    Output output = new Output();

    public void addClient(String firstName, String lastName, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateBirth = LocalDate.parse(birth, formatter);
        Client client = new Client(firstName, lastName, dateBirth);
        clientsList.addClientToList(client);
    }

    public void showListOfClients(){
        List<Client> clients = (ArrayList<Client>) clientsList.getClients();
        if (clients.size() == 0){
            output.listClientsIsEmpty();
        }
        else {
            for (Client client : clients) {
                output.showClient(client);
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

    public Client findClientById(long idClient) {
        Client clientWithId = null;
        ArrayList<Client> clients = (ArrayList<Client>) clientsList.getClients();
        for (Client client: clients){
            if (idClient == client.getId()){
                clientWithId = client;
            }
        }
        return clientWithId;

    }
}
