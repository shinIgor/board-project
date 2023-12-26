package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.BoardHt;
import com.example.boardproject.application.model.repository.querydsl.QBoardHtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface BoardHtRepository extends JpaRepository<BoardHt, BigInteger>, QBoardHtRepository {
}
