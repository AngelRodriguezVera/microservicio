package com.example.demo;


import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.TestRepository;

import junit.framework.Assert;

import com.example.demo.repository.TestRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestRepositoryTests {
	
	@Autowired
    private TestRepository testRepository;
	 
	@MockBean 
	TestRepository tRepository;
	
	@Test
    public void findUsers() {
        testRepository.findAll();
        Assert.assertNotNull(testRepository.findAll());
    }
	//Test con mock
	@Test
    public void testMockito() {
        when(tRepository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(testRepository.findAll());
        verify(tRepository, times(1)).findAll();
    }
}
