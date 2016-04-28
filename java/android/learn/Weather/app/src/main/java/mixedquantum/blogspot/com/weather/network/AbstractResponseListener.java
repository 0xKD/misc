package mixedquantum.blogspot.com.weather.network;

import java.io.IOException;

import mixedquantum.blogspot.com.weather.network.responses.ErrorVO;
import mixedquantum.blogspot.com.weather.network.responses.NetworkVO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class AbstractResponseListener<T> implements Callback<T> {
    abstract void onResponse(NetworkVO networkVO);
    abstract void onFailure(ErrorVO errorVO);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        NetworkVO nResponse = new NetworkVO(response);
        if (!nResponse.isSuccessful()) {
            ErrorVO error = new ErrorVO();
            try {
                error.setMessage(response.errorBody().string());
                // Wil show text according to HTTP status code (401 -> Unauthorized)
                // error.setMessage(response.raw().message());
                error.setRequestUrl(response.raw().request().url().toString());
                error.setStatusCode(response.code());
                nResponse.setError(error);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        onResponse(nResponse);
    }

    public void onFailure(Call<T> call, Throwable t) {
        ErrorVO error = new ErrorVO();
        error.setStatusCode(-1);
        onFailure(error);
    }
}
