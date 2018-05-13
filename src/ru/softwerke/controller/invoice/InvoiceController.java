package ru.softwerke.controller.invoice;

import ru.softwerke.controller.sort.Sort;
import ru.softwerke.model.client.Client;
import ru.softwerke.model.invoice.Invoice;
import ru.softwerke.model.invoice.InvoiceLine;
import ru.softwerke.model.invoice.InvoiceList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.softwerke.view.main.Output.output;

public class InvoiceController {

    private InvoiceList invoicesList = new InvoiceList();
    public void addInvoice (Client client, List<InvoiceLine> invoiceLines, LocalDateTime date){
        Invoice invoice = new Invoice(client, invoiceLines, date);
        invoicesList.addInvoiceToList(invoice);
    }

    public InvoiceList getInvoicesList() {
        return invoicesList;
    }

    public void showInvoiceLine(InvoiceLine line, Invoice invoice){
        output.printFormattedString8("|%5s| |%20s| |%12s| |%12s| |%10s| |%5s| |%25s| \n",String.valueOf(line.getDevice().getId()),
                String.valueOf(line.getDevice().getType())+" "+line.getDevice().getManufactured(),
                String.valueOf(line.getDevice().getColor()), String.valueOf(line.getDevice().getReleaseDate()),
                String.valueOf(line.getDevice().getPrice()) ,String.valueOf(line.getCount()),
                String.valueOf(invoice.getDate()));
    }
    public void showInvoice (){
        for (Invoice invoice : invoicesList.getInvoicesList()) {
            output.printTheString("client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                    invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                    "Sold items: ");
            output.printNamesOfInvoice();
            for (InvoiceLine line : invoice.getInvoiceLines()) {
                showInvoiceLine(line, invoice);

            }
        }
    }

    public void showInvoiceOfDate(String inputLine) {
        output.printTheString("Invoices made by date: " + inputLine);
        String formattedDate;
        boolean flag = false;
        for (Invoice invoice : invoicesList.getInvoicesList()) {
            if (invoice.getDate().getMonthValue() < 10) {
                formattedDate = String.valueOf(invoice.getDate().getDayOfMonth()) + ".0" +
                        String.valueOf(invoice.getDate().getMonthValue()) + "." + String.valueOf(invoice.getDate().getYear());
            } else{
                formattedDate = String.valueOf(invoice.getDate().getDayOfMonth()) + "." +
                        String.valueOf(invoice.getDate().getMonthValue()) + "." + String.valueOf(invoice.getDate().getYear());

            }
            if (inputLine.equals(formattedDate)){
                flag = true;
                output.printTheString("client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                        invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                        "Sold items: ");
                output.printNamesOfInvoice();
                for (InvoiceLine line : invoice.getInvoiceLines()) {
                    showInvoiceLine(line, invoice);
                }
            }
        }
        if (!flag){
            output.printTheString("Not found invoices made by date: " + inputLine);
        }

    }

    public void showInvoiceOfPerson(String lName) {
        boolean flag = false;
        for (Invoice invoice : invoicesList.getInvoicesList()) {
            if (invoice.getClient().getLastName().equalsIgnoreCase(lName)){
                flag = true;
                output.printTheString("client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                        invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                        "Sold items: ");
                output.printNamesOfInvoice();
                for (InvoiceLine line : invoice.getInvoiceLines()) {
                    showInvoiceLine(line, invoice);
                }
            }
        }
        if (!flag){
            output.printTheString("Not found invoice of person with last name: " + lName);

        }
    }

    public void sortByDate() {
        Sort sort = new Sort();
        List<Invoice> copyInvoicesList = new ArrayList<>();
        copyInvoicesList.addAll(invoicesList.getInvoicesList());
        Collections.sort(copyInvoicesList);
    }
}
