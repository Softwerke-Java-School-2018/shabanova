package ru.softwerke.model;

import java.util.ArrayList;
import java.util.List;

public class InvoiceLineList {

    private List<InvoiceLine> invoiceLineList = new ArrayList<>();

    public void add(InvoiceLine invoiceLine) {
        invoiceLineList.add(invoiceLine);
    }

    public List<InvoiceLine> getInvoiceLineList (){
        return invoiceLineList;
    }
}
