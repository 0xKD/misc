package mixedquantum.blogspot.com.weather.network.responses;

import retrofit2.Response;


public class NetworkVO {
    private Response response;
    private ErrorVO error;

    public NetworkVO (Response response) {
        this.response = response;
    }

    public boolean isSuccessful() {
        return response.isSuccessful();
    }

    public ErrorVO getError() {
        return error;
    }

    public void setError(ErrorVO error) {
        this.error = error;
    }

    public Object getData() {
        return response.body();
    }
}
