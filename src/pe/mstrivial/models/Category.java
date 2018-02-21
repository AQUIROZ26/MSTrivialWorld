package pe.mstrivial.models;

public class Category {
    private int id;
    private String descriptionCategory;

    public Category() {
    }

    public Category(int id, String descriptionCategory) {
        this.id = id;
        this.descriptionCategory = descriptionCategory;
    }

    public int getId() {
        return id;
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public Category setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
        return this;
    }
}
