package ru.softwerke.view;

import ru.softwerke.controller.MasterController;
import ru.softwerke.model.Color;
import ru.softwerke.model.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MasterController master = new MasterController();
        String firstName;
        String lastName;
        String birth;
        LocalDate releaseDate;
        Type type;
        Color color;
        String manufactured;
        BigDecimal price;
        Scanner sc = new Scanner(System.in);
        String inputLine;
        do {
            System.out.println("0 - exit");
            System.out.println("1 - add the client");
            System.out.println("2 - add the device");
            System.out.println("3 - show clients list");
            System.out.println("4 - delete client from list");

            inputLine = sc.nextLine();
            if (!inputLine.equals("0"))
                switch (inputLine) {
                    case "1":
                        master.addClient("Borya", "Semenov", "28.11.1985");
                        master.addClient("Kolyan", "Obramkin", "01.02.1997");
                        master.addClient("Vasya", "Pupkin", "11.02.1998");
                        break;
                    case "2":
                        master.addDevice(Type.Smartphone, "Samsung", "10.10.2000", Color.Black, BigDecimal.valueOf(9800));
                        master.addDevice(Type.Tablet, "Samsung", "05.05.2010", Color.White, BigDecimal.valueOf(12500.50));
                        master.addDevice(Type.Laptop, "Acer", "25.03.2012", Color.Black, BigDecimal.valueOf(25000));
                        break;
                    case "3":
                       master.ShowListOfCLients();
                        break;
                    case "4":
                        System.out.println("Input clients ID to remove");
                        long id = sc.nextLong();
                        if (master.CheckEmptyListClient()){
                            System.out.println("List of clients is empty");
                        }else {
                            master.deleteClientId(id);
                        }
                        break;
                }
        } while (!inputLine.equals("0"));
    }
}
