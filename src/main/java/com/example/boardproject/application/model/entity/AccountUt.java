package com.example.boardproject.application.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "account_ut")

public class AccountUt extends BaseEntity{

    @Id
    @Column(name = "account_ut_id")
    BigInteger id;

    @Size(max = 50)
    @Column(name = "user_id", length = 50)
    String userId;

    @Size(max = 255)
    @Column(name = "password_value", length = 255)
    String passwordValue;

    @Size(max = 255)
    @Column(name = "password_key", length = 255)
    String passwordKey;

    @Size(max = 255)
    @Column(name = "nick_name", length = 255)
    String nickName;

    @OneToMany(mappedBy = "boardlt", fetch = FetchType.LAZY)
    @JsonBackReference

    List<BoardUt> boardList;
}
