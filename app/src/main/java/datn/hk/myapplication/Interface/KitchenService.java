package datn.hk.myapplication.Interface;

import datn.hk.myapplication.models.EnvironmentInfo;

public abstract class KitchenService {
    public abstract void getTemp(String path, EnvironmentInfo environmentInfo);

    public abstract void getGas(String path,EnvironmentInfo environmentInfo);

    public abstract void getFire(String phth,EnvironmentInfo environmentInfo);

    public abstract void getHum(String path,EnvironmentInfo environmentInfo);
}
