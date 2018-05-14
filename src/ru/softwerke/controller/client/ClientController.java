package ru.softwerke.controller.client;

import ru.softwerke.model.client.Client;
import ru.softwerke.model.client.ClientsList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.softwerke.view.main.Output.output;

public class ClientController {
    private ClientsList clientsList = new ClientsList();
    private List<Client> clients = clientsList.getClients();
    ControllerViewClient outClient = new ControllerViewClient();

    public void addClient(String firstName, String lastName, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateBirth = LocalDate.parse(birth, formatter);
        Client client = new Client(firstName, lastName, dateBirth);
        clientsList.addClientToList(client);
    }

    public void showListOfClients(){
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
        clientsList.deleteClientFromListById(id);
    }

    public Client findClientById(long idClient) {
        Client clientWithId = null;
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
            output.printTheString("client was deleted");
        }else if (idClients.size() == 0){
            output.printTheString("Not found client with last name " + lName);
        }
        else{
            ControllerViewClient outClient = new ControllerViewClient();
            output.printTheString("Found more than one person with last name: " +
                    lName + "\n Input ID of client to remove");
            output.printNamesOfClients();
            for (long i: idClients) {
                Client client = findClientById(i);
                outClient.showClient(client);
            }
            long idToRemove = Long.parseLong(output.readInputLine());
            clientsList.deleteClientFromListById(idToRemove);
            output.printTheString("client was deleted");
        }

    }

    public void findClientByLastName(String lName) {
        List<Client> clientsWithLastName = new ArrayList<>();
        List<Long> idClients = new ArrayList<>();
        for (Client client : clients) {
            if (lName.equalsIgnoreCase(client.getLastName())) {
                clientsWithLastName.add(client);
                idClients.add(client.getId());
            }
        }
        if (idClients.size() == 1) {
            outClient.showClient(clientsWithLastName.get(0));
        } else if (idClients.size() == 0) {
            output.printTheString("Not found client with last name " + lName);
        } else {
            ControllerViewClient outClient = new ControllerViewClient();
            output.printTheString("People with last name " + lName);
            output.printNamesOfClients();
            for (Client client : clientsWithLastName) {
                outClient.showClient(client);
            }
        }
    }

    public void sortByLastName() {
        LastNameComparator lNamecompare = new LastNameComparator();
        List<Client> copyClients = new ArrayList<>();
        copyClients.addAll(clients);
        Collections.sort(copyClients,lNamecompare);
        for (Client client : copyClients) {
            outClient.showClient(client);
        }
    }

    public void sortByBirthDate() {
        BirthDateComparator bDateCompare = new BirthDateComparator();
        List<Client> copyClients = new ArrayList<>();
        copyClients.addAll(clients);
        Collections.sort(copyClients,bDateCompare);
        for (Client client : copyClients) {
            outClient.showClient(client);
        }
    }
}
