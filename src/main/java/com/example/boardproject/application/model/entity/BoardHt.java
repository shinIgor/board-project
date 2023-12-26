package com.example.boardproject.application.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "board_ht")
public class BoardHt {
    @Id
    @Column(name = "board_ht_id")
    BigInteger id;

    @Column(name = "board_ut_id")
    BigInteger boardUtId;

    @Column(name = "usn")
    BigInteger usn;

    @Size(max = 200)
    @Column(name = "title", length = 200)
    String title;

    @Column(name = "post")
    String post;

}
