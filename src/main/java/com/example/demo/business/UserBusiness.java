package com.example.demo.business;

import com.example.demo.businessInterface.IUserBusiness;
import com.example.demo.entity.User;
import com.example.demo.UserInterfaceCruds.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserBusiness implements IUserBusiness {

    @Autowired
    UserRepository userRep;

    @GetMapping("/")
    public List<User> getUsers(){
        return userRep.findAll();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userRep.save(user);
    }

    @GetMapping("/{id}")
    public User getIdUser(@PathVariable("id") Long id) throws Exception{
        return userRep.findById(id).orElseThrow(() -> new Exception("No se encontró el registro"));
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user , @PathVariable("id") Long id){
        try{
            user.setId(id);
            return this.userRep.save(user);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el registro", e);
        }

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws Exception{
        try{
          this.getIdUser(id);
          userRep.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el registro", e);
        }
    }
}
