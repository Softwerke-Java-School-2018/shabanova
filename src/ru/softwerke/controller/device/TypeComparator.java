package ru.softwerke.controller.device;

import ru.softwerke.model.device.Device;

import java.util.Comparator;

/**
 * Created by DS on 14.05.2018.
 */
public class TypeComparator implements Comparator<Device> {
    @Override
    public int compare(Device o1, Device o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
