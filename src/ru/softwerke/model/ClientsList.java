package ru.softwerke.model;

import ru.softwerke.controller.OutPutController;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ClientsList {
    private ArrayList<Client> clients = new ArrayList<>();
    private OutPutController outPut;
    public void addClientToList(Client person){
        this.clients.add(person);
    }
    public void deleteClientFromListById(long id){
        ArrayList<Client> clients = (ArrayList<Client>) getClients();
        if (clients.size() == 0){
            outPut.listClientsIsEmpty();
        }
        else{
            boolean existId = false;
            Client clientForDelete = null;
            for (Client c: clients) {
                if (c.getId() == id){
                    clientForDelete = c;
                    existId = true;
                }
            }
            if (!existId){
                System.out.println("Not found client with " + id + " ID");
            }else{
                clients.remove(clientForDelete);
            }
        }
    }
    public ArrayList<Client> getClients() {
        return clients;
    }
}
