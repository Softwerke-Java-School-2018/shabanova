package ru.softwerke.model.invoice;

import ru.softwerke.model.device.Device;

public class InvoiceLine {

    private Device device;
    private long count;

    public InvoiceLine(Device device, long count) {
        this.device = device;
        this.count = count;
    }

    public Device getDevice() {
        return device;
    }

    public long getCount() {
        return count;
    }
}