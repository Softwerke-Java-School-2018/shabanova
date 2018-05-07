package ru.softwerke.controller;

import ru.softwerke.model.Color;
import ru.softwerke.model.TypeOfDevice;

import java.math.BigDecimal;

/**
 * Created by Тапок on 06.05.2018.
 */
public class AutoAddClientsDevices {
    public void autoAdd(ClientController clientController, DeviceController deviceController) {
        clientController.addClient("Borya", "Semenov", "28.11.1985");
        clientController.addClient("Kolyan", "Obramkin", "01.02.1997");
        clientController.addClient("Vasya", "Pupkin", "11.02.1998");
        clientController.addClient("Katya", "Semenova", "01.10.1990");
        clientController.addClient("Alexandra", "Teremkina", "01.09.1985");
        clientController.addClient("Ivan", "Semenov", "02.09.1989");
        clientController.addClient("Oksana", "Teremkina", "10.12.2001");
        deviceController.addDevice(TypeOfDevice.Smartphone, "Motorola", "10.10.2000", Color.Black, BigDecimal.valueOf(9800));
        deviceController.addDevice(TypeOfDevice.Tablet, "Samsung", "05.05.2010", Color.White, BigDecimal.valueOf(12500.50));
        deviceController.addDevice(TypeOfDevice.Mp3_Player, "ASUS", "25.03.2012", Color.Black, BigDecimal.valueOf(25000));
        deviceController.addDevice(TypeOfDevice.Smartphone, "LG", "04.05.2005", Color.Colored, BigDecimal.valueOf(14300));
        deviceController.addDevice(TypeOfDevice.Laptop, "Acer", "15.12.2016", Color.Red, BigDecimal.valueOf(45700));
        deviceController.addDevice(TypeOfDevice.Laptop, "Samsung", "30.07.2009", Color.Blue, BigDecimal.valueOf(34999));
        deviceController.addDevice(TypeOfDevice.Tablet, "SONY", "06.05.2001", Color.Green, BigDecimal.valueOf(15000));
        deviceController.addDevice(TypeOfDevice.Smartphone, "Acer", "01.05.2015", Color.Black, BigDecimal.valueOf(9500));
        deviceController.addDevice(TypeOfDevice.Mp3_Player, "Motorola", "01.10.2001", Color.Colored, BigDecimal.valueOf(3450));
        deviceController.addDevice(TypeOfDevice.Mp3_Player, "lg", "01.10.2001", Color.Colored, BigDecimal.valueOf(3650));
        deviceController.addDevice(TypeOfDevice.Smartphone, "LG", "15.12.2015", Color.Yellow, BigDecimal.valueOf(16950));
    }
    }
