package pe.mstrivial.models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionsEntity extends BaseEntity {
    private static String DEFAULT_SQL= "SELECT * FROM trivial_world.questions";

    private List<Question> findByCriteria (String sql){
        List<Question> questions;
        if(getConnection() != null){
            questions = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Question question = new Question()
                            .setId(resultSet.getInt("id"))
                            .setCategoryId(resultSet.getInt("category_id"))
                            .setDescriptionQuestion(resultSet.getString("description_question"))
                            .setPoint(resultSet.getInt("point"))
                            .setCreateDate(resultSet.getDate("create_date"))
                            .setModifyDate(resultSet.getDate("modify_create"));
                    questions.add(question);
                }
                return questions;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Question> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }

    public Question findById(int id) {
        List<Question> questions = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (questions != null ? questions.get(0) : null);
    }

    public Question findByCategoryId(int categoryId) {
        List<Question> questions = findByCriteria(DEFAULT_SQL +
                " WHERE category_id = '" + categoryId+ "'");
        return (questions != null ? questions.get(0) : null);
    }


    public Question findByDescriptionQuestion(String descriptionQuestion) {
        List<Question> questions = findByCriteria(DEFAULT_SQL +
                " WHERE description_question = '" + descriptionQuestion+ "'");
        return (questions != null ? questions.get(0) : null);
    }

    public Question findByPoint(int point) {
        List<Question> questions = findByCriteria(DEFAULT_SQL +
                " WHERE point = '" + point+ "'");
        return (questions != null ? questions.get(0) : null);
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
        String sql = "SELECT MAX(id) AS max_id FROM questions";
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


    public boolean updateDescriptionQuestion (Question question){
        if(findByDescriptionQuestion(question.getDescriptionQuestion()) != null) return false;
        return updateByCriteria(
                "UPDATE questions SET description_question = '"+question.getDescriptionQuestion()+"'"+
                        "WHERE id="+String.valueOf(question.getId())) > 0;
    }


}
