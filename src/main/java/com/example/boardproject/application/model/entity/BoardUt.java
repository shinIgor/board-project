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
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "board_ut")
public class BoardUt extends BaseEntity {
    @Id
    @Column(name = "board_ut_id")
    BigInteger id;

    @Column(name = "usn")
    BigInteger usn;

    @Size(max = 200)
    @Column(name = "title", length = 200)
    String title;

    @Column(name = "post")
    String post;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
}
