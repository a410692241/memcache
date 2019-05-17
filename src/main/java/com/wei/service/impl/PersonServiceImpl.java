package com.wei.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wei.bo.PersonExample;
import com.wei.bo.Person;
import com.wei.mapper.PersonMapper;
import com.wei.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public long countByExample(PersonExample example) {
        return personMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PersonExample example) {
        return personMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer personId) {
        return personMapper.deleteByPrimaryKey(personId);
    }

    @Override
    public int insert(Person record) {
        return personMapper.insert(record);
    }

    @Override
    public int insertSelective(Person record) {
        return personMapper.insertSelective(record);
    }

    @Override
    public List<Person> selectByExample(PersonExample example) {
        return personMapper.selectByExample(example);
    }

    @Override
    public Person selectByPrimaryKey(Integer personId) {
        return personMapper.selectByPrimaryKey(personId);
    }

    @Override
    public int updateByExampleSelective(Person record, PersonExample example) {
        return personMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Person record, PersonExample example) {
        return personMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return personMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }

}

