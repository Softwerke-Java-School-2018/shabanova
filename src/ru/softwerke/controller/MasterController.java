package ru.softwerke.controller;

import ru.softwerke.model.*;
import sun.awt.image.ImageWatched;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class MasterController {
    private ClientsList clientsList = new ClientsList();
    private DevicesList devicesList = new DevicesList();
    public void addClient(String firstName, String lastName, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateBirth = LocalDate.parse(birth, formatter);
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setDataBirth(dateBirth);
        client.setId();
        clientsList.addClientToList(client);
    }
    public void addDevice(Type type, String manufactured, String releaseDate,
                          Color color, BigDecimal price){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate dateRelease = LocalDate.parse(releaseDate, formatter);
        Device device = new Device();
        device.setType(type);
        device.setManufactured(manufactured);
        device.setReleaseDate(dateRelease);
        device.setColor(color);
        device.setPrice(price);
        device.setId();
        devicesList.addDevice(device);

    }
    public void ShowListOfCLients(){
        LinkedList<Client> clients = clientsList.getClients();
        if (clients.size() == 0){
            System.out.println("List of clients is empty");
        }
        else {
            for (Client c : clients) {
                System.out.println("Client: " + c.getFirstName() + " " + c.getLastName()+ " "
                        + c.getDataBirth()+ " ID: " + c.getId() + "\n");
            }
        }
    }
    public void deleteClientId (long id){
        LinkedList<Client> clients = clientsList.getClients();
        clientsList.deleteClientFromListById(id);
    }
    public boolean CheckEmptyListClient(){
        LinkedList<Client> clients = clientsList.getClients();
        if (clients.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}
