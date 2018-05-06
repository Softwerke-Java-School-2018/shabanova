package ru.softwerke.view;

import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
import ru.softwerke.model.Client;
import ru.softwerke.model.Color;
import ru.softwerke.model.Device;
import ru.softwerke.model.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Output {

    private Scanner sc = new Scanner(System.in);

    public void listClientsIsEmpty() {
        printTheString("List of clients is empty");
    }

    public void printTheString (String string){
        System.out.println(string);
    }

    public String readInputLine(){
        return sc.nextLine();
    }
    public long readInputLong(){
        return sc.nextLong();
    }
    public void printFormattedString5(String string1, String string2, String string3, String string4, String string5){
        System.out.printf(string1, string2, string3, string4, string5);
    }
    public void printFormattedString6(String string1, String string2, String string3, String string4, String string5, String string6){
        System.out.printf(string1, string2, string3, string4, string5, string6);
    }
    public void printNamesOfDevice(){
        printFormattedString6("|%5s| |%20s| |%12s| |%12s| |%12s| \n",
                "ID", "Device","Color", "Release date", "Price");
    }
    public void printNamesOfClients(){
        printFormattedString5("|%5s| |%12s| |%12s| |%14s| \n",
                "ID", "Name","Last name", "Date of birth");
    }
    public void showClient (Client client){
        printFormattedString5("|%5s| |%12s| |%12s| |%14s| \n",String.valueOf(client.getId()),client.getFirstName(),
        client.getLastName(),String.valueOf(client.getDataBirth()));
    }
    public  void showDevice (Device device){
        printFormattedString6("|%5s| |%20s| |%12s| |%12s| |%12s| \n",String.valueOf(device.getId()),
                String.valueOf(device.getType())+device.getManufactured(), String.valueOf(device.getColor()), String.valueOf(device.getReleaseDate()),
                String.valueOf(device.getPrice()));
    }

    public String enterClientFirstName (){
        printTheString("Enter name :");
        return readInputLine();
    }
    public String enterClientLastName (){
        printTheString("Enter last name :");
        return readInputLine();
    }
    public String enterClientBirthName (){
        printTheString("Enter birth :");
        return readInputLine();
    }
    public Type enterDeviceType() {
        printTheString("Enter type: \n" + " Tablet - 1 \n"+ " Smartphone - 2 \n" +" Laptop - 3 \n" +" Mp3_Player - 4");
        int in = sc.nextInt();
        Type type;
        boolean flag;
        do {
            flag = true;
            switch (in) {
                case 1:
                    type = Type.Tablet;
                break;
                case 2:
                    type = Type.Smartphone;
                break;
                case 3:
                    type = Type.Laptop;
                break;
                case 4:
                    type = Type.Mp3_Player;
                break;
                default:
                    type = null;
                    flag = false;
                    printTheString("Unknown item, try again");
                    break;
            }
        }while (!flag);
        return type;
    }

    public String enterDeviceManuf() {
        printTheString("Write the manufacture: ");
        String str = readInputLine();
        return readInputLine();
    }

    public String enterDeviceRealaseDate(){
        printTheString("Input release Date: dd/mm/yyyy: ");
        return readInputLine();
    }

    public Color enterColor() {
        printTheString("Input color: ");
        Color returnColor = Color.White;
        boolean flag = false;
        while (!flag) {
            String str = readInputLine();
            for (Color color : Color.values()) {
                if (color.toString().equals(str)) {
                    flag = true;
                    returnColor = color;
                }
            }
            if (!flag){
                printTheString("unknown color, try again (  White, Black, Green, Red, Blue, Yellow, Colored): ");
            }
        }
        return returnColor;
    }

    public BigDecimal enterPrice() {
        printTheString("Enter the price (format 00.00): ");
        Long bd = sc.nextLong();
        return BigDecimal.valueOf(bd);
    }
}
