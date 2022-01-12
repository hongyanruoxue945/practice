package com.zhm.demo.demo;

import com.alibaba.fastjson.JSONObject;
import com.zhm.demo.entity.UserEntity;
import com.zhm.demo.mapper.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatisDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. 创建SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3. 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4. 获取Mapper
        Mapper userMapper = sqlSession.getMapper(Mapper.class);
        // 5. 执行接口方法
        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");
        UserEntity userInfo = userMapper.getUserInfo(userEntity);
        System.out.println("userInfo = " + JSONObject.toJSONString(userInfo));
        // 6. 提交事物
        sqlSession.commit();
        // 7. 关闭资源
        sqlSession.close();
        inputStream.close();
    }

}
