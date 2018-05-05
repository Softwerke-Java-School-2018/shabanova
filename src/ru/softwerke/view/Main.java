package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.controller.DeviceController;
import ru.softwerke.controller.InvoiceController;
import ru.softwerke.controller.InvoiceLineController;
import ru.softwerke.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();
        InvoiceController invoiceController = new InvoiceController();
        InvoiceLineController invoiceLineController = new InvoiceLineController();
        InvoiceLine invoiceLine = null;
        LocalDateTime date;
        ArrayList<InvoiceLine> invoiceLineList = new ArrayList<>();
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
        clientController.addClient("Borya", "Semenov", "28.11.1985");
        clientController.addClient("Kolyan", "Obramkin", "01.02.1997");
        clientController.addClient("Vasya", "Pupkin", "11.02.1998");
        deviceController.addDevice(Type.Smartphone, "Samsung", "10.10.2000", Color.Black, BigDecimal.valueOf(9800));
        deviceController.addDevice(Type.Tablet, "Samsung", "05.05.2010", Color.White, BigDecimal.valueOf(12500.50));
        deviceController.addDevice(Type.Laptop, "Acer", "25.03.2012", Color.Black, BigDecimal.valueOf(25000));
        do {
            inputLine = sc.nextLine();
            if (!inputLine.equals(MenuItems.EXIT))
                switch (inputLine) {
                    case MenuItems.ADD_CLIENT:
                        firstName = output.enterClientFirstName();
                        lastName = output.enterClientLastName();
                        birth = output.enterClientBirthName();
                        clientController.addClient(firstName, lastName,  birth);
                        break;
                    case MenuItems.ADD_DEVICE:
                        break;
                    case "3":
                       clientController.showListOfClients();
                        break;
                    case "4":
                        System.out.println("Input clients ID to remove");
                        long id = sc.nextLong();
                        if (clientController.checkEmptyListClient()){
                            System.out.println("List of clients is empty");
                        }else {
                            clientController.deleteClientId(id);
                        }
                        break;
                    case MenuItems.CREATE_INVOICE:
                        System.out.println("List of clients: ");
                        clientController.showListOfClients();
                        System.out.println("ID Client: ");
                        long idClient = sc.nextLong();
                        Client client = clientController.findClientById(idClient);
                        int ch = 1;
                        Device device = null;
                        long numberSoldItems;
                        while (ch == 1) {

                            System.out.println("ID of sold item: ");
                            long idDevice = sc.nextLong();
                            System.out.println("number of sold item: ");
                            numberSoldItems = sc.nextInt();
                            device = deviceController.findDeviceById(idDevice);
                            invoiceLine = invoiceLineController.createInvoiceLine(device, numberSoldItems);
                            invoiceLineController.addInvoiceLineToList(invoiceLine);
                            System.out.println("Add another item? 'YES - 1 /N - 0' ");
                            ch = sc.nextInt();
                        }
                        invoiceLineList = invoiceLineController.getInvoiceList();
                        invoiceController.addInvoice(client, invoiceLineList, LocalDateTime.now() );
                        invoiceController.showInvoice();
                        break;
                        default:
                            System.out.println("Unknown menu item. Try again");
                            menu.displayMainMenu();
                            break;
                }
        } while (!inputLine.equals("0"));

    }
}
