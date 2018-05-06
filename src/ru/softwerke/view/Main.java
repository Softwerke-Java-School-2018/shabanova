package ru.softwerke.view;

import ru.softwerke.controller.*;
import ru.softwerke.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();
        InvoiceController invoiceController = new InvoiceController();
        InvoiceLineController invoiceLineController = new InvoiceLineController();
        InvoiceLine invoiceLine = null;
        LocalDateTime date;
        String firstName = null;
        String lastName = null;
        String birth = null;
        LocalDate releaseDate;
        Type type;
        Color color;
        String manufactured;
        BigDecimal price;
        MenuDisplay menu = new MenuDisplay();
        Output output = new Output();
        Scanner sc = new Scanner(System.in);
        String inputLine;

        menu.displayMainMenu();
        AutoAddClientsDevices addAuto = new AutoAddClientsDevices();
        addAuto.autoAdd(clientController, deviceController);
        do {
            inputLine = sc.nextLine();
            if (!inputLine.equals(MenuItems.EXIT))
                switch (inputLine) {
                    case MenuItems.ADD_CLIENT:
                        firstName = output.enterClientFirstName();
                        lastName = output.enterClientLastName();
                        birth = output.enterClientBirthName();
                        clientController.addClient(firstName, lastName, birth);
                        break;
                    case MenuItems.ADD_DEVICE:
                        type = output.enterDeviceType();
                        manufactured = output.enterDeviceManuf();
                        releaseDate = output.enterDeviceRealaseDate();
                        color = output.enterColor();
                        deviceController.addDevice(type, manufactured, releaseDate, color, price);
                        break;
                    case MenuItems.SHOW_CLIENTS_LIST:
                        clientController.showListOfClients();
                        break;
                    case MenuItems.SHOW_DEVICES_LIST:
                        deviceController.showListOfDevices();
                        break;
                    case MenuItems.DELETE_CLIENT_FROM_LIST:
                        output.printTheString("Input clients ID to remove");
                        long id = output.readInputLong();
                        if (clientController.checkEmptyListClient()) {
                            output.listClientsIsEmpty();
                        } else {
                            clientController.deleteClientId(id);
                        }
                        break;
                    case MenuItems.CREATE_INVOICE:
                        output.printTheString("List of clients: ");
                        output.printNamesOfClients();
                        clientController.showListOfClients();
                        output.printTheString("Number of customers: ");
                        int i = sc.nextInt();
                        List<InvoiceLine> invoiceLineList = new ArrayList<>();
                        for (int j = 0; j < i; j++) {
                            invoiceLineList.clear();
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
                            invoiceController.addInvoice(client, invoiceLineList, LocalDateTime.now());
                        }
                        invoiceController.showInvoice();
                        break;
                    default:
                        output.printTheString("Unknown menu item. Try again");
                        menu.displayMainMenu();
                        break;
                }
            output.printTheString("Input menu item: ");
            output.readInputLine();
        } while (!inputLine.equals("0"));

    }
}
