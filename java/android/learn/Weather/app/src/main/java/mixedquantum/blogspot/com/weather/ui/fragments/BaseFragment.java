package mixedquantum.blogspot.com.weather.ui.fragments;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import mixedquantum.blogspot.com.weather.R;
import mixedquantum.blogspot.com.weather.network.responses.ErrorVO;
import mixedquantum.blogspot.com.weather.ui.activities.BaseActivity;

public class BaseFragment extends DialogFragment {
    public static String TAG = BaseFragment.class.getSimpleName();
    protected Activity mActivity;

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    public void setScreenTitle(int resourceId) {
        setScreenTitle(getString(resourceId));
    }

    public void setScreenTitle(String title) {
        if (isAdded()) {
            if (mActivity != null) {
                ((BaseActivity) mActivity).setScreenTitle(title);
            }
        }
    }

    private void setProgressbarVisiblity(int visibility) {
        View container = getView();
        if (container != null) {
            View view = container.findViewById(R.id.progressbar_container);
            if (view != null) {
                view.setVisibility(visibility);
            }
        }
    }

    public void showFragmentProgressbar() {
        setProgressbarVisiblity(View.VISIBLE);
    }

    public void hideFragmentProgressbar() {
        setProgressbarVisiblity(View.GONE);
    }

    @Subscribe
    public void onEvent(ErrorVO error) {
        hideFragmentProgressbar();
        Activity activity = getActivity();
        if (isAdded()) {
            String errorMessage = error.getMessage();
            ((BaseActivity) activity).showErrorSnackbar(errorMessage);
        }
    }
}
