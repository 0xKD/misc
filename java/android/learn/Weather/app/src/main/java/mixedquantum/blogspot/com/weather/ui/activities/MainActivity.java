package mixedquantum.blogspot.com.weather.ui.activities;


import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.ui.fragments.DummyFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DummyFragment()).commit();
    }
}
