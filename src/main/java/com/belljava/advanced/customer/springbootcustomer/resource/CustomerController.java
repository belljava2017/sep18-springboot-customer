package com.belljava.advanced.customer.springbootcustomer.resource;


import com.belljava.advanced.customer.springbootcustomer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloCustomer() {
        return "HelloWorld Customer App";
    }


    @RequestMapping(value = "/cust/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer custDetails(@PathVariable int id) {
        Customer c = new Customer();
        if(id == 1){
            c.setName("Raj");
            c.setLocation("Ashburn");
        }else if(id == 2){
            c.setName("Malli");
            c.setLocation("Texas");
        }
        return c;
    }



    @RequestMapping(value = "/cust/{id}/cart/{cartid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity custDetails(@PathVariable int id, @PathVariable int cartid) {
        String url = "http://localhost:1200/cart/1";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        return  restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

    }




    @RequestMapping(value = "/list", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> customerList() {
        List<Customer> clist = list();
        return clist;

    }

    @RequestMapping(value = "/cust", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomer(@RequestBody Customer customer){

        System.out.println("I'm saving in to DB ..."+ customer);
        return "Success";

    }

    private ArrayList<Customer> list() {
        Customer c1 = new Customer();
        c1.setName("Raj");
        c1.setLocation("Herndon");

        Customer c2 = new Customer();
        c2.setName("Vinod");
        c2.setLocation("Ashburn");

        Customer c3 = new Customer();
        c3.setName("Malli");
        c3.setLocation("Sterling");

        ArrayList<Customer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        return list;
    }


}
