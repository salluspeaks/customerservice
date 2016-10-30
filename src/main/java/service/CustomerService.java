package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Customer;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by sallu on 10/30/2016.
 */
public class CustomerService {
    public static final CustomerService INSTANCE =  new CustomerService();
    private static ObjectMapper mapper = new ObjectMapper();

    public Customer getCustomer(String id) throws IOException {
        String key = "CUST_"+id;
        String customerString = CustomCache.getInstance().get(key);
        if(customerString == null){
            return null;
        }
        return mapper.readValue(customerString,Customer.class);

    }

    public String buildCustomer(Customer customer) throws JsonProcessingException {
        String id = UUID.randomUUID().toString();
        String key = "CUST_"+id;
        customer.setId(id);
        CustomCache.getInstance().put(key,mapper.writeValueAsString(customer));
        return id;
    }

    public void updateCustomer(String id, Customer customer) throws JsonProcessingException {
        String key = "CUST_"+id;
        customer.setId(id);
        CustomCache.getInstance().put(key,mapper.writeValueAsString(customer));
    }





}
