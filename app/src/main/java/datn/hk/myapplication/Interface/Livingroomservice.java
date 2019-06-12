package datn.hk.myapplication.Interface;

import datn.hk.myapplication.DeviceService.DeviceControlImpl;
import datn.hk.myapplication.models.Devices;
import datn.hk.myapplication.models.pwmDevices;

public abstract class Livingroomservice {
    public DeviceControlImpl deviceControl = new DeviceControlImpl();

    public abstract void fanOnOff(pwmDevices fan, String path, String name, int value);

    public abstract void lightOn(Devices light, String path, String name);

    public abstract void lightOff(Devices light, String path, String name);

    public abstract void windownOpen(Devices windown, String path, String name);

    public abstract void windownClose(Devices windown, String path, String name);

    public abstract void curtainOpen(Devices curtain, String path, String name);

    public abstract void curtainClose(Devices curtain, String path, String name);
}
