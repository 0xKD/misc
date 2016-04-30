package mixedquantum.blogspot.com.weather.ui.activities;


import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.ui.fragments.CurrentWeatherFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onStart() {
        super.onStart();
        CurrentWeatherFragment fragment = CurrentWeatherFragment.newInstance(1275339L);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
