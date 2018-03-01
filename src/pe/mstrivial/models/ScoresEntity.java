    package pe.mstrivial.models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoresEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.scores";

    private List<Score> findByCriteria(String sql, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = new ArrayList<>();
        if (getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Score score = new Score(
                            resultSet.getInt("id"),
                            resultSet.getInt("victory"),
                            resultSet.getInt("defeat"),
                            resultSet.getInt("point"),
                            peopleEntity.findById(resultSet.getInt("player_id"),companiesEntity));
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
        return (scores != null && scores.isEmpty() ? scores.get(0) : null);
    }

    public Score findByPersonId (int personId, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE player_id = " +personId,peopleEntity, companiesEntity);
        return (scores != null && scores.isEmpty() ? scores.get(0) : null);
    }


    public Score findByVictory(int victory, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE victory = " + victory, peopleEntity, companiesEntity);
        return (scores != null && scores.isEmpty() ? scores.get(0) : null);
    }

    public Score findByDefeat(int defeat, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        List<Score> scores = findByCriteria(DEFAULT_SQL +
                " WHERE defeat = " + defeat, peopleEntity, companiesEntity );
        return (scores != null && scores.isEmpty() ? scores.get(0) : null);
    }

    public Score findByPoint(int point, PeopleEntity peopleEntity, CompaniesEntity companiesEntity){
        List<Score> scores= findByCriteria(DEFAULT_SQL+
                " WHERE point= "+point,peopleEntity,companiesEntity);
        return (scores != null && scores.isEmpty() ? scores.get(0) : null);
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

    public Score create(int victory, int defeat, int point, Person person, PeopleEntity peopleEntity, CompaniesEntity companiesEntity){
        if(findByVictory(victory,peopleEntity,companiesEntity)== null &&
                findByDefeat(defeat,peopleEntity,companiesEntity)== null &&
                findByPoint(point,peopleEntity,companiesEntity)== null){
            if(getConnection() != null){
                String sql="INSERT INTO scores (id, victory, defeat, point, player_id) VALUES ("+
                        String.valueOf(getMaxId()+1)+", "
                        +victory+", "
                        +point+", "
                        +defeat+", "
                        +person+")";
                int results = updateByCriteria(sql);
                if(results>0){
                    Score score = new Score(getMaxId(),victory,defeat, point,person);
                    return score;
                }
            }
        }
        return null;
    }

    public boolean update(Score score, PeopleEntity peopleEntity, CompaniesEntity companiesEntity) {
        if(findByVictory(score.getVictory(), peopleEntity, companiesEntity) !=null &&
                findByDefeat(score.getDefeat(),peopleEntity, companiesEntity) != null &&
                findByPoint(score.getPoint(),peopleEntity, companiesEntity) != null) return false;
                return updateByCriteria(
                "UPDATE scores SET " +
                        "victory= " +score.getVictory()+ ", " +
                        "defeat="+score.getDefeat()+", "+
                        "point" +score.getPoint()+ ", " +
                        "player_id=" + score.getPerson()+
                        " WHERE id= " + String.valueOf(score.getId())) > 0;
    }


}