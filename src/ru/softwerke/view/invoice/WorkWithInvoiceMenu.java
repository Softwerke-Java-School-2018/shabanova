package ru.softwerke.view.invoice;

import ru.softwerke.controller.client.ClientController;
import ru.softwerke.controller.device.DeviceController;
import ru.softwerke.controller.invoice.InvoiceController;
import ru.softwerke.controller.invoice.InvoiceLineController;
import ru.softwerke.model.client.Client;
import ru.softwerke.model.device.Device;
import ru.softwerke.model.invoice.Invoice;
import ru.softwerke.model.invoice.InvoiceLine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ru.softwerke.view.main.Output.getOutput;

/**
 * Created by DS on 10.05.2018.
 */
public class WorkWithInvoiceMenu {

    public static void itemMenu(String item, ClientController clientController, DeviceController deviceController,
                                InvoiceController invoiceController) {
        InvoiceLine invoiceLine = null;
        String inputLine;
        switch (item) {
            case InvoicesMenuItems.CREATE_INVOICE:
                getOutput().printTheString("List of clients: ");
                getOutput().printNamesOfClients();
                clientController.showListOfClients();
                List<InvoiceLine> invoiceLineList;
                InvoiceLineController invoiceLineController = new InvoiceLineController();
                getOutput().printTheString("ID client: ");
                long idClient = Long.parseLong(getOutput().readInputLine());
                Client client = clientController.findClientById(idClient);
                inputLine = "1";
                Device device = null;
                long numberSoldItems;
                getOutput().printTheString("List of devices: ");
                getOutput().printNamesOfDevice();
                deviceController.showListOfDevices();
                while (inputLine.equals("1")) {
                    getOutput().printTheString("ID of sold item: ");
                    long idDevice = Long.parseLong(getOutput().readInputLine());
                    getOutput().printTheString("number of sold item: ");
                    numberSoldItems = Integer.parseInt(getOutput().readInputLine());
                    device = deviceController.findDeviceById(idDevice);
                    invoiceLine = invoiceLineController.createInvoiceLine(device, numberSoldItems);
                    invoiceLineController.addInvoiceLineToList(invoiceLine);
                    getOutput().printTheString("Add another item? 'YES - 1 /NO - 0' ");
                    inputLine = getOutput().readInputLine();
                }
                invoiceLineList = invoiceLineController.getInvoiceList();
                invoiceController.addInvoice(client, invoiceLineList, LocalDateTime.now());
                break;
            case InvoicesMenuItems.SHOW_INVOICES_lIST:
                invoiceController.showInvoice();
                break;
            case InvoicesMenuItems.FIND_INVOICES_MADE_BY_DATE:
                getOutput().printTheString("Enter the date in format dd.mm.year, day without 0 (7.05.2017): ");
                inputLine = getOutput().readInputLine();
                if (invoiceController.findInvoiceOfDate(inputLine).size() == 0) {
                    getOutput().printTheString("Not found invoices made by date: " + inputLine);
                } else {
                    invoiceController.showInvoice((ArrayList<Invoice>) invoiceController.findInvoiceOfDate(inputLine));
                }
                break;
            case InvoicesMenuItems.SHOW_INVOICES_SPECIFIC_PERSON:
                getOutput().printTheString("Enter last name of person to find invoice of person");
                inputLine = getOutput().readInputLine();
                invoiceController.showInvoiceOfPerson(inputLine);
                break;
            case InvoicesMenuItems.SORT_INVOICES_BY_DATE:
                invoiceController.sortByDate();
                break;
            case InvoicesMenuItems.DELETE_INVOICE_BY_DATE:
                getOutput().printTheString("Enter the date in format dd.mm.year, day without 0 (7.05.2017):");
                inputLine = getOutput().readInputLine();
                invoiceController.deleteInvoiceByDate(inputLine);
                break;

        }
    }
}
