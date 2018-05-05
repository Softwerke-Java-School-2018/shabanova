package ru.softwerke.model;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {
    Client client;
    List<InvoiceLine> invoiceLines;
    LocalDateTime Date;

    public Client getClient() {
        return client;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public Invoice(Client client, List<InvoiceLine> invoiceLines, LocalDateTime date) {
        this.client = client;
        this.invoiceLines = invoiceLines;
        Date = date;
    }

    public List<InvoiceLine> getInvoiceLines() {

        return invoiceLines;
    }


}
