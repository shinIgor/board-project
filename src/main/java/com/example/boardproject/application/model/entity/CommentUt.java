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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "comment_ut")
public class CommentUt extends BaseEntity{

    @Id
    @Column(name = "comment_ut_id")
    BigInteger id;

    @Column(name = "usn")
    BigInteger usn;

    @Column(name = "board_ut_id")
    BigInteger boardUtId;

    @Column(name = "parent_id")
    BigInteger parentId;

    @Size(max = 255)
    @Column(name = "comment")
    String comment;
}
