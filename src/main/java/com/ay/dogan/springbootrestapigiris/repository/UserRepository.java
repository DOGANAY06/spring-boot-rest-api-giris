package com.ay.dogan.springbootrestapigiris.repository;

import com.ay.dogan.springbootrestapigiris.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Long> {
//user repository özellik kazandırmak için extends ettik

}
