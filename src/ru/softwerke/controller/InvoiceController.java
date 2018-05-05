package ru.softwerke.controller;

import ru.softwerke.model.Client;
import ru.softwerke.model.Invoice;
import ru.softwerke.model.InvoiceLine;
import ru.softwerke.model.InvoiceList;

import java.time.LocalDateTime;
import java.util.List;

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
            System.out.println("Client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                    invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " " +
                    "Sold items: ");
            for (InvoiceLine line : invoice.getInvoiceLines()) {
                System.out.println(line.getDevice().getId() + " " + line.getDevice().getType() + " " + line.getCount());
            }
        }
    }


}
