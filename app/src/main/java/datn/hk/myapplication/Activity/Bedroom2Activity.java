package datn.hk.myapplication.Activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import datn.hk.myapplication.HomeServices.BedroomServiceImp;
import datn.hk.myapplication.R;
import datn.hk.myapplication.models.BedRoom1;
import datn.hk.myapplication.models.BedRoom2;

public class Bedroom2Activity extends AppCompatActivity {
    final BedRoom2 bedRoom2 = new BedRoom2();
    public static BedroomServiceImp bedroomServiceImp = new BedroomServiceImp();

    @OnCheckedChanged(R.id.swLight_bed2)
    public  void  turnOnLight(CompoundButton sw){
        if (sw.isChecked()) {
            bedroomServiceImp.lightOn(bedRoom2.light, bedRoom2.BEDROOM1, bedRoom2.LIGHT);
        } else {
            bedroomServiceImp.lightOff(bedRoom2.light, bedRoom2.BEDROOM1, bedRoom2.LIGHT);
        }

    }
    @OnCheckedChanged(R.id.swWindown_bed2)
    public  void  turnOpenWindow(CompoundButton sw){
        if (sw.isChecked()) {
            bedroomServiceImp.windownOpen(bedRoom2.windown, bedRoom2.BEDROOM1, bedRoom2.WINDOW);
        } else {
            bedroomServiceImp.windownClose(bedRoom2.windown, bedRoom2.BEDROOM1, bedRoom2.WINDOW);
        }
    }
    @BindView(R.id.swLight_bed2)
    Switch swLight_bed2;
    @BindView(R.id.swWindown_bed2)
    Switch swWindown_bed2;
    @BindView(R.id.pBar_fan_bed2)
    SeekBar spBarfan;
    @BindView(R.id.valueFan_bed2)
    TextView valueFan_bed2;
    @BindView(R.id.pBar_lamp_bed2)
    SeekBar spBarlamp;
    @BindView(R.id.valueLamp_bed2)
    TextView valueLamp_bed2;
    @BindView(R.id.imLight_bed2)
    ImageView Lamp_bed2;
    @OnClick(R.id.back)
    public void goBack(){
        finish();
    }
    int progress_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom2);
        ButterKnife.bind(this);
        spBarlamp.setMax(200);
        spBarlamp.setProgress(0);
        spBarlamp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
                valueLamp_bed2.setText((progress_value / 2) + "%");
                spBarlamp.setProgress(progress_value);
                bedroomServiceImp.fanOnOff(bedRoom2.lamp, bedRoom2.BEDROOM1, bedRoom2.LAMP,progress_value/2);

            }
        });
        spBarfan.setMax(200);
        spBarfan.setProgress(0);
        spBarfan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
                valueFan_bed2.setText((progress_value / 2) + "%");
                spBarfan.setProgress(progress_value);
                bedroomServiceImp.fanOnOff(bedRoom2.fan, bedRoom2.BEDROOM1, bedRoom2.FAN,progress_value/2);
            }
        });

    }
}
