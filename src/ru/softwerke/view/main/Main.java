package ru.softwerke.view.main;

import ru.softwerke.controller.*;
import ru.softwerke.controller.client.ClientController;
import ru.softwerke.controller.device.DeviceController;
import ru.softwerke.controller.invoice.InvoiceController;
import ru.softwerke.view.clientsmenu.ClientsMenuItems;
import ru.softwerke.view.clientsmenu.WorkWithClientMenu;
import ru.softwerke.view.devicesmenu.DevicesMenuItems;
import ru.softwerke.view.devicesmenu.WorkWithDeviceMenu;
import ru.softwerke.view.invoice.InvoicesMenuItems;
import ru.softwerke.view.invoice.WorkWithInvoiceMenu;

import static ru.softwerke.view.main.MenuItems.WORK_WITH_CLIENT;
import static ru.softwerke.view.main.MenuItems.WORK_WITH_DEVICE;
import static ru.softwerke.view.main.MenuItems.WORK_WITH_INVOICE;
import static ru.softwerke.view.main.Output.output;

public class Main {

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();
        WorkWithClientMenu clientMenu = new WorkWithClientMenu();
        WorkWithDeviceMenu deviceMenu = new WorkWithDeviceMenu();
        InvoiceController invoiceController = new InvoiceController();
        MenuItems menu = new MenuItems();
        ClientsMenuItems menuClients = new ClientsMenuItems();
        DevicesMenuItems menuDevices = new DevicesMenuItems();
        InvoicesMenuItems menuInvoices = new InvoicesMenuItems();
        String inputLine;
        menu.displayMainMenu();
        AutoAddClientsDevices addAuto = new AutoAddClientsDevices();
        addAuto.autoAdd(clientController, deviceController);
        String item;
        inputLine = output.readInputLine();
        do {
            if (!inputLine.equals(MenuItems.EXIT))
                switch (inputLine) {
                    case WORK_WITH_CLIENT:
                        menuClients.displayClientMenu();
                        item = output.readInputLine();
                        clientMenu.itemMenu(item, clientController);
                        break;
                    case WORK_WITH_DEVICE:
                        menuDevices.displayDeviceMenu();
                        item = output.readInputLine();
                        deviceMenu.itemMenu(item, deviceController);
                        break;
                    case WORK_WITH_INVOICE:
                        menuInvoices.displayInvoiceMenu();
                        item = output.readInputLine();
                        WorkWithInvoiceMenu.itemMenu(item, clientController, deviceController, invoiceController);
                        break;
                    default:
                        output.printTheString("Unknown menu item. Try again");
                        break;
                }
            menu.displayMainMenu();
            output.printTheString("Input menu item: ");
            inputLine = output.readInputLine();

        } while (!inputLine.equals("0"));

    }
}
