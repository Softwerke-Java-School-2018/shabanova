package ru.softwerke.view;

import ru.softwerke.controller.*;
import ru.softwerke.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();
        InvoiceController invoiceController = new InvoiceController();
        InvoiceLine invoiceLine = null;
        LocalDateTime date;
        String firstName = null;
        String lastName = null;
        String birth = null;
        String releaseDate;
        TypeOfDevice type;
        Color color;
        String manufactured;
        BigDecimal price;
        MenuDisplay menu = new MenuDisplay();
        Output output = new Output();
        Scanner sc = new Scanner(System.in);
        String inputLine;
        ControllerOutputDevices outForDevice = new ControllerOutputDevices();
        ControllerOutputClient ourForClient = new ControllerOutputClient();
        menu.displayMainMenu();
        AutoAddClientsDevices addAuto = new AutoAddClientsDevices();
        addAuto.autoAdd(clientController, deviceController);
        Sort sort = new Sort();
        do {
            inputLine = sc.nextLine();
            if (!inputLine.equals(MenuItems.EXIT))
                switch (inputLine) {
                    case MenuItems.ADD_CLIENT:
                        firstName = ourForClient.enterClientFirstName();
                        lastName = ourForClient.enterClientLastName();
                        birth = ourForClient.enterClientBirthName();
                        clientController.addClient(firstName, lastName, birth);
                        break;
                    case MenuItems.ADD_DEVICE:
                        type = outForDevice.enterDeviceType();
                        manufactured = outForDevice.enterDeviceManuf();
                        releaseDate = outForDevice.enterDeviceReleaseDate();
                        color = outForDevice.enterColor();
                        price = outForDevice.enterPrice();
                        deviceController.addDevice(type, manufactured, releaseDate, color, price);
                        break;
                    case MenuItems.SHOW_CLIENTS_LIST:
                        clientController.showListOfClients();
                        break;
                    case MenuItems.SHOW_DEVICES_LIST:
                        deviceController.showListOfDevices();
                        break;
                    case MenuItems.DELETE_CLIENT_FROM_LIST:
                        clientController.showListOfClients();
                        output.printTheString("Input clients ID to remove");
                        long id = output.readInputLong();
                        clientController.deleteClientId(id);
                        break;
                    case MenuItems.SORT_DEVICES_BI_TYPE_SHOW:
                        List sortedDevicesByType = deviceController.sortDeviceByType();
                        deviceController.showListOfDevices(sortedDevicesByType);
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
                    case MenuItems.SHOW_DEVICES_SORT_BY_MANUFACT:
                        List sortedDevicesByManuf = deviceController.sortDeviceByManuFactured();
                        deviceController.showListOfDevices(sortedDevicesByManuf);
                        break;
                    default:
                        output.printTheString("Unknown menu item. Try again");
                        menu.displayMainMenu();
                        break;
                }
            output.printTheString("Input menu item: ");
 //           output.readInputLine();
        } while (!inputLine.equals("0"));

    }
}
