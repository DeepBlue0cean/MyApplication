package datn.hk.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import datn.hk.myapplication.R;

public class fragment_home extends Fragment {

    @OnClick(R.id.cv_livingroom)
    public void goLivingroom() {
        startActivity(new Intent(getActivity(), LinvingRoomActivity.class));
    }

    @OnClick(R.id.cv_garage)
    public void goGarage() {
        startActivity(new Intent(getActivity(), GarageActivity.class));
    }

    @OnClick(R.id.cv_bed1)
    public void goBedroom1() {
        startActivity(new Intent(getActivity(), Bedroom1Activity.class));
    }

    @OnClick(R.id.cv_bed2)
    public void goBedroom2() {
        startActivity(new Intent(getActivity(), Bedroom2Activity.class));
    }

    @OnClick(R.id.cv_kitchen)
    public void goKitchen() {
        startActivity(new Intent(getActivity(), KitchenActivity.class));
    }

    @OnClick(R.id.cv_door)
    public void ceckDoor() {

    }


    @Nullable
    @Override
    public View onCreateView(@Nonnull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        //  goLivingroom();
        return view;
    }
}

