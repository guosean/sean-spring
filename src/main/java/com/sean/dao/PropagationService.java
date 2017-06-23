package com.sean.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by guozhenbin on 2017/6/23.
 */
@Service
public class PropagationService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NEVER)
    public void updateEmployee(){
        jdbcTemplate.execute("update employee set name = '王五' where id = 1");
//        throw new RuntimeException("error");
    }



}
