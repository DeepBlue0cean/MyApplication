package datn.hk.myapplication.Interface;

import datn.hk.myapplication.databinding.ActivityKitchenBinding;
import datn.hk.myapplication.models.Kitchen;


public abstract class KitchenService {

    public final String LOCATE = "Kitchen";
    public final String PATH = "home";

    public abstract Kitchen getInfo(ActivityKitchenBinding activityKitchenBinding,String path, String locate);
}
