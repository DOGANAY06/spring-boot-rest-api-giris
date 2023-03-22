package com.ay.dogan.springbootrestapigiris.api;


import com.ay.dogan.springbootrestapigiris.entity.User;
import com.ay.dogan.springbootrestapigiris.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //dışarıya açılacağını bildirmek için
@RequestMapping("/user")
public class UserController  { //controller servis katmanıyla konuşur


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    } //rastgele bir atama yapmasının önüne geçiyoruz

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User resultUser= userService.createUser(user); //user srvisten geleni gönderiyoruz
        return ResponseEntity.ok(resultUser);

    }
    //bütün kayıtlar döner
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers(){
       List<User> users = userService.getUsers();
       return ResponseEntity.ok(users);
       //http 200 e karşılık gelir body de liste döner
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){

        User user = userService.getUser(id);

        return ResponseEntity.ok(user);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<User>update(@PathVariable("id")Long id,@RequestBody User user){
        User resultUser = userService.updateUser(id,user);
        return  ResponseEntity.ok(user);
    }//kayıt var mı kontrol ediyoruz

    @DeleteMapping("/remove/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") Long id){
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);

    }

}
