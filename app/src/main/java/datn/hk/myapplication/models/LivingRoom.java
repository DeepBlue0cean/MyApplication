package datn.hk.myapplication.models;

public class LivingRoom {
    public final static String CURTAIN = "curtain";
    public final static String LIGHT = "light";
    public final static String WINDOW = "window";
    public final static String FAN = "fan";
    public final static String TEM = "/home/LivingRoom/";
    public static String LIVINGROOM = "/home/LivingRoom";
    public Devices light = new Devices();
    public Devices curtain = new Devices();
    public pwmDevices fan = new pwmDevices();
    public Devices windown = new Devices();
}
