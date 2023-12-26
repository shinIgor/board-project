package com.example.boardproject.application.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigInteger;

@Entity
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "associate_ut")
public class AssociateUt extends BaseEntity{
    @Column(name = "associate_ut_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;

    @Column(name = "usn")
    BigInteger usn;

    @Size(max = 50)
    @Column(name = "user_id", length = 50)
    String userId;

    @Size(max = 100)
    @Column(name = "user_pw", length = 100)
    String userPw;

    @Column(name = "type")
    @ColumnDefault("0")
    Integer type;

    @PrePersist
    public void prePersist() {
        this.type = this.type == null ? 0 : this.type;
        this.usn = this.usn == null ? BigInteger.valueOf(0) : this.usn;
    }
}
