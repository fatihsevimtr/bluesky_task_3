package com.bluesky.repository;

import com.bluesky.model.destination.Group;
import com.bluesky.model.source.Branches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


@Repository
public class GroupRepository {
    @Autowired
    private JdbcTemplate jdbcTemplateTwo;

    public void insert(List<Branches> branches) {


        String sql = "insert into `Group` (gid,name, description,city,state) values (?,?,?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplateTwo.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                try {
                    //System.out.println(branches.get(i).getName() + "-" + branches.get(i).getDescription() + "-" + branches.get(i).getCity() + "-" + branches.get(i).getState());
                    ps.setString(1, UUID.randomUUID().toString());
                    ps.setString(2, branches.get(i).getName());
                    ps.setString(3, branches.get(i).getDescription());
                    ps.setString(4, branches.get(i).getCity());
                    ps.setString(5, branches.get(i).getState());

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            public int getBatchSize() {
                return branches.size();
            }

        });
//        int generatedEmployeeId = holder.getKey().intValue();
//        System.out.println("generated EmployeeId = " + generatedEmployeeId);
    }

    public List<Group> select() {

        String sql = "select gid from `group`";
        List<Group> group = jdbcTemplateTwo.query(sql, new RowMapper<Group>() {
            @Override
            public Group mapRow(ResultSet resultSet, int i) throws SQLException {
                Group g  = new Group();
                g.setGid(resultSet.getString("gid"));
                return  g;
            }
        });


        return group;
    }
}