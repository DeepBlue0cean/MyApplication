package datn.hk.myapplication.HomeServices;

import android.util.Log;

import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import datn.hk.myapplication.Interface.KitchenService;
import datn.hk.myapplication.databinding.ActivityKitchenBinding;
import datn.hk.myapplication.models.Kitchen;


public class KitchenServiceImp extends KitchenService {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    final String TAG = "GET info in KITCHEN ";
    public static Kitchen kitchen = new Kitchen();
    @Override
    public Kitchen getInfo(    ActivityKitchenBinding activityKitchenBinding,String path, String locate) {
        final DocumentReference docRef = db.collection(path).document(locate);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e);
                    return;
                }
                if (snapshot != null && snapshot.exists()) {
                    kitchen = snapshot.toObject(Kitchen.class);
                    activityKitchenBinding.setKitchen(kitchen);
                    Log.d(TAG, "Current data: " + snapshot.getData());
                } else {
                    Log.d(TAG, "Current data: null");
                }
            }
        });
    return kitchen ;
    }

}

