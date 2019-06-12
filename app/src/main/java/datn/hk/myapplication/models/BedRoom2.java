package datn.hk.myapplication.models;

public class BedRoom2 {
    public final static String LAMP = "lamp";
    public final static String LIGHT = "light";
    public final static String WINDOW = "window";
    public final static String FAN = "fan";
    public final static String TEM = "/home/BedRoom2/";
    public static String BEDROOM1 = "/home/BedRoom2";
    public Devices light = new Devices();
    public pwmDevices lamp = new pwmDevices();
    public pwmDevices fan = new pwmDevices();
    public Devices windown = new Devices();
}
