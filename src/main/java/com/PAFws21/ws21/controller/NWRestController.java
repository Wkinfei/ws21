package com.PAFws21.ws21.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PAFws21.ws21.model.Customer;
import com.PAFws21.ws21.model.Order;
import com.PAFws21.ws21.repo.NWRepo;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;

import org.springframework.http.ResponseEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;


@RestController
@RequestMapping(path="/api/customers",produces=MediaType.APPLICATION_JSON_VALUE)
public class NWRestController {
    @Autowired
    NWRepo nwRepo;
    
    @GetMapping()
        public ResponseEntity<String> getAllCustomer(@RequestParam(required = false) String limit,
        @RequestParam(required = false) String offset){
            
             List<Customer> custList = nwRepo.getAllCustomer
                                        (Integer.parseInt(limit), Integer.parseInt(offset));
            JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

            for (Customer c : custList) {
                arrBuilder.add(c.toJsonObject());
            }

            return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                        .add("customers",arrBuilder)
                        .build().toString());
        }
          
    @GetMapping("{customerId}")
    public ResponseEntity<String> getCustomerById(@PathVariable Integer customerId){
        List<Customer> customers = nwRepo.getCustomerById(customerId);

        if(customers.isEmpty()){
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Json.createObjectBuilder()
                        .add("message","customerId: %s not found".formatted(customerId))
                        .build().toString());      
        }

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        for (Customer c : customers) {
            arrBuilder.add(c.toJsonObject());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                        .add("customers",arrBuilder)
                        .build().toString());
    }

    @GetMapping("{customerId}/orders")
    public ResponseEntity<String> getOrderById(@PathVariable Integer customerId){
        List<Order> orders = nwRepo.getOrderById(customerId);
        
        if(orders.isEmpty()){
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Json.createObjectBuilder()
                        .add("message","customerId:%s, does not have any orders".formatted(customerId))
                        .build().toString());      
        }

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        for (Order o : orders) {
            arrBuilder.add(o.toJsonObject());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Json.createObjectBuilder()
                        .add("customers",arrBuilder)
                        .build().toString());

    }
}
