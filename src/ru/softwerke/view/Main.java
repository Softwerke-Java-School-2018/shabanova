package ru.softwerke.view;

import ru.softwerke.controller.ClientController;
import ru.softwerke.controller.DeviceController;
import ru.softwerke.model.Color;
import ru.softwerke.model.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        DeviceController deviceController = new DeviceController();
        String firstName = null;
        String lastName = null;
        String patronymic = null;
        String birth = null;
        LocalDate releaseDate;
        Type type;
        Color color;
        String manufactured;
        BigDecimal price;
        MenuDisplay menu = new MenuDisplay();
        Scanner sc = new Scanner(System.in);
        String inputLine;
        menu.displayMainMenu();
        do {
            inputLine = sc.nextLine();
            if (!inputLine.equals(MenuItems.EXIT))
                switch (inputLine) {
                    case MenuItems.ADD_CLIENT:
                        clientController.addClient("Borya", "Semenov", "28.11.1985");
                        clientController.addClient("Kolyan", "Obramkin", "01.02.1997");
                        clientController.addClient("Vasya", "Pupkin", "11.02.1998");
                        clientController.addClient(firstName, lastName, patronymic, birth);
                        break;
                    case MenuItems.ADD_DEVICE:
                        deviceController.addDevice(Type.Smartphone, "Samsung", "10.10.2000", Color.Black, BigDecimal.valueOf(9800));
                        deviceController.addDevice(Type.Tablet, "Samsung", "05.05.2010", Color.White, BigDecimal.valueOf(12500.50));
                        deviceController.addDevice(Type.Laptop, "Acer", "25.03.2012", Color.Black, BigDecimal.valueOf(25000));
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
                        default:
                            System.out.println("Unknown menu item. Try again");
                            menu.displayMainMenu();
                            break;
                }
        } while (!inputLine.equals("0"));
    }
}
