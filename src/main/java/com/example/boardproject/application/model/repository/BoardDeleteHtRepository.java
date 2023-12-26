package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.BoardDeleteHt;
import com.example.boardproject.application.model.repository.querydsl.QBoardDeleteHtRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BoardDeleteHtRepository extends JpaRepository<BoardDeleteHt, BigInteger>, QBoardDeleteHtRepository {
}
