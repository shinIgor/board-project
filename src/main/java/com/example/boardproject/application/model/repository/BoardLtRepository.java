package com.example.boardproject.application.model.repository;

import com.example.boardproject.application.model.entity.BoardLt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BoardLtRepository extends JpaRepository<BoardLt, BigInteger> {
}
