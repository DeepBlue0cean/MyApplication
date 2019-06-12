package datn.hk.myapplication.HomeServices;

import datn.hk.myapplication.Interface.Livingroomservice;
import datn.hk.myapplication.models.Devices;
import datn.hk.myapplication.models.pwmDevices;

public class LivingServiceImp extends Livingroomservice {
    @Override
    public void fanOnOff(pwmDevices fan, String path, String name, int value) {
        deviceControl.getVlue(fan, path, name, value);
    }

    @Override
    public void lightOn(Devices light, String path, String name) {
        deviceControl.turnOn(light, path, name);
    }

    @Override
    public void lightOff(Devices light, String path, String name) {
        deviceControl.turnOff(light, path, name);
    }

    @Override
    public void windownOpen(Devices windown, String path, String name) {
        deviceControl.turnOn(windown, path, name);
    }

    @Override
    public void windownClose(Devices windown, String path, String name) {
        deviceControl.turnOff(windown, path, name);
    }

    @Override
    public void curtainOpen(Devices curtain, String path, String name) {
        deviceControl.turnOn(curtain, path, name);
    }

    @Override
    public void curtainClose(Devices curtain, String path, String name) {
        deviceControl.turnOff(curtain, path, name);
    }
}
