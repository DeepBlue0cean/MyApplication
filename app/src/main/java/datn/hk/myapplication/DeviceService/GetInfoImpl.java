package datn.hk.myapplication.DeviceService;

import com.google.firebase.firestore.FirebaseFirestore;

import datn.hk.myapplication.Interface.GetInfo;
import datn.hk.myapplication.models.EnvironmentInfo;

public class GetInfoImpl extends EnvironmentInfo implements GetInfo {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    public void getValue(EnvironmentInfo info, String path, String name) {

    }
}
