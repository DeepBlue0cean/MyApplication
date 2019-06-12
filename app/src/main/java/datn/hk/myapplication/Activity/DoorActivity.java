package datn.hk.myapplication.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.OnClick;
import datn.hk.myapplication.R;

public class DoorActivity extends AppCompatActivity {
    @OnClick(R.id.back)
    public void goBack() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);
    }
}
