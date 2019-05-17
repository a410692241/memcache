package com.wei;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wei.bo.Person;
import com.wei.bo.PersonExample;
import com.wei.config.MemcacheRunner;
import com.wei.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.whalin.MemCached.MemCachedClient;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcacheApplicationTests {
    @Autowired
    private MemcacheRunner memcacheRunner;
    @Autowired
    private PersonService personService;
    @Autowired
    private ObjectMapper objectMapper;
    private MemCachedClient memcachedClient;

    @Before
    public void init(){
        memcachedClient = memcacheRunner.getClient();
    }


    @Test
    public void contextLoads() {
    }


    @Test
    public void setMsg() throws JsonProcessingException {
        List<Person> personList = personService.selectByExample(new PersonExample());
        boolean result = memcachedClient.set("personList", objectMapper.writeValueAsString(personList));
        System.out.println("set结果" + result);
    }


    @Test
    public void get() {
        List<Person> personList = (List<Person>) memcachedClient.get("personList");
        System.out.println(personList);
    }


    
    @Test
    public void remove() {
        boolean result = memcachedClient.delete("personList");
        System.out.println("remove结果" + result);
    }

    @Test
    public void replace() {
        memcachedClient.replace("personList", "666");
        System.out.println(memcachedClient.get("personList"));
    }

    @Test
    public void add() {

    }
}
