package com.sean.dao;

import com.sean.context.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by guozhenbin on 2017/6/20.
 *
 * 事务传播特性：
 * 1、REQUIRED
 *
 * 2、REQUIRED_NEW
 *
 *
 *
 */
@Component
public class TransactionService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> queryEmployee(){
        return jdbcTemplate.queryForList("select * from employee");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEmployee(Employee employee){
        jdbcTemplate.execute("insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('8','8','sean','15110042222','北京','1','1')");
        try {
            updateEmployee();
        }catch (Exception e){}

    }

    @Transactional(propagation = Propagation.NEVER)
    public void updateEmployee(){
        jdbcTemplate.execute("update employee set name = '王五' where id = 1");
//        throw new RuntimeException("error");
    }

}
