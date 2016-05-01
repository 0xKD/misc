package mixedquantum.blogspot.com.weather.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.Subscribe;

import java.util.Locale;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.models.CurrentWeather;
import mixedquantum.blogspot.com.weather.models.photos.SearchResult;
import mixedquantum.blogspot.com.weather.ui.activities.BaseActivity;
import mixedquantum.blogspot.com.weather.ui.activities.ForecastActivity;
import mixedquantum.blogspot.com.weather.utils.Constants;
import mixedquantum.blogspot.com.weather.utils.ServiceDelegate;
import mixedquantum.blogspot.com.weather.utils.SpaceTime;
import mixedquantum.blogspot.com.weather.utils.Temperature;

public class CurrentWeatherFragment extends BaseFragment implements View.OnClickListener {
    private CurrentWeather mCurrentWeather;

    public static CurrentWeatherFragment newInstance(long locationId) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(Constants.OPENWEATHER_LOCATION, locationId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mCurrentWeather == null) {
            showFragmentProgressbar();
            refresh();
        }
    }

    public void refresh() {
        Bundle bundle = getArguments();
        ServiceDelegate.getInstance().getCurrentWeather(bundle.getLong(Constants.OPENWEATHER_LOCATION));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        BaseActivity baseActivity = ((BaseActivity) getActivity());
        baseActivity.hideActionBar();
        baseActivity.setStatusBarTranslucent(true);
        View view = inflater.inflate(R.layout.current_weather, container, false);
        Button forecastButton = (Button) view.findViewById(R.id.button_forecast);
        forecastButton.setOnClickListener(this);
        return view;
    }

    private void getBackgroundImage() {
        if (getView() != null) {
            TextView txtDescription = (TextView) getView().findViewById(R.id.description);
            String term = String.format(Locale.getDefault(), "%s %s",
                    txtDescription.getText(), SpaceTime.getPreciseName());
            ServiceDelegate.getInstance().getPhoto(term.trim());
        }
    }

    private void getBackgroundImage(boolean precise) {
        // TODO: Clean up this and above method, progressively lower term precision
        if (getView() != null) {
            if (!precise) {
                ServiceDelegate.getInstance().getPhoto(mCurrentWeather.getWeather().get(0).getDescription());
            } else {
                getBackgroundImage();
            }
        }
    }

    @Subscribe
    public void onImageEvent(SearchResult searchResult) {
        if (searchResult.getPhotos().size() > 0) {
            View view = getView();
            if (view != null) {
                fillBackgroundImage(view , searchResult.getPhotos().get(0).getImageUrl());
            }
        } else {
            Log.e(TAG, "No photo found!");
        }
    }

    @Subscribe
    public void onEvent(CurrentWeather currentWeather) {
        hideFragmentProgressbar();
        if (currentWeather.getWeather().size() > 0) {
            mCurrentWeather = currentWeather;
            View view = getView();
            if (view != null) {
                fillView(view);
            }
        }
    }

    public void fillView(View view) {
        if (mCurrentWeather != null) {
            TextView txtLocation = (TextView) view.findViewById(R.id.location);
            TextView txtDescription = (TextView) view.findViewById(R.id.description);
            TextView txtTemperature = (TextView) view.findViewById(R.id.temperature);
            txtLocation.setText(mCurrentWeather.getName());
            txtDescription.setText(mCurrentWeather.getWeather().get(0).getDescription());  // add check!
            Double temp = Temperature.kelvinToCelsius(mCurrentWeather.getMain().getTemp());
            txtTemperature.setText(String.format(Locale.getDefault(), "%.1f°", temp));
            getBackgroundImage();
        }
    }

    public void fillBackgroundImage(View view, String url) {
        ImageView backgroundImage = (ImageView) view.findViewById(R.id.background_image);
        Picasso.with(getContext())
            .load(url)
            .fit()
            .centerCrop()
            .transform(new BlurTransformation(getContext(), 72))
            .into(backgroundImage);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_forecast:
                Intent intent = new Intent(getActivity(), ForecastActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(getContext(), "Wut?", Toast.LENGTH_SHORT).show();
        }
    }
}
