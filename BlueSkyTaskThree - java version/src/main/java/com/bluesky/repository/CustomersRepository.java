package com.bluesky.repository;


import com.bluesky.model.source.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CustomersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplateOne;


    public List<Customers> select() {

        String sql = "select * from Customers";
        List<Customers> customers = jdbcTemplateOne.query(sql, new RowMapper<Customers>() {
            @Override
            public Customers mapRow(ResultSet resultSet, int i) throws SQLException {
                Customers customer = new Customers();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("firstname"));
                customer.setLastName(resultSet.getString("lastname"));
                customer.setCity(resultSet.getString("city"));
                customer.setContact(resultSet.getString("contact"));
                customer.setCountry(resultSet.getString("country"));
                customer.setAddress1(resultSet.getString("address1"));
                customer.setAddress2(resultSet.getString("address1"));
                customer.setPostCode(resultSet.getInt("postCode"));
                customer.setState(resultSet.getString("state"));
                customer.setPhone1(resultSet.getString("phone1"));
                customer.setPhone2(resultSet.getString("phone2"));
                customer.setFax(resultSet.getString("fax"));
                customer.setEmail(resultSet.getString("email"));
                customer.setWebsite(resultSet.getString("website"));
                customer.setCompany(resultSet.getString("company"));
                customer.setBranchId(resultSet.getInt("branch_id"));
                return customer;
            }
        });


        return customers;
    }
}






