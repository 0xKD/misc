package mixedquantum.blogspot.com.weather.ui.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;

import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.ui.fragments.CurrentWeatherFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CurrentWeatherFragment fragment = CurrentWeatherFragment.newInstance(1275339L);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
