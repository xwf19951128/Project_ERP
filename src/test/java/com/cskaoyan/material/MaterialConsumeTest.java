package com.cskaoyan.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.mapper.material.MaterialConsumeMapper;
import com.cskaoyan.service.material.MaterialConsumeService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/applicationContext.xml")
public class MaterialConsumeTest {

//    private SqlSessionFactory sqlSessionFactory;
//    private SqlSession sqlSession;
//    private Logger logger = Logger.getLogger(this.getClass());
//
//    @Before
//    public void init() throws IOException {
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
//        logger.info("事务已开启！");
//    }
//
//    @After
//    public void after() {
//        if (sqlSession != null) {
//            sqlSession.commit();
//            sqlSession.close();
//            logger.info("事务已提交！");
//        }
//    }

    private Logger logger = Logger.getLogger(this.getClass());


    @Autowired
    MaterialConsumeService materialConsumeService;

    @Test
    public void test1() {
        List<MaterialConsume> materialConsumeList = materialConsumeService.listPageSearchMaterialConsumesByConsumeId(1, 10, "1");
        logger.info("materialConsumeList = " + materialConsumeList);
        System.out.println("materialConsumeList = " + materialConsumeList);
    }



}
