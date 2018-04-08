package ru.softwerke.model;

import java.util.LinkedList;

public class ClientsList {
    private LinkedList<Client> clients = new LinkedList<>();

    public void addClientToList(Client person){
        this.clients.add(person);
    }
    public void deleteClientFromListById(long id){
        LinkedList<Client> clients = getClients();
        if (clients.size() == 0){
            System.out.println("List of clients is empty");
        }
        else{
            boolean existId = false;
            Client clientForDelete = new Client();
            for (Client c: clients) {
                if (c.getId() == id){
         //           clients.remove(c);
                    clientForDelete = c;
                    existId = true;
                }
            }
            if (existId == false){
                System.out.println("Not found client with " + id + " ID");
            }else{
                clients.remove(clientForDelete);
            }
        }
    }
    public LinkedList<Client> getClients() {
        return clients;
    }
}
