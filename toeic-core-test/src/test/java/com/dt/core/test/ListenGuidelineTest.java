package com.dt.core.test;

import com.dt.core.dao.ListenGuidelineDao;
import com.dt.core.daoimpl.ListenGuidelineDaoImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ListenGuidelineTest {

    ListenGuidelineDao dao;

    @BeforeTest
    public void initData(){
        dao = new ListenGuidelineDaoImpl();
    }

    @Test
    public void checkFindRoleByUser(){
        Map<String, Object>property = new HashMap<>();
        Object[] objects = dao.findByProperty(property,null,null,0,2);
    }

}
