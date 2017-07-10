package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/7/7.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    
    /**
     * 获取客户列表
     *
     * @return
     */
    public List<Customer> getCustomerList() {
//        Connection con = null;
//        List<Customer> list = null;
//        try {
//            list = new ArrayList<Customer>();
//            String sql = "SELECT * FROM customer";
//            con = DatabaseHelper.getConnection();
//            PreparedStatement statement = con.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                Customer customer = new Customer();
//                customer.setId(rs.getLong("id"));
//                customer.setName(rs.getString("name"));
//                customer.setContact(rs.getString("contact"));
//                customer.setTelephone(rs.getString("telephone"));
//                customer.setEmail(rs.getString("email"));
//                customer.setRemark(rs.getString("remark"));
//                list.add(customer);
//            }
//            return list;
//        } catch (SQLException e) {
//            LOGGER.error("execute sql failure ", e);
//        } finally {
//            DatabaseHelper.closeConnection(con);
//        }
//        return list;

        //使用Commons的DBUtils来替换繁杂的代码
//        Connection con = DatabaseHelper.getConnection();
//        try {
//            String sql = "SELECT * FROM customer";
//            return DatabaseHelper.queryEntityList(Customer.class, con, sql);
//        } finally {
//            DatabaseHelper.closeConnection(con);
//        }

        //引入ThreadLocal,确保一个线程只有一个Connection;
        //原本con是局部变量，被放在虚拟机栈中，是线程私有的，不会引起并发问题,
        // 但多次请求会有多个Connection
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id=" + id;
        return DatabaseHelper.queryEntity(Customer.class, sql);
    }

    /**
     * 创建客户
     * @param filedMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> filedMap) {
        return DatabaseHelper.insertEntity(Customer.class, filedMap);
    }

    /**
     * 更新客户
     * @param id
     * @param filedMap
     * @return
     */
    public boolean updateCustomer(long id, Map<String, Object> filedMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, filedMap);
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
