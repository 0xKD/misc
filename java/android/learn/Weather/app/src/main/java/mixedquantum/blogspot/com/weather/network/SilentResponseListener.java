package mixedquantum.blogspot.com.weather.network;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import mixedquantum.blogspot.com.weather.network.responses.ErrorVO;
import mixedquantum.blogspot.com.weather.network.responses.NetworkVO;

public class SilentResponseListener extends AbstractResponseListener {
    public static final String TAG = SilentResponseListener.class.getSimpleName();
    private static SilentResponseListener instance;

    private SilentResponseListener() {

    }

    public static SilentResponseListener getInstance() {
        if (instance == null) {
            instance = new SilentResponseListener();
        }
        return instance;
    }

    @Override
    void onResponse(NetworkVO response) {
        if (response.isSuccessful()) {
            EventBus.getDefault().post(response.getData());
        } else {
            Log.e(TAG, response.getError().getMessage());
        }
    }

    @Override
    void onFailure(ErrorVO errorVO) {
        Log.e(TAG, errorVO.getMessage());
    }
}
