package com.example.boardproject.application.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardLt is a Querydsl query type for BoardLt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardLt extends EntityPathBase<BoardLt> {

    private static final long serialVersionUID = -336968176L;

    public static final QBoardLt boardLt = new QBoardLt("boardLt");

    public final StringPath beforeData = createString("beforeData");

    public final NumberPath<java.math.BigInteger> boardUtId = createNumber("boardUtId", java.math.BigInteger.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public QBoardLt(String variable) {
        super(BoardLt.class, forVariable(variable));
    }

    public QBoardLt(Path<? extends BoardLt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardLt(PathMetadata metadata) {
        super(BoardLt.class, metadata);
    }

}

