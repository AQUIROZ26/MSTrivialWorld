package pe.mstrivial.models;

import javax.smartcardio.CardTerminal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesEntity extends BaseEntity{
    private static String DEFAULT_SQL= "SELECT * FROM trivial_world.categories";
    private List<Category> findByCriteria (String sql){
        List<Category> categories;
        if(getConnection() != null){
            categories = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Category category = new Category()
                            .setId(resultSet.getInt("id"))
                            .setDescriptionCategory(resultSet.getString("description_cateogry"));
                    categories.add(category);
                }
                return categories;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Category> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }

    public Category findById(int id) {
        List<Category> categories= findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (categories != null ? categories.get(0) : null);
    }

    public Category findByDescriptionCategory(String descriptionCategory) {
        List<Category> categories= findByCriteria(DEFAULT_SQL +
                " WHERE description_category = '" + descriptionCategory+ "'");
        return (categories != null ? categories.get(0) : null);
    }

    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM regions WHERE region_id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM categories";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public Category create (String descriptionCategory){
        if(findByDescriptionCategory(descriptionCategory) == null){
            if(getConnection() != null){
                String sql="INSERT INTO categories (id, description_category) VALUES ("+
                        String.valueOf(getMaxId()+1)+", '"+descriptionCategory+"' )";
                int results = updateByCriteria(sql);
                if(results > 0){
                    Category category = new Category(getMaxId(), descriptionCategory);
                    return category;
                }
            }
        }
        return null;
    }

    public boolean update(Category category) {
        if(findByDescriptionCategory(category.getDescriptionCategory()) != null) return false;
        return updateByCriteria(
                "UPDATE categories SET description_category = '" +
                        category.getDescriptionCategory() + "'" +
                        " WHERE id = " +
                        String.valueOf(category.getId())) > 0;
    }
}
;