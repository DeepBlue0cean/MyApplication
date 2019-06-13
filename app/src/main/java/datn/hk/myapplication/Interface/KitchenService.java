package datn.hk.myapplication.Interface;

import datn.hk.myapplication.Activity.KitchenActivity_ViewBinding;
import datn.hk.myapplication.models.Kitchen;


public abstract class KitchenService {
    public static Kitchen kitchen = new Kitchen();
    public final String LOCATE = "Kitchen";
    public final String PATH = "home";

    public abstract Kitchen getInfo(String path, String locate);
}
