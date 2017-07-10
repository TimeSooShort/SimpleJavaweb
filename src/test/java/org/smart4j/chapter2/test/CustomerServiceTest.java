package org.smart4j.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/7.
 */
public class CustomerServiceTest {
    private final CustomerService service;

    public CustomerServiceTest() {
        this.service = new CustomerService();
    }

    @Before
    public void init() throws IOException {
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }

    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = service.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = service.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "customer100");
        map.put("contact", "John");
        map.put("telephone", "123456");
        boolean result = service.createCustomer(map);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomer() throws Exception{
        long id = 1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("contact", "Eric");
        boolean result = service.updateCustomer(id, map);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomer() throws Exception{
        long id = 1;
        boolean result = service.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}