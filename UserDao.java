package com.Mistletoe.Dao;


import com.Mistletoe.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

//使用Spring JDBC 方式实现DAO类
@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;//需要注入依赖包spring-jdbc
    //根据与用户相关的SQL语句
    private final static String QUERY_BY_USERNAME = "SELECT ID,UserName FROM"+
            " to_user WHERE UserName=?";
    private final static String MATCH_COUNT_SQL = "SELECT count(*) FROM"+
            " to_user WHERE UserName=? and Password=? ";
    //getMatchCount根据用户名和密码获取匹配的用户数，等于1则代表用户名/ 密码正确，等于0表示错误
    //这是最简单的用户身份认证方式
    public int getMatchCount(String userName,String password)
    {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{ userName,password },Integer.class);
    }

    //使用findUserByUserName()方法来根据用户名获取User对象
    public User findUserByUserName(final String userName)
    {
        final User user = new User();
        jdbcTemplate.query(QUERY_BY_USERNAME, new Object[]{userName},
                //匿名类方式实现的回调函数
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("ID"));
                        user.setUserName(userName);
                    }
                });
        return user;
    }

    @Autowired  //自动注入JdbcTemplate的Bean
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
}

