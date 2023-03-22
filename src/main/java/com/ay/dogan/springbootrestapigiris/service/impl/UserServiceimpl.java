package com.ay.dogan.springbootrestapigiris.service.impl;

import com.ay.dogan.springbootrestapigiris.entity.User;
import com.ay.dogan.springbootrestapigiris.repository.UserRepository;
import com.ay.dogan.springbootrestapigiris.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor //constructor oluşturur  verilenin
public class UserServiceimpl implements UserService {
    //Diğer servisler ile iletişim kurularak onlarla veri alışverişi sağlanır.

    private final UserRepository userRepository;


    @Override
    public User createUser(User user) {
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id); //böyle bir kayıt var mı alır
        if (user.isPresent()){
            return user.get();
        } //var mı böyle kayıt
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> resultUser = userRepository.findById(id); //böyle bir kayıt var mı alır
        if (resultUser.isPresent()){
            resultUser.get().setFirstName(user.getFirstName()); //atıyoruz güncelliyoruz
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setUpdatedAt(new Date());
            resultUser.get().setUpdatedBy("Admin");

            return userRepository.save(resultUser.get());

        } //var mı böyle kayıt
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id); //böyle bir kayıt var mı alır
        if (user.isPresent()){
            userRepository.deleteById(id);
            return true;
        } //var mı böyle kayıt varsa silinme işlemi gerçekleşir
        return false;
    }
}
