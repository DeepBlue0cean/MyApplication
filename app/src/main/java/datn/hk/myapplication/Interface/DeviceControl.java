package datn.hk.myapplication.Interface;

import java.util.List;

import datn.hk.myapplication.models.Devices;
import datn.hk.myapplication.models.pwmDevices;


public interface DeviceControl {

    void turnOn(Devices devices, String path, String name);

    void turnOff(Devices devices, String path, String name);

    void getVlue(pwmDevices pwmdevices, String path, String name, int value);

    void Record(Devices devices);

    void ViewHistorybyDay(Devices devices, String day);

    List getAllDay(String path);


}
