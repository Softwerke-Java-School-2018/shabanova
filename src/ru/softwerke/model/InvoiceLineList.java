package ru.softwerke.model;

import java.util.ArrayList;

public class InvoiceLineList {

    ArrayList<InvoiceLine> invoiceLineList = new ArrayList<>();

    public void add(InvoiceLine invoiceLine) {
        invoiceLineList.add(invoiceLine);
    }

    public ArrayList<InvoiceLine> getInvoiceLineList (){
        return invoiceLineList;
    }
}
