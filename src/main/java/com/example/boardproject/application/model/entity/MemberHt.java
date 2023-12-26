package com.example.boardproject.application.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "member_ht")

public class MemberHt extends BaseEntity{
    @Id
    @Column(name = "member_ht_id")
    BigInteger id;

    @Column(name = "usn")
    BigInteger usn;

    @Column(name = "before_data")
    String beforeData;

    @Column(name = "after_data")
    String afterData;
}
