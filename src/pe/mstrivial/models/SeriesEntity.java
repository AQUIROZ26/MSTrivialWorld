package pe.mstrivial.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeriesEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.series";

    private List<Serie> findByCriteria(String sql) {
        List<Serie> series;
        if (getConnection() != null) {
            series = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Serie serie = new Serie()
                            .setId(resultSet.getInt("id"))
                            .setCategoryId(resultSet.getInt("category_id"))
                            .setDescriptionSerie(resultSet.getString("description_serie"))
                            .setType(resultSet.getString("type"))
                            .setDirector(resultSet.getString("director"))
                            .setUrl(resultSet.getString("url"))
                            .setCreateDate(resultSet.getDate("create_date"))
                            .setModifyDate(resultSet.getDate("modify_create"));
                    series.add(serie);
                }
                return series;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Serie> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }

    public Serie findById(int id) {
        List<Serie> series = findByCriteria(DEFAULT_SQL +
                " WHERE id = " + String.valueOf(id));
        return (series != null ? series.get(0) : null);
    }

    public Serie findByCategoryId(int categoryId) {
        List<Serie> series = findByCriteria(DEFAULT_SQL +
                " WHERE category_id = '" + categoryId + "'");
        return (series != null ? series.get(0) : null);
    }


    public Serie findByDescriptionSerie(String descriptionSerie) {
        List<Serie> series = findByCriteria(DEFAULT_SQL +
                " WHERE description_serie = '" + descriptionSerie + "'");
        return (series != null ? series.get(0) : null);
    }

    public Serie findByType(String type) {
        List<Serie> series = findByCriteria(DEFAULT_SQL +
                " WHERE type = '" + type + "'");
        return (series != null ? series.get(0) : null);
    }

    public Serie findByDirector(String director) {
        List<Serie> series = findByCriteria(DEFAULT_SQL +
                " WHERE director = '" + director + "'");
        return (series != null ? series.get(0) : null);
    }

    public Serie findByUrl(String url) {
        List<Serie> series = findByCriteria(DEFAULT_SQL +
                " WHERE url = '" + url + "'");
        return (series != null ? series.get(0) : null);
    }


    private int updateByCriteria(String sql) {
        if (getConnection() != null) {
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


    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM series";
        if (getConnection() != null) {
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


    public boolean updateDescriptionSerie(Serie serie) {
        if (findByDescriptionSerie(serie.getDescriptionSerie()) != null) return false;
        return updateByCriteria(
                "UPDATE series SET description_serie = '" + serie.getDescriptionSerie() + "'" +
                        "WHERE id=" + String.valueOf(serie.getId())) > 0;
    }


    public boolean updateType(Serie serie) {
        if (findByType(serie.getType()) != null) return false;
        return updateByCriteria(
                "UPDATE series SET type = '" + serie.getType() + "'" +
                        "WHERE id=" + String.valueOf(serie.getId())) > 0;
    }


    public boolean updateDirector(Serie serie) {
        if (findByDirector(serie.getDirector()) != null) return false;
        return updateByCriteria(
        "UPDATE series SET director = '" + serie.getDirector() + "'" +
        "WHERE id=" + String.valueOf(serie.getId())) > 0;
        }

    public boolean updateUrl(Serie serie) {
        if (findByUrl(serie.getUrl()) != null) return false;
        return updateByCriteria(
                "UPDATE series SET url = '" + serie.getUrl() + "'" +
                        "WHERE id=" + String.valueOf(serie.getId())) > 0;
    }
}