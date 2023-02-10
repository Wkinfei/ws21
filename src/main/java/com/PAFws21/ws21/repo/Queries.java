package com.PAFws21.ws21.repo;

public class Queries {
    public static final String SQL_NW_SELECT_ALL_LIMIT_OFFSET = """
                                                                SELECT id, company, last_name, first_name, email_address, job_title, 
                                                                business_phone, address, city, state_province FROM customers LIMIT ? OFFSET ?; 
                                                                """;
    public static final String SQL_NW_SELECT_BY_ID = """
                                                        SELECT id, company, last_name, first_name, email_address, job_title, 
                                                        business_phone, address, city, state_province FROM customers
                                                        WHERE id = ?;
                                                    """;
    public static final String SQL_NW_SELECT_ORDER_BY_ID ="""
                                                        SELECT c.id as customer_id, c.company, c.last_name, c.first_name, c.email_address, c.job_title,
                                                        c.business_phone, c.address, c.state_province, o.id AS order_id,
                                                        DATE_FORMAT(o.order_date, \"%d/%m/%Y\") AS order_date,
                                                        DATE_FORMAT(o.shipped_date, \"%d/%m/%Y\") AS shipped_date,
                                                        o.ship_name, o.shipping_fee 
                                                        FROM customers c 
                                                        JOIN orders o 
                                                        ON c.id = o.customer_id AND o.customer_id = ?
                                                         """;
}
