package ru.softwerke.view;

import ru.softwerke.controller.*;
import ru.softwerke.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ru.softwerke.view.MenuItems.WORK_WITH_CLIENT;
import static ru.softwerke.view.MenuItems.WORK_WITH_DEVICE;
import static ru.softwerke.view.Output.output;

public class Main {

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();
        InvoiceController invoiceController = new InvoiceController();
        WorkWithClientMenu clientMenu = new WorkWithClientMenu();
        WorkWithDeviceMenu deviceMenu = new WorkWithDeviceMenu();
        InvoiceLine invoiceLine = null;

        MenuDisplay menu = new MenuDisplay();
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
                        menu.displayClientMenu();
                        item = output.readInputLine();
                        clientMenu.itemMenu(item, clientController);
                        break;
                    case WORK_WITH_DEVICE:
                        menu.displayDeviceMenu();
                        item = output.readInputLine();
                        deviceMenu.itemMenu(item, deviceController);
                        break;
                    case MenuItems.CREATE_INVOICE:
                        output.printTheString("List of clients: ");
                        output.printNamesOfClients();
                        clientController.showListOfClients();
                        List<InvoiceLine> invoiceLineList = new ArrayList<>();
                        InvoiceLineController invoiceLineController = new InvoiceLineController();
                        output.printTheString("ID Client: ");
                        long idClient = Long.parseLong(output.readInputLine());
                        Client client = clientController.findClientById(idClient);
                        String ch = "1";
                        Device device = null;
                        long numberSoldItems;
                        output.printTheString("List of devices: ");
                        output.printNamesOfDevice();
                        deviceController.showListOfDevices();
                        while (ch.equals("1")) {
                            output.printTheString("ID of sold item: ");
                            long idDevice = Long.parseLong(output.readInputLine());
                            output.printTheString("number of sold item: ");
                            numberSoldItems = Integer.parseInt(output.readInputLine());
                            device = deviceController.findDeviceById(idDevice);
                            invoiceLine = invoiceLineController.createInvoiceLine(device, numberSoldItems);
                            invoiceLineController.addInvoiceLineToList(invoiceLine);
                            output.printTheString("Add another item? 'YES - 1 /NO - 0' ");
                            ch = output.readInputLine();
                        }
                        invoiceLineList = invoiceLineController.getInvoiceList();
                        invoiceController.addInvoice(client, invoiceLineList, LocalDateTime.now());
                        break;
                    case MenuItems.SHOW_INVOICES_lIST:
                        invoiceController.showInvoice();
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
