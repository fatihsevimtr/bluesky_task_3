package com.bluesky.repository;

import java.sql.*;
import java.util.List;
import java.util.UUID;


import com.bluesky.model.destination.User;
import com.bluesky.model.destination.UserGroup;
import com.bluesky.model.source.Branches;
import com.bluesky.model.source.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;



@Repository
public class UserRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplateTwo;



    public void insert(List<Customers> customers) {


        String sql = "insert into `User` (uid,firstname,lastname,address,mobile, phone,email,company_name) values (?,?,?,?,?,?,?,?)";


        jdbcTemplateTwo.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                try {
                    String uid = UUID.randomUUID().toString();

                    ps.setString(1, uid);
                    ps.setString(2, customers.get(i).getFirstName());
                    ps.setString(3, customers.get(i).getLastName());
                    ps.setString(4, customers.get(i).getAddress1()+", "+customers.get(i).getAddress2());
                    ps.setString(5, customers.get(i).getPhone1());
                    ps.setString(6, customers.get(i).getPhone2());
                    ps.setString(7, customers.get(i).getEmail());
                    ps.setString(8, customers.get(i).getCompany());


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            public int getBatchSize() {
                return customers.size();
            }

        });

    }


    public List<User> select() {

        String sql = "select uid from `user`";
        List<User> user = jdbcTemplateTwo.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setUid(resultSet.getString("uid"));
                return  u;
            }
        });


        return user;
    }


}