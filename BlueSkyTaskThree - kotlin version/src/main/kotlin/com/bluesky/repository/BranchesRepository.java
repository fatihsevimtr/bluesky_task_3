package com.bluesky.repository;

import com.bluesky.model.source.Branches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class BranchesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplateOne;

    public List<Branches> select() {

        String sql = "select * from Branches";
        List<Branches> branches = jdbcTemplateOne.query(sql, new RowMapper<Branches>() {
            @Override
            public Branches mapRow(ResultSet resultSet, int i) throws SQLException {
                Branches branch = new Branches();
                branch.setId(resultSet.getInt("id"));
                branch.setName(resultSet.getString("name"));
                branch.setDescription(resultSet.getString("description"));
                branch.setCity(resultSet.getString("city"));
                branch.setContact(resultSet.getString("contact"));
                branch.setCountry(resultSet.getString("country"));
                branch.setPhone(resultSet.getString("phone"));
                branch.setPostCode(resultSet.getInt("postCode"));
                branch.setState(resultSet.getString("state"));

                return branch;
            }
        });


        return branches;
    }
}