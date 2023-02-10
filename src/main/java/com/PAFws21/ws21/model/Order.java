package com.PAFws21.ws21.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Order {
    private Integer id;
    private Customer c;
    private DateTime orderDate;
    private DateTime shippedDate;
    private String shipName;
    private Double shippingFee;

    public static Order fromSQL(SqlRowSet rs){
        Order order = new Order();
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setCompany(rs.getString("company"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setEmailAddress(rs.getString("email_address"));
        customer.setJobTitle(rs.getString("job_title"));
        customer.setBusinessPhone(rs.getString("business_phone"));
        customer.setAddress(rs.getString("address"));
        customer.setStateProvince(rs.getString("state_province"));
        order.setC(customer);
        order.setId(rs.getInt("order_id"));
        order.setOrderDate(new DateTime(
            DateTimeFormat.forPattern("dd/MM/yyyy")
                            .parseDateTime(rs.getString("order_date"))));
         if (rs.getString("shipped_date") != null)
            order.setShippedDate(DateTimeFormat.forPattern("dd/MM/yyyy")
                                    .parseDateTime(rs.getString("shipped_date")));
        order.setShipName(rs.getString("ship_name"));
        order.setShippingFee(rs.getDouble("shipping_fee"));
        return order;
    } 
    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
                .add("order_id", getId())
                .add("order_date", getOrderDate() != null ? getOrderDate().toString() : "")
                .add("shipped_date", getShippedDate() != null ? getShippedDate().toString() : "")
                .add("ship_name", getShipName())
                .add("shipping_fee", getShippingFee())
                .add("customer_id", getC().getCustomerId().toString())
                .build();
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Customer getC() {
        return c;
    }
    public void setC(Customer c) {
        this.c = c;
    }
    public DateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }
    public DateTime getShippedDate() {
        return shippedDate;
    }
    public void setShippedDate(DateTime shippedDate) {
        this.shippedDate = shippedDate;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public Double getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    
}
