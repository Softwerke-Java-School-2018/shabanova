package ru.softwerke.controller.invoice;

import ru.softwerke.model.device.Device;
import ru.softwerke.model.invoice.InvoiceLine;
import ru.softwerke.model.invoice.InvoiceLineList;

import java.util.List;

public class InvoiceLineController {

    private InvoiceLineList invoiceLineList = new InvoiceLineList();

    public InvoiceLine createInvoiceLine(Device device, long numberSoldItems) {
        InvoiceLine invoiceLine = new InvoiceLine(device, numberSoldItems);
        return invoiceLine;
    }

    public void addInvoiceLineToList(InvoiceLine invoiceLine) {
        invoiceLineList.add(invoiceLine);
    }

    public List<InvoiceLine> getInvoiceList(){
        return invoiceLineList.getInvoiceLineList();
    }
}
