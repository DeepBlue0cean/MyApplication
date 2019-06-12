package datn.hk.myapplication.Interface;

import datn.hk.myapplication.models.Devices;
import datn.hk.myapplication.models.EnvironmentInfo;

public interface GetInfo {
    void getValue(EnvironmentInfo info, String path, String name);
}
