package com.bluesky.repository;

import com.bluesky.model.destination.Group;
import com.bluesky.model.destination.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class UserGroupRepository {
    @Autowired
    private JdbcTemplate jdbcTemplateTwo;

    public void insert(List<User> user, List<Group> group) {


        String sql = "insert into `usergroup` (id,uid,gid) values (?,?,?)";


        jdbcTemplateTwo.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                try {
                    ps.setString(1, UUID.randomUUID().toString());
                    ps.setString(2, user.get(i).getUid());
                    ps.setString(3, group.get(i).getGid());


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            public int getBatchSize() {
                return user.size();
            }

        });

    }
}