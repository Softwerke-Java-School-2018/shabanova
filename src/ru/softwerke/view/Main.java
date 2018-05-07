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
        Scanner sc = new Scanner(System.in);
        String inputLine;
        menu.displayMainMenu();
        AutoAddClientsDevices addAuto = new AutoAddClientsDevices();
        addAuto.autoAdd(clientController, deviceController);
        int item;
        do {
            inputLine = sc.nextLine();
            if (!inputLine.equals(MenuItems.EXIT))
                switch (inputLine) {
                    case WORK_WITH_CLIENT:
                        menu.displayClientMenu();
                        item = output.readInputInt();
                        clientMenu.itemMenu(item, clientController);
                        break;
                    case WORK_WITH_DEVICE:
                        menu.displayDeviceMenu();
                        item = output.readInputInt();
                        deviceMenu.itemMenu(item, deviceController);
                        break;
                    case MenuItems.CREATE_INVOICE:
                        output.printTheString("List of clients: ");
                        output.printNamesOfClients();
                        clientController.showListOfClients();
                        List<InvoiceLine> invoiceLineList = new ArrayList<>();
                        InvoiceLineController invoiceLineController = new InvoiceLineController();
                        output.printTheString("ID Client: ");
                        long idClient = output.readInputLong();
                        Client client = clientController.findClientById(idClient);
                        int ch = 1;
                        Device device = null;
                        long numberSoldItems;
                        output.printTheString("List of devices: ");
                        output.printNamesOfDevice();
                        deviceController.showListOfDevices();
                        while (ch == 1) {
                            output.printTheString("ID of sold item: ");
                            long idDevice = output.readInputLong();
                            output.printTheString("number of sold item: ");
                            numberSoldItems = sc.nextInt();
                            device = deviceController.findDeviceById(idDevice);
                            invoiceLine = invoiceLineController.createInvoiceLine(device, numberSoldItems);
                            invoiceLineController.addInvoiceLineToList(invoiceLine);
                            output.printTheString("Add another item? 'YES - 1 /N - 0' ");
                            ch = sc.nextInt();
                        }
                        invoiceLineList = invoiceLineController.getInvoiceList();
                        for (InvoiceLine line : invoiceLineList
                                ) {
                            System.out.println("device: " + line.getDevice().getType());

                        }
                        invoiceController.addInvoice(client, invoiceLineList, LocalDateTime.now());
                        break;
                    case MenuItems.SHOW_INVOICES_lIST:
                        invoiceController.showInvoice();
                        break;
                    default:
                        output.printTheString("Unknown menu item. Try again");
                        menu.displayMainMenu();
                        break;
                }
            menu.displayMainMenu();
            output.printTheString("Input menu item: ");
        } while (!inputLine.equals("0"));

    }
}
