package pe.mstrivial.models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TriviasEntity extends BaseEntity {
   /* private static String DEFAULT_SQL = "SELECT * FROM trivial_world.trivias";
    private List<Trivia> findByCriteria(String sql, PeopleEntity peopleEntity) {
        List<Trivia> trivias;
        if (getConnection() != null) {
            trivias = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Trivia trivia = new Trivia(
                            resultSet.getInt("id"),
                            peopleEntity.findById(resultSet.getInt("player_1_id")),
                            peopleEntity.findById(resultSet.getInt("player_2_id")),
                            peopleEntity.findById(resultSet.getInt("category_id")),
                            resultSet.getInt("winner"),
                            resultSet.getInt("score_player_1"),
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

//    public List<Score> findAll() {
//
//        return findByCriteria(DEFAULT_SQL);
//    }

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

*/

}
