package com.ay.dogan.springbootrestapigiris.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass //base entity classını extend eden bütün classlarda miras olarak alınacak
@Getter
@Setter
@ToString

public class BaseEntity implements Serializable { //networkde taşımamızı sağlar Serializable
    private Date createdDate;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

}
