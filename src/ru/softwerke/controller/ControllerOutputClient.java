package ru.softwerke.controller;

import ru.softwerke.model.Client;
import ru.softwerke.view.Output;

/**
 * Created by DS on 07.05.2018.
 */
public class ControllerOutputClient {
    Output out = new Output();
    public String enterClientFirstName (){
        out.printTheString("Enter name :");
        return out.readInputLine();
    }
    public String enterClientLastName (){
        out.printTheString("Enter last name :");
        return out.readInputLine();
    }
    public String enterClientBirthName (){
        out.printTheString("Enter birth :");
        return out.readInputLine();
    }
    public void showClient (Client client){
        out.printFormattedString5("|%5s| |%12s| |%12s| |%14s| \n",String.valueOf(client.getId()),client.getFirstName(),
                client.getLastName(),String.valueOf(client.getDataBirth()));
    }

}
