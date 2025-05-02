package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.CommentLt;
import com.example.boardproject.application.model.repository.querydsl.QCommentUtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CommentLtRepository extends JpaRepository<CommentLt, BigInteger>,QCommentUtRepository {
}
