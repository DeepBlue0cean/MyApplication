package datn.hk.myapplication.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import datn.hk.myapplication.R;

public class GarageActivity extends AppCompatActivity {
    @OnClick(R.id.back)
    public void goBack() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        ButterKnife.bind(this);
    }
}
