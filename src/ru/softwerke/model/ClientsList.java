package ru.softwerke.model;

import ru.softwerke.controller.OutPutController;

import java.util.ArrayList;
import java.util.List;

public class ClientsList {
    private List<Client> clients = new ArrayList<>();
    private OutPutController outPut;

    public void addClientToList(Client person)
    {
        this.clients.add(person);
    }

    public void deleteClientFromListById(long id){
        List<Client> clients = (ArrayList<Client>) getClients();
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
                outPut.printString("Not found client with " + id + " ID");
            }else{
                clients.remove(clientForDelete);
            }
        }
    }
    public List<Client> getClients() {
        return clients;
    }


}
