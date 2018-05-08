package ru.softwerke.controller;

import ru.softwerke.model.Client;
import ru.softwerke.model.Invoice;
import ru.softwerke.model.InvoiceLine;
import ru.softwerke.model.InvoiceList;
import ru.softwerke.view.Output;

import java.time.LocalDateTime;
import java.util.List;

import static ru.softwerke.view.Output.output;

public class InvoiceController {

    private InvoiceList invoicesList = new InvoiceList();
    public void addInvoice (Client client, List<InvoiceLine> invoiceLines, LocalDateTime date){
        Invoice invoice = new Invoice(client, invoiceLines, date);
        invoicesList.addInvoiceToList(invoice);
    }

    public InvoiceList getInvoicesList() {
        return invoicesList;
    }

    public void showInvoice (){
        for (Invoice invoice : invoicesList.getInvoicesList()) {
            output.printTheString("Client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                    invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                    "Sold items: ");
            output.printNamesOfInvoice();
            for (InvoiceLine line : invoice.getInvoiceLines()) {
                output.printFormattedString8("|%5s| |%20s| |%12s| |%12s| |%10s| |%5s| |%25s| \n",
                        String.valueOf(line.getDevice().getId()),
                        String.valueOf(line.getDevice().getType())+" "+line.getDevice().getManufactured(),
                        String.valueOf(line.getDevice().getColor()), String.valueOf(line.getDevice().getReleaseDate()),
                        String.valueOf(line.getDevice().getPrice()) ,String.valueOf(line.getCount()),
                        String.valueOf(invoice.getDate()));
            }
        }
    }


}
