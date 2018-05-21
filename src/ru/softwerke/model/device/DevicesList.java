package ru.softwerke.model.device;

import java.util.ArrayList;
import java.util.List;

import static ru.softwerke.view.main.Output.getOutput;

public class DevicesList {
    List<Device> devices = new ArrayList<>();

    public void addDevice(Device device)
    {
        devices.add(device);
    }
    public List<Device> getDevicesList()
    {
        return devices;
    }

    public List<Device> sortByType(){
        List returnList = new ArrayList();
        for (Enum en: TypeOfDevice.values()) {
            for (Device device : devices) {
                if (device.getType().equals(en)){
                    returnList.add(device);
                }

            }
        }
        return returnList;
    }

    public void deleteDeviceFromListById(long id) {
        if (devices.size() == 0){
            getOutput().listDevicesIsEmpty();
        }
        else{
            boolean existId = false;
            Device deviceForDelete = null;
            for (Device c: devices) {
                if (c.getId() == id){
                    deviceForDelete = c;
                    existId = true;
                }
            }
            if (!existId){
                getOutput().printTheString("Not found client with " + id + " ID");
            }else{
                devices.remove(deviceForDelete);
            }
        }
    }
}
