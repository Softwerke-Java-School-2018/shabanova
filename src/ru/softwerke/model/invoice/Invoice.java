package ru.softwerke.model.invoice;

import ru.softwerke.model.client.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice implements Comparable<Invoice> {
    Client client;
    List<InvoiceLine> invoiceLines;
    LocalDateTime date;

    public Client getClient() {
        return client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Invoice(Client client, List<InvoiceLine> invoiceLines, LocalDateTime date) {
        this.client = client;
        this.invoiceLines = new ArrayList<>(invoiceLines);
        this.date = date;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public int compareTo(Invoice o) {
        return date.compareTo(o.getDate()) ;
    }
}
