package mixedquantum.blogspot.com.weather.network;

import com.google.gson.GsonBuilder;

import mixedquantum.blogspot.com.weather.network.interceptors.AuthInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkDAO {
    private static Endpoints endpoints;
    private static Call mLatestCall;

    private NetworkDAO() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor())
                .addInterceptor(loggingInterceptor)
                .followRedirects(false)
                .build();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Endpoints.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(okHttpClient)
                .build();
        endpoints = retrofit.create(Endpoints.class);
    }

    private static class NetworkDAOHolder {
        private static final NetworkDAO INSTANCE = new NetworkDAO();
    }

    public static NetworkDAO getInstance() {
        return NetworkDAOHolder.INSTANCE;
    }

    public void retryLast() {
        if (mLatestCall != null) {
            enqueueAndRegister(mLatestCall);
        }
    }

    private void registerCall(Call call) {
        mLatestCall = call.clone();
    }

    private void enqueue(Call call) {
        call.enqueue(ResponseListener.getInstance());
    }

    private void enqueueAndRegister(Call call) {
        enqueue(call);
        registerCall(call);
    }

    public void getWeatherDetails(Long id) {
        enqueueAndRegister(endpoints.getForecast(id));
    }
}
