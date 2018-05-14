package ru.softwerke.controller.client;

import ru.softwerke.model.client.Client;

import java.util.Comparator;

/**
 * Created by DS on 14.05.2018.
 */
public class LastNameComparator implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}
