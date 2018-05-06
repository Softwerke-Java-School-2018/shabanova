package ru.softwerke.controller;

import ru.softwerke.model.Client;
import ru.softwerke.model.Invoice;
import ru.softwerke.model.InvoiceLine;
import ru.softwerke.model.InvoiceList;
import ru.softwerke.view.Output;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceController {
    Output out = new Output();
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
            out.printTheString("Client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                    invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                    "Sold items: ");
            out.printNamesOfDevice();
            for (InvoiceLine line : invoice.getInvoiceLines()) {
                out.printFormattedString6("|%5s| |%20s| |%12s| |%12s| |%12s| \n",String.valueOf(line.getDevice().getId()),
                        String.valueOf(line.getDevice().getType())+line.getDevice().getManufactured(),
                        String.valueOf(line.getDevice().getColor()), String.valueOf(line.getDevice().getReleaseDate()),
                        String.valueOf(line.getDevice().getPrice()) + " - " + line.getCount());
            //    System.out.println(line.getDevice().getId() + " " + line.getDevice().getType() + " " + line.getCount());
            }
        }
    }


}