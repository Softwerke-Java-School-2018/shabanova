package ru.softwerke.controller.client;

import ru.softwerke.model.client.Client;


import static ru.softwerke.view.main.Output.output;

/**
 * Created by DS on 07.05.2018.
 */
public class ControllerViewClient {

    public String enterClientFirstName (){
        output.printTheString("Enter name :");
        return output.readInputLine();
    }
    public String enterClientLastName (){
        output.printTheString("Enter last name :");
        return output.readInputLine();
    }
    public String enterClientBirthName (){
        output.printTheString("Enter birth :");
        return output.readInputLine();
    }
    public void showClient (Client client){
        output.printFormattedString5("|%5s| |%12s| |%12s| |%14s| \n",String.valueOf(client.getId()),client.getFirstName(),
                client.getLastName(),String.valueOf(client.getDataBirth()));
    }

}
