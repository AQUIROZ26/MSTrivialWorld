package pe.mstrivial.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionEntity extends BaseEntity {
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

}
