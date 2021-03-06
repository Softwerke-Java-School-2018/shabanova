package ru.softwerke.view.clientsmenu;

import ru.softwerke.controller.client.ClientController;
import ru.softwerke.controller.client.ControllerViewClient;

import static ru.softwerke.view.main.Output.getOutput;

/**
 * Created by Тапок on 07.05.2018.
 */
public class WorkWithClientMenu {
    public void itemMenu(String item, ClientController clientController) {
        String firstName = null;
        String lastName = null;
        String birth = null;
        String inputLine;
        ControllerViewClient ourForClient = new ControllerViewClient();
        switch (item){
            case ClientsMenuItems.ADD_CLIENT:
                firstName = ourForClient.enterClientFirstName();
                lastName = ourForClient.enterClientLastName();
                birth = ourForClient.enterClientBirthName();
                clientController.addClient(firstName, lastName, birth);
                getOutput().printTheString("client was add");
                break;
            case ClientsMenuItems.SHOW_CLIENTS_LIST:
                clientController.showListOfClients();
                break;
            case ClientsMenuItems.DELETE_CLIENT_FROM_LIST_BY_ID:
                clientController.showListOfClients();
                getOutput().printTheString("Input clients ID to remove");
                long id = Long.parseLong(getOutput().readInputLine());
                clientController.deleteClientId(id);
                break;
            case ClientsMenuItems.FIND_CLIENT_LAST_NAME:
                getOutput().printTheString("Input last name of client: ");
                inputLine = getOutput().readInputLine();
                clientController.findClientByLastName(inputLine);
                break;
            case ClientsMenuItems.DELETE_CLIENT_FROM_LIST_BY_LAST_NAME:
                getOutput().printTheString("Enter last name of client:");
                getOutput().readInputLine();
                inputLine = getOutput().readInputLine();
                clientController.deleteClientLastName(inputLine);
                break;
            case ClientsMenuItems.SORT_CLIENTS_BY_LAST_NAME:
                clientController.sortByLastName();
                break;
            case ClientsMenuItems.SORT_CLIENTS_BY_BIRTH_DATE:
                clientController.sortByBirthDate();
                break;


        }
    }

}
