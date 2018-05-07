package ru.softwerke.controller;

import ru.softwerke.model.*;
import ru.softwerke.view.Output;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static ru.softwerke.view.Output.output;

public class ClientController {
    private ClientsList clientsList = new ClientsList();
    private List<Client> clients = clientsList.getClients();
    ControllerOutputClient outClient = new ControllerOutputClient();

    public void addClient(String firstName, String lastName, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateBirth = LocalDate.parse(birth, formatter);
        Client client = new Client(firstName, lastName, dateBirth);
        clientsList.addClientToList(client);
    }

    public void showListOfClients(){
     //   List<Client> clients = clientsList.getClients();
        if (clients.size() == 0){
            output.listClientsIsEmpty();
        }
        else {
            for (Client client : clients) {
                outClient.showClient(client);
            }
        }
    }
    public void deleteClientId (long id){
     //   List<Client> clients =  clientsList.getClients();
        clientsList.deleteClientFromListById(id);
    }
    public boolean checkEmptyListClient(){
      //  List<Client> clients = clientsList.getClients();
        if (clients.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public Client findClientById(long idClient) {
        Client clientWithId = null;
     //   List<Client> clients =clientsList.getClients();
        for (Client client: clients){
            if (idClient == client.getId()){
                clientWithId = client;
            }
        }
        return clientWithId;

    }

    public void deleteClientLastName(String lName) {
        List<Client> clientsWithLastName = new ArrayList<>();
        List<Long> idClients = new ArrayList<>();
        for (Client client: clients) {
            if (lName.equalsIgnoreCase(client.getLastName())){
                clientsWithLastName.add(client);
                idClients.add(client.getId());
            }
        }
        if (idClients.size() == 1){
            clientsList.deleteClientFromListById(idClients.get(0));
            output.printTheString("Client was deleted");
        }else if (idClients.size() == 0){
            output.printTheString("Not found client with last name " + lName);
        }
        else{
            ControllerOutputClient outClient = new ControllerOutputClient();
            output.printTheString("Found more than one person with last name: " +
                    lName + "\n Input ID of client to remove");
            output.printNamesOfClients();
            for (long i: idClients) {
                Client client = findClientById(i);
                outClient.showClient(client);
            }
            long idToRemove = output.readInputLong();
            clientsList.deleteClientFromListById(idToRemove);
            output.printTheString("Client was deleted");
        }


    }
}
