package ru.softwerke.controller.invoice;

import ru.softwerke.model.client.Client;
import ru.softwerke.model.invoice.Invoice;
import ru.softwerke.model.invoice.InvoiceLine;
import ru.softwerke.model.invoice.InvoiceList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.softwerke.view.main.Output.getOutput;

public class InvoiceController {

    private InvoiceList invoicesList = new InvoiceList();

    public void addInvoice(Client client, List<InvoiceLine> invoiceLines, LocalDateTime date) {
        Invoice invoice = new Invoice(client, invoiceLines, date);
        invoicesList.addInvoiceToList(invoice);
    }

    public void showInvoiceLine(InvoiceLine line, Invoice invoice) {
        System.out.printf("|%5s| |%20s| |%12s| |%12s| |%10s| |%5s| |%25s| \n", String.valueOf(line.getDevice().getId()),
                String.valueOf(line.getDevice().getType()) + " " + line.getDevice().getManufactured(),
                String.valueOf(line.getDevice().getColor()), String.valueOf(line.getDevice().getReleaseDate()),
                String.valueOf(line.getDevice().getPrice()), String.valueOf(line.getCount()),
                String.valueOf(invoice.getDate()));
    }

    public void showInvoice() {
        for (Invoice invoice : invoicesList.getInvoicesList()) {
            getOutput().printTheString("client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                    invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                    "Sold items: ");
            getOutput().printNamesOfInvoice();
            for (InvoiceLine line : invoice.getInvoiceLines()) {
                showInvoiceLine(line, invoice);

            }
        }
    }

    public void showInvoice(ArrayList<Invoice> iInvoicesList) {
        for (Invoice invoice : iInvoicesList) {
            getOutput().printTheString("client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                    invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                    "Sold items: ");
            getOutput().printNamesOfInvoice();
            for (InvoiceLine line : invoice.getInvoiceLines()) {
                showInvoiceLine(line, invoice);

            }
        }
    }

    public List<Invoice> findInvoiceOfDate(String inputLine) {
        List<Invoice> foundedInvoices = new ArrayList<>();
        String formattedDate;
        for (Invoice invoice : invoicesList.getInvoicesList()) {
            if (invoice.getDate().getMonthValue() < 10) {
                formattedDate = String.valueOf(invoice.getDate().getDayOfMonth()) + ".0" +
                        String.valueOf(invoice.getDate().getMonthValue()) + "." + String.valueOf(invoice.getDate().getYear());
            } else {
                formattedDate = String.valueOf(invoice.getDate().getDayOfMonth()) + "." +
                        String.valueOf(invoice.getDate().getMonthValue()) + "." + String.valueOf(invoice.getDate().getYear());
            }

            if (inputLine.equals(formattedDate)) {
                foundedInvoices.add(invoice);
            }
        }
        return foundedInvoices;
    }

    public void showInvoiceOfPerson(String lName) {
        boolean flag = false;
        for (Invoice invoice : invoicesList.getInvoicesList()) {
            if (invoice.getClient().getLastName().equalsIgnoreCase(lName)) {
                flag = true;
                getOutput().printTheString("client: " + invoice.getClient().getId() + " " + invoice.getClient().getFirstName() + " " +
                        invoice.getClient().getLastName() + " " + invoice.getClient().getDataBirth() + " \n" +
                        "Sold items: ");
                getOutput().printNamesOfInvoice();
                for (InvoiceLine line : invoice.getInvoiceLines()) {
                    showInvoiceLine(line, invoice);
                }
            }
        }
        if (!flag) {
            getOutput().printTheString("Not found invoice of person with last name: " + lName);

        }
    }

    public void sortByDate() {
        List<Invoice> copyInvoicesList = new ArrayList<>();
        copyInvoicesList.addAll(invoicesList.getInvoicesList());
        Collections.sort(copyInvoicesList);
        showInvoice((ArrayList<Invoice>) copyInvoicesList);
    }

    public void deleteInvoiceByDate(String inputLine) {
        List<Invoice> invoicesOfDate;
        invoicesOfDate = findInvoiceOfDate(inputLine);
        if (invoicesOfDate.size() == 0) {
            getOutput().printTheString("Not found invoices made by date: " + inputLine);
        } else if (invoicesOfDate.size() == 1) {
            getOutput().printTheString("Invoice was delete: ");
            showInvoice((ArrayList<Invoice>) invoicesOfDate);
            invoicesList.deleteInvoice(invoicesOfDate.get(0));
        } else {
        getOutput().printTheString("Invoices made by " + inputLine);
        getOutput().printNamesOfInvoice();
        showInvoice((ArrayList<Invoice>) invoicesOfDate);
        getOutput().printTheString("Enter ID of Client to delete invoice: ");
        long idDelete = Long.valueOf(getOutput().readInputLine());
        Invoice invoiceDelete = null;
            for (Invoice invoice: invoicesOfDate) {
                if (invoice.getClient().getId() == idDelete){
                    invoiceDelete = invoice;
                }
            }
            invoicesList.deleteInvoice(invoiceDelete);
    }
}
}
