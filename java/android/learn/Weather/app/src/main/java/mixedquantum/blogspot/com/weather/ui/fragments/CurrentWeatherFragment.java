package mixedquantum.blogspot.com.weather.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.Subscribe;

import java.util.Locale;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.models.CurrentWeather;
import mixedquantum.blogspot.com.weather.models.photos.SearchResult;
import mixedquantum.blogspot.com.weather.ui.activities.BaseActivity;
import mixedquantum.blogspot.com.weather.utils.Constants;
import mixedquantum.blogspot.com.weather.utils.ServiceDelegate;
import mixedquantum.blogspot.com.weather.utils.SpaceTime;
import mixedquantum.blogspot.com.weather.utils.Temperature;

public class CurrentWeatherFragment extends BaseFragment {
    private CurrentWeather currentWeather;
    private ImageView imgBackground;
    private TextView txtDescription;

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
            txtDescription = (TextView) view.findViewById(R.id.description);
            TextView txtTemperature = (TextView) view.findViewById(R.id.temperature);
            txtLocation.setText(currentWeather.getName());
            txtDescription.setText(currentWeather.getWeather().get(0).getDescription());  // add check!
            Double temp = Temperature.kelvinToCelsius(currentWeather.getMain().getTemp());
            txtTemperature.setText(String.format(Locale.getDefault(), "%.1f°", temp));
            imgBackground = (ImageView) view.findViewById(R.id.background_image);
            getBackgroundImage();
        }
        return view;
    }

    private void getBackgroundImage() {
        String term = String.format(Locale.getDefault(), "%s %s",
                txtDescription.getText(), SpaceTime.getPreciseName());
        ServiceDelegate.getInstance().getPhoto(term.trim());
    }

    private void getBackgroundImage(boolean precise) {
        // TODO: Clean up this and above method, progressively lower term precision
        if (!precise) {
            ServiceDelegate.getInstance().getPhoto(txtDescription.getText().toString());
        } else {
            getBackgroundImage();
        }
    }

    @Subscribe
    public void onImageEvent(SearchResult searchResult) {
        if (searchResult.getPhotos().size() == 1) {
            Picasso.with(getContext())
                .load(searchResult.getPhotos().get(0).getImageUrl())
                .fit()
                .centerCrop()
                .transform(new BlurTransformation(getContext(), 72))
                .into(imgBackground);
        } else {
            Log.e(TAG, "No photo found!");
        }
    }
}
