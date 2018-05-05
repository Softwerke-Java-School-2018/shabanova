package ru.softwerke.controller;

import ru.softwerke.model.Device;
import ru.softwerke.model.InvoiceLine;
import ru.softwerke.model.InvoiceLineList;

import java.util.ArrayList;

public class InvoiceLineController {

    private InvoiceLineList invoiceLineList = new InvoiceLineList();

    public InvoiceLine createInvoiceLine(Device device, long numberSoldItems) {
        InvoiceLine invoiceLine = new InvoiceLine(device, numberSoldItems);
        return invoiceLine;
    }

    public void addInvoiceLineToList(InvoiceLine invoiceLine) {
        invoiceLineList.add(invoiceLine);
    }

    public ArrayList<InvoiceLine> getInvoiceList(){
        return invoiceLineList.getInvoiceLineList();
    }
}
