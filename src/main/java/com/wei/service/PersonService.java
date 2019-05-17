package com.wei.service;

import com.wei.bo.PersonExample;
import com.wei.bo.Person;

import java.util.List;

public interface PersonService{


    long countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    int deleteByPrimaryKey(Integer personId);

    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    Person selectByPrimaryKey(Integer personId);

    int updateByExampleSelective(Person record,PersonExample example);

    int updateByExample(Person record,PersonExample example);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

}
