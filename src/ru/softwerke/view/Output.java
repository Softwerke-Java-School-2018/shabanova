package ru.softwerke.view;

import ru.softwerke.model.Client;

import java.util.Scanner;

public class Output {

    private Scanner sc = new Scanner(System.in);

    public void listClientsIsEmpty() {
        System.out.println("List of clients is empty");
    }

    public void showClient (Client client){
        System.out.println("ID: " + client.getId() + " | " + client.getFirstName() + " " +
        client.getLastName() + " " + client.getDataBirth());
    }

    public String enterClientFirstName (){
        System.out.println("Enter name :");
        return sc.nextLine();
    }
    public String enterClientLastName (){
        System.out.println("Enter last name :");
        return sc.nextLine();
    }
    public String enterClientBirthName (){
        System.out.println("Enter birth :");
        return sc.nextLine();
    }
}
