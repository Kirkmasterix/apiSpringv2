package com.example.demo.businessInterface;

import com.example.demo.entity.User;
import java.util.List;
public interface IUserBusiness {

    public List<User> getUsers();
    public User createUser(User user);
    public User getIdUser(Long id) throws Exception;
    public User updateUser(User user, Long id)throws Exception;
    public void deleteUser(Long id) throws Exception;
}
