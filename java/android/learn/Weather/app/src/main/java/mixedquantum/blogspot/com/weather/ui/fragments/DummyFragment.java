package mixedquantum.blogspot.com.weather.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.models.CurrentWeather;
import mixedquantum.blogspot.com.weather.models.WeatherForecast;
import mixedquantum.blogspot.com.weather.ui.activities.BaseActivity;
import mixedquantum.blogspot.com.weather.utils.ServiceDelegate;

public class DummyFragment extends BaseFragment {

    @Override
    public void onStart() {
        super.onStart();
        ((BaseActivity) getActivity()).hideActionBar();
        setScreenTitle(R.string.app_name);
        showFragmentProgressbar();
        ServiceDelegate.getInstance().getWeatherDetails(1275339L);
        ServiceDelegate.getInstance().getCurrentWeather(1275339L);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dummy_fragment, container, false);
    }

    @Subscribe
    public void onEvent(WeatherForecast weatherForecast) {
        Toast.makeText(getActivity(), weatherForecast.getCity().getName(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEvent(CurrentWeather currentWeather) {
        CurrentWeatherFragment fragment = CurrentWeatherFragment.newInstance(currentWeather);
        getFragmentManager().beginTransaction().replace(
                R.id.container, fragment, CurrentWeatherFragment.class.getSimpleName()).commit();
    }
}
