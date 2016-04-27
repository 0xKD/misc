package mixedquantum.blogspot.com.weather.utils.fivehundredpx;

public enum ImageSize {
    C70 (1), C140 (2), C280 (3),
    C100 (100), C200 (200), C440 (440), C600 (600),
    L900 (4), L1170 (5), H1080 (6), H300 (20), H600 (21), H256 (30), H450 (31),
    L1080 (1080), L1600 (1600), L2048 (2048);

    private final int size_code;

    ImageSize(int size_code) {
        this.size_code = size_code;
    }

    public int getSize() {
        return this.size_code;
    }
}
