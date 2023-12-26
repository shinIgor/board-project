package com.example.boardproject.application.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "member_ut")
public class MemberUt extends BaseEntity{

    @Id
    @Column(name = "usn")
    BigInteger usn;

    @Size(max = 50)
    @Column(name = "user_id", length = 50)
    String userId;

    @Size(max = 100)
    @Column(name = "user_pw", length = 100)
    String userPw;

    @Size(max = 50)
    @Column(name = "nick_name", length = 50)
    String nickName;

    @Column(name = "is_delete")
    Boolean isDelete;

    @Column(name = "permission")
    Integer permission;
}
