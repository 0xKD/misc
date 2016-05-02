package mixedquantum.blogspot.com.weather.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;

import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.models.WeatherForecast;
import mixedquantum.blogspot.com.weather.utils.Constants;
import mixedquantum.blogspot.com.weather.utils.ServiceDelegate;

public class ForecastFragment extends BaseFragment {
    private WeatherForecast mWeatherForecast;

    public static ForecastFragment newInstance(long locationId) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(Constants.OPENWEATHER_LOCATION, locationId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mWeatherForecast == null) {
            showFragmentProgressbar();
            refresh();
        }
    }

    public void refresh() {
        Bundle bundle = getArguments();
        ServiceDelegate.getInstance().getWeatherForecast(bundle.getLong(Constants.OPENWEATHER_LOCATION));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forecast, container, false);
    }

    @Subscribe
    public void onEvent(WeatherForecast weatherForecast) {
        hideFragmentProgressbar();
        Toast.makeText(getActivity(), weatherForecast.getCity().getName(), Toast.LENGTH_SHORT).show();
    }
}
