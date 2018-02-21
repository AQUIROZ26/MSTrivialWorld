package pe.mstrivial.models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.scores";

    private List<Score> findByCriteria(String sql) {
        List<Score> scores;
        if (getConnection() != null) {
            scores = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Score question = new Score()
                            .setId(resultSet.getInt("id"))
                            .setPlayerId(resultSet.getInt("player_id"))
                            .setVictories(resultSet.getInt("victories"))
                            .setDefeats(resultSet.getInt("defeats"))
                            .setCreateDate(resultSet.getDate("create_date"))
                            .setModifyDate(resultSet.getDate("modify_create"));
                    scores.add(question);
                }
                return scores;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Score> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }

    public Score findById(int id) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE id = " + String.valueOf(id));
        return (scores != null ? scores.get(0) : null);
    }

    public Score findByPlayerId(int playerId) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE player_id = '" + playerId + "'");
        return (scores != null ? scores.get(0) : null);
    }


    public Score findByVictories(String victories) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE victories = '" + victories + "'");
        return (scores != null ? scores.get(0) : null);
    }

    public Score findByDefeats(String defeats) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE defeats = '" + defeats + "'");
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