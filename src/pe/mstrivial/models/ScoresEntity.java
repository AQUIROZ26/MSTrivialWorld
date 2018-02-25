package pe.mstrivial.models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoresEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.scores";
    private List<Score> findByCriteria(String sql, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores;
        if (getConnection() != null) {
            scores = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Score score = new Score(
                            resultSet.getInt("id"),
                            peopleEntity.findById(resultSet.getInt("player_id"), companiesEntity),
                            resultSet.getInt("victories"),
                            resultSet.getInt("defeats"),
                            resultSet.getDate("create_date"),
                            resultSet.getDate("modify_create"));
                    scores.add(score);
                }
                return scores;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Score> findAll(PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {

        return findByCriteria(DEFAULT_SQL,peopleEntity, companiesEntity);
    }

    public Score findById(int id, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE id = " + String.valueOf(id), peopleEntity, companiesEntity);
        return (scores != null ? scores.get(0) : null);
    }

    public Score findByPersonEntity(int PersonEntity, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE player_id = '" + peopleEntity + "'", peopleEntity, companiesEntity);
        return (scores != null ? scores.get(0) : null);
    }


    public Score findByVictory(int victory, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE victory = '" + victory + "'", peopleEntity, companiesEntity);
        return (scores != null ? scores.get(0) : null);
    }

    public Score findByDefeat(int defeat, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE defeat = '" + defeat + "'", peopleEntity, companiesEntity );
        return (scores != null ? scores.get(0) : null);
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
        String sql = "SELECT MAX(id) AS max_id FROM scores";
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

}