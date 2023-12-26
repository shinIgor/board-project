package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.BoardUt;
import com.example.boardproject.application.model.repository.querydsl.QBoardUtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface BoardUtRepository extends JpaRepository<BoardUt, BigInteger>, QBoardUtRepository {
}
