package ru.softwerke.view.clientsmenu;

import ru.softwerke.controller.client.ClientController;
import ru.softwerke.controller.client.ControllerViewClient;
import ru.softwerke.view.invoice.InvoicesMenuItems;
import ru.softwerke.view.main.MenuItems;

import static ru.softwerke.view.main.Output.output;

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
                output.printTheString("client was add");
                break;
            case ClientsMenuItems.SHOW_CLIENTS_LIST:
                clientController.showListOfClients();
                break;
            case ClientsMenuItems.DELETE_CLIENT_FROM_LIST_BY_ID:
                clientController.showListOfClients();
                output.printTheString("Input clients ID to remove");
                long id = Long.parseLong(output.readInputLine());
                clientController.deleteClientId(id);
                break;
            case ClientsMenuItems.FIND_CLIENT_LASTNAME:
                output.printTheString("Input last name of client: ");
                inputLine = output.readInputLine();
                clientController.findClientByLastName(inputLine);
                break;
            case ClientsMenuItems.DELETE_CLIENT_FROM_LIST_BY_LASTNAME:
                output.printTheString("Enter last name of client:");
                output.readInputLine();
                inputLine = output.readInputLine();
                clientController.deleteClientLastName(inputLine);
                break;
            case ClientsMenuItems.SORT_CLIENTS_BY_LASTNAME:
                clientController.sortByLastName();
                break;
            case ClientsMenuItems.SORT_CLIENTS_BY_BIRTHDATE:
                clientController.sortByBirthDate();
                break;


        }
    }

}
