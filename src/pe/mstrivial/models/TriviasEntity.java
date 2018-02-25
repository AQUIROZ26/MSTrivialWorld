package pe.mstrivial.models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TriviasEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.trivias";

    private List<Trivia> findByCriteria(String sql, PeopleEntity peopleEntity, CategoriesEntity categoriesEntity, CompaniesEntity companiesEntity) {
        List<Trivia> trivias = new ArrayList<>();
        if (getConnection() != null) {
                try {
                    ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                    while (resultSet.next()) {
                        Trivia trivia = new Trivia(
                                resultSet.getInt("id"),
                                peopleEntity.findById(resultSet.getInt("trivia:player_1_id"), companiesEntity),
                                peopleEntity.findById(resultSet.getInt("trivia:player_2_id"),companiesEntity),
                                categoriesEntity.findById(resultSet.getInt("category:category:id")),
                                resultSet.getInt("winner"),
                                resultSet.getInt("score_player_1"),
                                resultSet.getInt("score_player_2"),
                                resultSet.getDate("start_date"),
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

    public List<Trivia> findAll (PeopleEntity peopleEntity, CategoriesEntity categoriesEntity, CompaniesEntity companiesEntity){
         return findByCriteria(DEFAULT_SQL, peopleEntity, categoriesEntity, companiesEntity);
        }



}
