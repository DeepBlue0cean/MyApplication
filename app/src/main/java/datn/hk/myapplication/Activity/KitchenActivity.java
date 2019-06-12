package datn.hk.myapplication.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import datn.hk.myapplication.R;

public class KitchenActivity extends AppCompatActivity {
    @BindView(R.id.tem1_kittchen)
    TextView temp_kitchen;
    @BindView(R.id.gas_kittchen)
    TextView gas_kitchen;
    @BindView(R.id.fire_kittchen)
    TextView fire_kitchen;

    @OnClick(R.id.back)
    public void goBack() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        ButterKnife.bind(this);
    }
}
