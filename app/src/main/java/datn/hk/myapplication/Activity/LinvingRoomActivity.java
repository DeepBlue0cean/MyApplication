package datn.hk.myapplication.Activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import datn.hk.myapplication.HomeServices.LivingServiceImp;
import datn.hk.myapplication.R;
import datn.hk.myapplication.models.LivingRoom;

public class LinvingRoomActivity extends AppCompatActivity {
    final LivingRoom livingRoom = new LivingRoom();
    public static LivingServiceImp livingServiceImp = new LivingServiceImp();
    @BindView(R.id.pBar_fan_livingroom)
    SeekBar pBar_fan_livingroom;
    @BindView(R.id.swCurtain_livingroom)
    Switch swCurtain_livingroom;
    @BindView(R.id.swLight_livingroom)
    Switch swLight_livingroom;
    @BindView(R.id.swWindown_livingroom)
    Switch swWindow_livingroom;
    @BindView(R.id.valueFan_livingroom)
    TextView valueFane_livingroom;

    @OnClick(R.id.back)
    public void goBack() {
        finish();
    }

    @OnCheckedChanged(R.id.swLight_livingroom)
    public void turnOnLight(CompoundButton sw) {
        if (sw.isChecked()) {
            livingServiceImp.lightOn(livingRoom.light, livingRoom.LIVINGROOM, livingRoom.LIGHT);
        } else {
            livingServiceImp.lightOff(livingRoom.light, livingRoom.LIVINGROOM, livingRoom.LIGHT);
        }

    }
    @OnCheckedChanged(R.id.swWindown_livingroom)
    public  void  turnOpenWindow(CompoundButton sw){
        if (sw.isChecked()) {
            livingServiceImp.windownOpen(livingRoom.windown, livingRoom.LIVINGROOM, livingRoom.WINDOW);
        } else {
            livingServiceImp.windownClose(livingRoom.windown, livingRoom.LIVINGROOM, livingRoom.WINDOW);
        }
    }

    @OnCheckedChanged(R.id.swCurtain_livingroom)
    public  void  turnOpenCurtain(CompoundButton sw){
        if (sw.isChecked()) {
            livingServiceImp.windownOpen(livingRoom.windown, livingRoom.LIVINGROOM, livingRoom.CURTAIN);
        } else {
            livingServiceImp.windownClose(livingRoom.windown, livingRoom.LIVINGROOM, livingRoom.CURTAIN);
        }
    }

    int progress_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linving_room);
        ButterKnife.bind(this);
        pBar_fan_livingroom.setMax(200);
        pBar_fan_livingroom.setProgress(0);
        pBar_fan_livingroom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 25) {
                    progress_value = 0;
                } else if (progress >= 25 && progress < 75) {
                    progress_value = 50;
                } else if (progress >= 75 && progress < 125) {
                    progress_value = 100;
                } else if (progress >= 125 && progress < 175) {
                    progress_value = 150;
                } else if (progress >= 175) {
                    progress_value = 200;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFane_livingroom.setText((progress_value / 2) + "%");
                pBar_fan_livingroom.setProgress(progress_value);
                livingServiceImp.fanOnOff(livingRoom.fan, livingRoom.LIVINGROOM, livingRoom.FAN,progress_value/2);
            }
        });
    }
}
