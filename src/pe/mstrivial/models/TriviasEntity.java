package pe.mstrivial.models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TriviasEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.trivias";
    private List<Trivia> findByCriteria(String sql, PeopleEntity peopleEntity1, PeopleEntity peopleEntity2, Category category) {
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
                            peopleEntity1.findById(resultSet.getInt("player_1_id")),
                            peopleEntity2.findById(resultSet.getInt("player_2_id")),
                            category.findById(resultSet.getInt("category_id")),
                            resultSet.getInt("winner"),
                            resultSet.getInt("score_player_1"),
                            resultSet.getInt("score_player_2"),
                            resultSet.getDate("start_date"));
                    resultSet.getDate("end_date"));
                    trivias.add(trivia);
                }
                return trivias;

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

    public Trivia findById(int id) {
        List<Trivia> trivias = findByCriteria(DEFAULT_SQL +
                " WHERE id = " + String.valueOf(id));
        return (trivias != null ? trivias.get(0) : null);
    }

    public Trivia findByPlayerId(int playerId) {
        List<Trivia> trivias = findByCriteria(DEFAULT_SQL +
                " WHERE player_id = '" + playerId + "'");
        return (trivias != null ? trivias.get(0) : null);
    }


    public Trivia findByVictories(String victories) {
        List<Trivia> trivias = findByCriteria(DEFAULT_SQL +
                " WHERE victories = '" + victories + "'");
        return (trivias != null ? trivias.get(0) : null);
    }

    public Trivia findByDefeats(String defeats) {
        List<Trivia> trivias = findByCriteria(DEFAULT_SQL +
                " WHERE defeats = '" + defeats + "'");
        return (trivias != null ? scores.get(0) : null);
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
