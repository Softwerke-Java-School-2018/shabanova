package ru.softwerke.controller.device;

import ru.softwerke.model.device.Color;
import ru.softwerke.model.device.Device;
import ru.softwerke.model.device.TypeOfDevice;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ru.softwerke.view.main.Output.getOutput;

/**
 * Created by DS on 07.05.2018.
 */
public class ControllerOutputDevices {
    public TypeOfDevice enterDeviceType() {
        TypeOfDevice type;
        boolean flag;
        do {
            getOutput().printTheString("Enter type: \n" + " Tablet - 1 \n"+ " Smartphone - 2 \n" +" Laptop - 3 \n" +" Mp3_Player - 4");
            int in = Integer.parseInt(getOutput().readInputLine());
            flag = true;
            switch (in) {
                case 1:
                    type = TypeOfDevice.Tablet;
                    break;
                case 2:
                    type = TypeOfDevice.Smartphone;
                    break;
                case 3:
                    type = TypeOfDevice.Laptop;
                    break;
                case 4:
                    type = TypeOfDevice.Mp3_Player;
                    break;
                default:
                    type = null;
                    flag = false;
                    getOutput().printTheString("Unknown item, try again");
                    break;
            }
        }while (!flag);
        return type;
    }

    public String enterDeviceManufacturer() {
        getOutput().printTheString("Write the manufacture: ");
        return getOutput().readInputLine();
    }

    public String enterDeviceReleaseDate(){
        getOutput().printTheString("Input release Date (dd.mm.yyyy): ");

        return getOutput().readInputLine();
    }

    public Color enterColor() {
        getOutput().printTheString("Input color: ");
        Color returnColor = Color.White;
        boolean flag = false;
        while (!flag) {
            String str = getOutput().readInputLine();
            for (Color color : Color.values()) {
                if (color.toString().equals(str)) {
                    flag = true;
                    returnColor = color;
                }
            }
            if (!flag){
                getOutput().printTheString("unknown color, try again (  White, Black, Green, Red, Blue, Yellow, Colored): ");
            }
        }
        return returnColor;
    }

    public BigDecimal enterPrice() {
        BigDecimal bd = BigDecimal.valueOf(0);
        Double price;
        boolean flag;
        getOutput().printTheString("Enter the price (format 00.00): ");
        do {
            flag = true;
            try {
                price = Double.valueOf(getOutput().readInputLine());
                bd = BigDecimal.valueOf(price);
            } catch (java.lang.NumberFormatException e) {
                flag = false;
                getOutput().printTheString("Wrong format of price, try 0000.00: ");
            }
        }while (!flag);
        return bd;
    }
    public void showDevice (Device device){
        System.out.printf("|%5s| |%20s| |%12s| |%12s| |%12s| \n",String.valueOf(device.getId()),
                String.valueOf(device.getType())+ " " +device.getManufactured(), String.valueOf(device.getColor()), String.valueOf(device.getReleaseDate()),
                String.valueOf(device.getPrice()));
    }
}
