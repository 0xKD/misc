package mixedquantum.blogspot.com.weather.network;

import org.greenrobot.eventbus.EventBus;

import mixedquantum.blogspot.com.weather.network.responses.ErrorVO;
import mixedquantum.blogspot.com.weather.network.responses.NetworkVO;


public class ResponseListener extends AbstractResponseListener {
    private static ResponseListener instance;

    private ResponseListener() {

    }

    public static ResponseListener getInstance() {
        if (instance == null) {
            instance = new ResponseListener();
        }
        return instance;
    }

    @Override
    void onResponse(NetworkVO response) {
        if (response.isSuccessful()) {
            EventBus.getDefault().post(response.getData());
        } else {
            EventBus.getDefault().post(response.getError());
        }
    }

    @Override
    void onFailure(ErrorVO errorVO) {
        EventBus.getDefault().post(errorVO);
    }
}
