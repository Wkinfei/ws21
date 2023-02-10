package com.PAFws21.ws21.repo;

import static com.PAFws21.ws21.repo.Queries.*;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.PAFws21.ws21.model.Customer;
import com.PAFws21.ws21.model.Order;


@Repository
public class NWRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomer( Integer limit,Integer offset){
        
        List<Customer> customerList = new LinkedList<>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_NW_SELECT_ALL_LIMIT_OFFSET,limit , offset);

        while(rs.next()){
            customerList.add(Customer.fromSQL(rs));
        }

        return customerList;

    }

    public List<Customer> getCustomerById(Integer id){
        List<Customer> customerList = new LinkedList<>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_NW_SELECT_BY_ID,id);
        while(rs.next()){
            customerList.add(Customer.fromSQL(rs));
        }
        return customerList;
    }

    public List<Order> getOrderById(Integer id){
        List<Order> orderList = new LinkedList<>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_NW_SELECT_ORDER_BY_ID,id);
        while(rs.next()){
            orderList.add(Order.fromSQL(rs));
        }
        return orderList;
    }


    
}
