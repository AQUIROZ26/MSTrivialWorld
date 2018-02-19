package pe.mstrivial.models;

public class Music {

    private int id;
    private int descriptionMusicId;
    private int categoryId;

    public Music(int id, int descriptionMusicId, int categoryId) {
        this.id = id;
        this.descriptionMusicId = descriptionMusicId;
        this.categoryId = categoryId;
    }

    public Music() {
    }

    public int getId() {
        return id;
    }

    public Music setId(int id) {
        this.id = id;
        return this;
    }

    public int getDescriptionMusicId() {
        return descriptionMusicId;
    }

    public Music setDescriptionMusicId(int descriptionMusicId) {
        this.descriptionMusicId = descriptionMusicId;
        return this;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Music setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
