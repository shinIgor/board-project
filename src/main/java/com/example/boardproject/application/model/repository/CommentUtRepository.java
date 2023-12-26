package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.CommentUt;
import com.example.boardproject.application.model.repository.querydsl.QCommentUtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface CommentUtRepository extends JpaRepository<CommentUt, BigInteger>,QCommentUtRepository {
}
