package datn.hk.myapplication.HomeServices;

import java.util.List;

import datn.hk.myapplication.Interface.BedroomService;
import datn.hk.myapplication.models.Devices;
import datn.hk.myapplication.models.pwmDevices;


public class BedroomServiceImp extends BedroomService {

    @Override
    public void getTemp() {

    }


    @Override
    public void lampRecord() {

    }

    @Override
    public List showDay(String path) {
        return null;
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
    public void windownRecord() {

    }

    @Override
    public void lampOnOff(pwmDevices lamp, String path, String name, int value) {
        deviceControl.getVlue(lamp, path, name, value);
    }

    @Override
    public void fanOnOff(pwmDevices fan, String path, String name, int value) {
        deviceControl.getVlue(fan, path, name, value);
    }

    @Override
    public void fanOn(Devices fan) {

    }

    @Override
    public void fanOf(Devices fan) {

    }

    @Override
    public void fanRecord() {

    }
}
