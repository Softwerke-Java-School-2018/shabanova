package ru.softwerke.model.client;

import java.util.ArrayList;
import java.util.List;

import static ru.softwerke.view.main.Output.output;

public class ClientsList {
    private List<Client> clients = new ArrayList<>();

    public void addClientToList(Client person)
    {
        this.clients.add(person);
    }

    public void deleteClientFromListById(long id){
        List<Client> clients = getClients();
        if (clients.size() == 0){
            output.listClientsIsEmpty();
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
                output.printTheString("Not found client with " + id + " ID");
            }else{
                clients.remove(clientForDelete);
                output.printTheString("client was deleted");
            }
        }
    }
    public List<Client> getClients() {
        return clients;
    }


}
