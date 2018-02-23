package pe.mstrivial.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswersEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.questions";

    private List<Answer> findByCriteria(String sql, QuestionsEntity questionsEntity) {
        List<Answer> answers;
        if (getConnection() != null) {
            answers = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Answer answer = new Answer(
                            resultSet.getInt("id"),
                            questionsEntity.findById(resultSet.getInt("question_id")),
                            resultSet.getString("description_answer"),
                            resultSet.getInt("flag"),
                            resultSet.getDate("create_date"),
                            resultSet.getDate("modify_create")

                    );
                    answers.add(answer);
                }
                return answers;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Answer> findAll(QuestionsEntity questionsEntity) {

        return findByCriteria(DEFAULT_SQL, questionsEntity);
    }

    public Answer findById(int id, QuestionsEntity questionsEntity) {
        List<Answer> answers = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id), questionsEntity);
        return (answers != null ? answers.get(0) : null);
    }

    /*public Answer findByQuestionEntity(int QuestionEntity, QuestionsEntity questionsEntity) {
        List<Answer> answers = findByCriteria(DEFAULT_SQL +
                " WHERE question_id = '" + questionsEntity+ "'", questionsEntity);
        return (answers != null ? answers.get(0) : null);
    }*/


    public Answer findByDescriptionAnswer(String descriptionAnswer, QuestionsEntity questionsEntity) {
        List<Answer> answers = findByCriteria(DEFAULT_SQL +
                " WHERE description_answer = '" + descriptionAnswer+ "'", questionsEntity);
        return (answers != null ? answers.get(0) : null);
    }

    public Answer findByFlag(int flag, QuestionsEntity questionsEntity) {
        List<Answer> answers = findByCriteria(DEFAULT_SQL +
                " WHERE flag = '" + flag+ "'", questionsEntity);
        return (answers != null ? answers.get(0) : null);
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
        String sql = "SELECT MAX(id) AS max_id FROM answers";
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


   /* public boolean updateDescriptionAnswer (Answer answer){
        if(findByDescriptionAnswer(answer.getDescriptionAnswer(), QuestionsEntity) != null) return false;
        return updateByCriteria(
                "UPDATE questions SET description_question = '"+answer.getDescriptionAnswer()+"'"+
                        "WHERE id="+String.valueOf(answer.getId())) > 0;
    }

*/
}

