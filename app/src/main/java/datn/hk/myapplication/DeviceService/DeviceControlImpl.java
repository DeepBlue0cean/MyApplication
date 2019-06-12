package datn.hk.myapplication.DeviceService;

import android.icu.util.Calendar;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datn.hk.myapplication.Interface.DeviceControl;
import datn.hk.myapplication.models.Devices;
import datn.hk.myapplication.models.pwmDevices;


public class DeviceControlImpl extends Devices implements DeviceControl {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final static String LAMP = "/home/BedRoom1/lamp/";
    private final static String STATUS = "status";
    DocumentReference docRef;
    protected static String on, off;
    protected static boolean stt;
    private static Calendar con = Calendar.getInstance();
    private static Calendar coff = Calendar.getInstance();
    Map<String, String> record = new HashMap<>();
    public List showDays;
    private static List<String> day = new ArrayList<>();


    private void UpdateDevice(String path) {

        docRef = db.collection(path).document("status");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Devices oldStatus = documentSnapshot.toObject(Devices.class);
                on = oldStatus.getTurnOn();
                off = oldStatus.getTurnOff();
                stt = oldStatus.isStatus();
            }
        });
    }

    @Override
    public void turnOn(Devices devices, String path, String name) {
        UpdateDevice(path + "/" + name + "/");
        devices.setTurnOff(off);
        devices.setStatus(true);
        devices.setTurnOn(LocalTime.now().toString().substring(0, 8));
        record.put(LocalTime.now().toString().substring(0, 8), name + "_ON");
        db.collection(path + "/history/").document(LocalDate.now().toString())
                .set(record)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Log.w("TAG", "Error writing document", e);
                    }
                });
        db.collection(path + "/" + name + "/").document(STATUS).set(devices);
    }


    @Override
    public void turnOff(Devices devices, String path, String name) {
        UpdateDevice(path + "/" + name + "/");
        devices.setTurnOn(on);
        devices.setStatus(false);
        devices.setTurnOff(LocalTime.now().toString().substring(0, 8));
        record.put(LocalTime.now().toString().substring(0, 8), name + "_OFF");
        db.collection(path + "/history/").document(LocalDate.now().toString())
                .set(record)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Log.w("TAG", "Error writing document", e);
                    }
                });
        db.collection(path + "/" + name + "/").document(STATUS).set(devices);
    }

    @Override
    public void Record(Devices devices) {
        // UpdateDevice();
        db.collection(LAMP).document(STATUS).set(devices);
    }


    @Override
    public void ViewHistorybyDay(Devices devices, String day) {

    }

    @Override
    public void getVlue(pwmDevices pwmdevices, String path, String name, int value) {
        String stt = null;
        if (value == 0) {
            stt = "_OFF";
            pwmdevices.setStatus(false);
            pwmdevices.setTurnOff(LocalTime.now().toString().substring(0, 8));
        } else {
            stt = "_ON: " + value;
            pwmdevices.setTurnOn(LocalTime.now().toString().substring(0, 8));
            pwmdevices.setStatus(true);
        }
        pwmdevices.setValue(value);
        record.put(LocalTime.now().toString().substring(0, 8), name + stt);
        db.collection(path + "/history/").document(LocalDate.now().toString())
                .set(record)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAG", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Log.w("TAG", "Error writing document", e);
                    }
                });
        db.collection(path + "/" + name + "/").document(STATUS).set(pwmdevices);
    }

    @Override
    public List getAllDay(String path) {

        db.collection(path)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                showDays.add(document.getId());
                                System.out.println("HHHHHHHH" + showDays);
                            }
                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
        return showDays;
    }
}
