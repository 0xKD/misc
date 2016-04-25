package mixedquantum.blogspot.com.weather.ui.fragments;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;

import org.greenrobot.eventbus.EventBus;

import mixedquantum.blogspot.com.weather.ui.activities.BaseActivity;

public class BaseFragment extends DialogFragment {
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
}
