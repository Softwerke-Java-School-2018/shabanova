package ru.softwerke.model.invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceList {

    List<Invoice> invoices = new ArrayList<>();

    public void addInvoiceToList (Invoice invoice){
        invoices.add(invoice);
    }

    public List<Invoice> getInvoicesList (){
        return  invoices;
    }
    public void deleteInvoice (Invoice invoice){
        invoices.remove(invoice);
    }
}
