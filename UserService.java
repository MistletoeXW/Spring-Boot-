package com.Mistletoe.Service;


import com.Mistletoe.Dao.UserDao;
import com.Mistletoe.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //将UserService标注为一个服务层的Bean
public class UserService {
    private UserDao userDao;

    //hasMatchUser()业务方法简单调用Dao层的Bean
    public boolean hasMatchUser(String userName,String password)
    {
        int matchCount = userDao.getMatchCount(userName,password);
        return matchCount > 0;
    }
    //findUserByUserName()业务方法简单调用Dao层的Bean
    public User findUserByUserName(String userName)
    {
        return userDao.findUserByUserName(userName);
    }

    @Autowired //注入userDao层的Bean
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }


}
