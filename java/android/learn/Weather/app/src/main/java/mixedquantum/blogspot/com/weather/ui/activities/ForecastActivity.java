package mixedquantum.blogspot.com.weather.ui.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;

import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.ui.fragments.ForecastFragment;
import mixedquantum.blogspot.com.weather.utils.Constants;

public class ForecastActivity extends BaseActivity {
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Long locationId = getIntent().getExtras().getLong(Constants.OPENWEATHER_LOCATION);
        ForecastFragment fragment = ForecastFragment.newInstance(locationId);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
