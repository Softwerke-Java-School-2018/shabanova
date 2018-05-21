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
import static ru.softwerke.view.main.Output.getOutput;

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
        addAuto.autoAdd(clientController, deviceController, invoiceController);
        String item;
        inputLine = getOutput().readInputLine();
        boolean exit = false;
        do {
            if (!inputLine.equals(MenuItems.EXIT))
                switch (inputLine) {
                    case WORK_WITH_CLIENT:
                        do {
                            menuClients.displayClientMenu();
                            item = getOutput().readInputLine();
                            if (!item.equals(MenuItems.EXIT)) {
                                clientMenu.itemMenu(item, clientController);
                            } else {
                                exit = true;
                            }
                        } while (!exit);
                        break;
                    case WORK_WITH_DEVICE:
                        do {
                            menuDevices.displayDeviceMenu();
                            item = getOutput().readInputLine();
                            if (!item.equals(MenuItems.EXIT)) {
                                deviceMenu.itemMenu(item, deviceController);
                            } else {
                                exit = true;
                            }
                        }while (!exit);
                        break;
                    case WORK_WITH_INVOICE:
                        do {
                            menuInvoices.displayInvoiceMenu();
                            item = getOutput().readInputLine();
                            if (!item.equals(MenuItems.EXIT)) {
                                WorkWithInvoiceMenu.itemMenu(item, clientController, deviceController, invoiceController);
                            } else {
                                exit = true;
                            }
                        }while(!exit);
                        break;
                    default:
                        getOutput().printTheString("Unknown menu item. Try again");
                        break;
                }
            menu.displayMainMenu();
            getOutput().printTheString("Input menu item: ");
            inputLine = getOutput().readInputLine();

        } while (!inputLine.equals("0"));

    }
}
