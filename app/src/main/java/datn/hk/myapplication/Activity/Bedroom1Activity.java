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

public class Bedroom1Activity extends AppCompatActivity {
    final BedRoom1 bedRoom1 = new BedRoom1();
    public static BedroomServiceImp bedroomServiceImp = new BedroomServiceImp();

    @OnCheckedChanged(R.id.swLight_bed1)
    public  void  turnOnLight(CompoundButton sw){
        if (sw.isChecked()) {
            bedroomServiceImp.lightOn(bedRoom1.light, bedRoom1.BEDROOM1, bedRoom1.LIGHT);
        } else {
            bedroomServiceImp.lightOff(bedRoom1.light, bedRoom1.BEDROOM1, bedRoom1.LIGHT);
        }

    }
    @OnCheckedChanged(R.id.swWindown_bed1)
    public  void  turnOpenWindow(CompoundButton sw){
        if (sw.isChecked()) {
            bedroomServiceImp.windownOpen(bedRoom1.windown, bedRoom1.BEDROOM1, bedRoom1.WINDOW);
        } else {
            bedroomServiceImp.windownClose(bedRoom1.windown, bedRoom1.BEDROOM1, bedRoom1.WINDOW);
        }
    }
    @BindView(R.id.swLight_bed1)
    Switch swLight_bed1;
    @BindView(R.id.swWindown_bed1)
    Switch swWindown_bed1;
    @BindView(R.id.pBar_fan_bed1)
    SeekBar spBarfan;
    @BindView(R.id.valueFan_bed1)
    TextView valueFan_bed1;
    @BindView(R.id.pBar_lamp_bed1)
    SeekBar spBarlamp;
    @BindView(R.id.valueLamp_bed1)
    TextView valueLamp_bed1;
    @BindView(R.id.imLight_bed1)
    ImageView Lamp;
    @OnClick(R.id.back)
    public void goBack(){
        finish();
    }
    int progress_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom1);
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
                valueLamp_bed1.setText((progress_value / 2) + "%");
                spBarlamp.setProgress(progress_value);
                bedroomServiceImp.fanOnOff(bedRoom1.lamp, bedRoom1.BEDROOM1, bedRoom1.LAMP,progress_value/2);

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
                valueFan_bed1.setText((progress_value / 2) + "%");
                spBarfan.setProgress(progress_value);
                bedroomServiceImp.fanOnOff(bedRoom1.fan, bedRoom1.BEDROOM1, bedRoom1.FAN,progress_value/2);
            }
        });
    }
}
