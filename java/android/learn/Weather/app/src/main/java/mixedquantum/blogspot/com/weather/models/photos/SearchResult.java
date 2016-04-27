package mixedquantum.blogspot.com.weather.models.photos;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("current_page")
    @Expose
    private Long currentPage;
    @SerializedName("total_pages")
    @Expose
    private Long totalPages;
    @SerializedName("total_items")
    @Expose
    private Long totalItems;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = new ArrayList<>();

    /**
     *
     * @return
     * The currentPage
     */
    public Long getCurrentPage() {
        return currentPage;
    }

    /**
     *
     * @param currentPage
     * The current_page
     */
    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public Long getTotalPages() {
        return totalPages;
    }

    /**
     *
     * @param totalPages
     * The total_pages
     */
    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    /**
     *
     * @return
     * The totalItems
     */
    public Long getTotalItems() {
        return totalItems;
    }

    /**
     *
     * @param totalItems
     * The total_items
     */
    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    /**
     *
     * @return
     * The photos
     */
    public List<Photo> getPhotos() {
        return photos;
    }

    /**
     *
     * @param photos
     * The photos
     */
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
