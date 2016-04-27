package mixedquantum.blogspot.com.weather.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.models.CurrentWeather;
import mixedquantum.blogspot.com.weather.ui.activities.BaseActivity;
import mixedquantum.blogspot.com.weather.utils.Constants;

public class CurrentWeatherFragment extends BaseFragment {
    private CurrentWeather currentWeather;

    public static CurrentWeatherFragment newInstance(CurrentWeather weather) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.CURRENT_WEATHER, weather);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        currentWeather = getArguments().getParcelable(Constants.CURRENT_WEATHER);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((BaseActivity) getActivity()).hideActionBar();
        View view = inflater.inflate(R.layout.current_weather, container, false);
        if (currentWeather == null) {
            currentWeather = getArguments().getParcelable(Constants.CURRENT_WEATHER);
        }
        if (currentWeather != null) {
            TextView txtLocation = (TextView) view.findViewById(R.id.location);
            TextView txtDescription = (TextView) view.findViewById(R.id.description);
            TextView txtTemperature = (TextView) view.findViewById(R.id.temperature);
            txtLocation.setText(currentWeather.getName());
            txtDescription.setText(currentWeather.getWeather().get(0).getDescription());  // add check!
            txtTemperature.setText(currentWeather.getMain().getTemp().toString());  // formatting?
        }
        return view;
    }
}
