package mixedquantum.blogspot.com.weather.network;

import mixedquantum.blogspot.com.weather.models.photos.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageEndpoints {
    String BASE_URL = "https://api.500px.com/v1/";
    String API_PHOTOS_SEARCH = "photos/search";


    @GET(API_PHOTOS_SEARCH)
    Call<SearchResult> getPhotos(
            @Query("term") String term,
            @Query("image_size") int image_size,
            @Query("sort") String sort,
            @Query("rpp") int num_results);
}
