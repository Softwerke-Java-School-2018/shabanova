package ru.softwerke.controller;

import ru.softwerke.model.Color;
import ru.softwerke.model.Device;
import ru.softwerke.model.TypeOfDevice;
import ru.softwerke.view.Output;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ru.softwerke.view.Output.output;

/**
 * Created by DS on 07.05.2018.
 */
public class ControllerOutputDevices {
    public TypeOfDevice enterDeviceType() {
        output.printTheString("Enter type: \n" + " Tablet - 1 \n"+ " Smartphone - 2 \n" +" Laptop - 3 \n" +" Mp3_Player - 4");
        int in = output.readInputInt();
        TypeOfDevice type;
        boolean flag;
        do {
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
                    output.printTheString("Unknown item, try again");
                    break;
            }
        }while (!flag);
        return type;
    }

    public String enterDeviceManuf() {
        output.printTheString("Write the manufacture: ");
        String str = output.readInputLine();
        return output.readInputLine();
    }

    public String enterDeviceReleaseDate(){
        output.printTheString("Input release Date (dd.mm.yyyy): ");
        return output.readInputLine();
    }

    public Color enterColor() {
        output.printTheString("Input color: ");
        Color returnColor = Color.White;
        boolean flag = false;
        while (!flag) {
            String str = output.readInputLine();
            for (Color color : Color.values()) {
                if (color.toString().equals(str)) {
                    flag = true;
                    returnColor = color;
                }
            }
            if (!flag){
                output.printTheString("unknown color, try again (  White, Black, Green, Red, Blue, Yellow, Colored): ");
            }
        }
        return returnColor;
    }

    public BigDecimal enterPrice() {
        Scanner sc = new Scanner(System.in);
        BigDecimal bd = BigDecimal.valueOf(0);
        output.printTheString("Enter the price (format 00,00): ");
            try {
                bd  = sc.nextBigDecimal();
                return bd;
            } catch (InputMismatchException e) {
                output.printTheString("Wrong formatt of price, next time try 0000,00: ");
            }
        return bd;
    }
    public void showDevice (Device device){
        output.printFormattedString6("|%5s| |%20s| |%12s| |%12s| |%12s| \n",String.valueOf(device.getId()),
                String.valueOf(device.getType())+ " " +device.getManufactured(), String.valueOf(device.getColor()), String.valueOf(device.getReleaseDate()),
                String.valueOf(device.getPrice()));
    }
}
