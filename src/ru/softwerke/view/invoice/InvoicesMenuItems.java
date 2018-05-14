package ru.softwerke.view.invoice;

import static ru.softwerke.view.main.Output.output;

/**
 * Created by DS on 10.05.2018.
 */
public class InvoicesMenuItems {
    public final static String CREATE_INVOICE = "1";
    public final static String SHOW_INVOICES_lIST = "2";
    public final static String SHOW_INVOICES_SPECIFIC_PERSON = "3";
    public final static String FIND_INVOICES_MADE_BY_DATE = "4";
    public final static String SORT_INVOICES_BY_DATE = "5";
    public final static String DELETE_INVOICE_BY_DATE = "6";

    public void displayInvoiceMenu(){
        output.printTheString("1 - make invoice");
        output.printTheString("2 - show list of invoices");
        output.printTheString("3 - find invoice of person");
        output.printTheString("4 - find invoices made by definite date");
        output.printTheString("5 - sort invoices by date");
        output.printTheString("6 - delete invoice of specific date");
    }
}
