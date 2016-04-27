package mixedquantum.blogspot.com.weather.network.interceptors;

import java.io.IOException;

import mixedquantum.blogspot.com.weather.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ImageAuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder().addQueryParameter("consumer_key", BuildConfig.CONSUMER_KEY).build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
