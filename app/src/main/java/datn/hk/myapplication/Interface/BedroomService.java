package datn.hk.myapplication.Interface;

import java.util.List;

import datn.hk.myapplication.DeviceService.DeviceControlImpl;
import datn.hk.myapplication.models.Devices;
import datn.hk.myapplication.models.pwmDevices;


public abstract class BedroomService {
    public DeviceControlImpl deviceControl = new DeviceControlImpl();

    public abstract void getTemp();

    public abstract void lampOnOff(pwmDevices lamp, String path, String name, int value);

    public abstract void fanOnOff(pwmDevices fan, String path, String name, int value);

    public abstract void lampRecord();


    public abstract List showDay(String path);


    public abstract void lightOn(Devices light, String path, String name);

    public abstract void lightOff(Devices light, String path, String name);

    public abstract void windownOpen(Devices windown, String path, String name);

    public abstract void windownClose(Devices windown, String path, String name);

    public abstract void windownRecord();


    public abstract void fanOn(Devices fan);

    public abstract void fanOf(Devices fan);

    public abstract void fanRecord();
}
