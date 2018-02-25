package pe.mstrivial.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompaniesEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM trivial_world.companies";
    private List<Company> findByCriteria (String sql){
        List<Company> companies;
        if(getConnection() != null){
            companies = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while  (resultSet.next()){
                    Company company = new Company()
                            .setId(resultSet.getInt("id"))
                            .setName(resultSet.getString("name"))
                            .setRuc(resultSet.getString("ruc"))
                            .setCreateDate(resultSet.getDate("create_date"))
                            .setCreateDate(resultSet.getDate("modify_date"));
                    companies.add(company);
                }
                return companies;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public List<Company> findAll() {

        return findByCriteria(DEFAULT_SQL);
    }

    public Company findById(int id) {
        List<Company> companies = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (companies != null && !companies.isEmpty() ? companies.get(0) : null);
    }

    public Company findByName(String name) {
        List<Company> companies = findByCriteria(DEFAULT_SQL +
                " WHERE name = '" + name + "'");
        return (companies != null && !companies.isEmpty() ? companies.get(0) : null);
    }

    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
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

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM companies WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM companies";
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

    public Company create(String name, String ruc, Date createDate, Date modifyDate) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO companies (id, name, ruc, create_date, modify_date) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" + name + "' , '"+ruc+"' ,"+createDate+", "+modifyDate+")";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Company company = new Company(getMaxId(), name, ruc, createDate, modifyDate);
                    return company;
                }
            }
        }
        return null;
    }

    public boolean update(Company company) {
        if(findByName(company.getName()) != null) return false;
        return updateByCriteria(
                "UPDATE companies SET name = '" +
                        company.getName() + "'" +
                        " WHERE id= " +
                        String.valueOf(company.getId())) > 0;
    }
}
