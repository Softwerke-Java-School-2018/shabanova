package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.controller.ControllerOutputClient;

import static ru.softwerke.view.Output.output;

/**
 * Created by Тапок on 07.05.2018.
 */
public class WorkWithClientMenu {
    public void itemMenu(String item, ClientController clientController) {
        String firstName = null;
        String lastName = null;
        String birth = null;
        ControllerOutputClient ourForClient = new ControllerOutputClient();
        switch (item){
            case MenuItems.ADD_CLIENT:
                firstName = ourForClient.enterClientFirstName();
                lastName = ourForClient.enterClientLastName();
                birth = ourForClient.enterClientBirthName();
                clientController.addClient(firstName, lastName, birth);
                output.printTheString("Client was add");
                break;
            case MenuItems.SHOW_CLIENTS_LIST:
                clientController.showListOfClients();
                break;
            case MenuItems.DELETE_CLIENT_FROM_LIST_BY_ID:
                clientController.showListOfClients();
                output.printTheString("Input clients ID to remove");
                long id = Long.parseLong(output.readInputLine());
                clientController.deleteClientId(id);
                break;
            case MenuItems.DELETE_CLIENT_FROM_LIST_BY_LASTNAME:
                output.printTheString("Enter last name of client:");
                output.readInputLine();
                String lName = output.readInputLine();
                clientController.deleteClientLastName(lName);
                break;

        }
    }

}
