package ru.softwerke.controller.client;

import ru.softwerke.model.client.Client;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static ru.softwerke.view.main.Output.getOutput;

/**
 * Created by DS on 07.05.2018.
 */
public class ControllerViewClient {

    public String enterClientFirstName (){
        getOutput().printTheString("Enter name :");
        return getOutput().readInputLine();
    }
    public String enterClientLastName (){
        getOutput().printTheString("Enter last name :");
        return getOutput().readInputLine();
    }
    public String enterClientBirthName (){
        String birth;
        boolean flag;
        do {
            flag = true;
            getOutput().printTheString("Enter birth :");
            birth = getOutput().readInputLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
                LocalDate dateBirth = LocalDate.parse(birth, formatter);
            } catch (DateTimeParseException e) {
                flag = false;
                getOutput().printTheString("Incorrect format of birth date, try again dd.mm.yyyy:");
            }
        }while(!flag);
        return birth;
    }
    public void showClient (Client client){
        System.out.printf("|%5s| |%12s| |%12s| |%14s| \n",String.valueOf(client.getId()),client.getFirstName(),
                client.getLastName(),String.valueOf(client.getDataBirth()));
    }

}
