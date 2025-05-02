package com.example.boardproject.application.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentLt is a Querydsl query type for CommentLt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentLt extends EntityPathBase<CommentLt> {

    private static final long serialVersionUID = -1592421687L;

    public static final QCommentLt commentLt = new QCommentLt("commentLt");

    public final StringPath beforeData = createString("beforeData");

    public final NumberPath<java.math.BigInteger> boardUtId = createNumber("boardUtId", java.math.BigInteger.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public QCommentLt(String variable) {
        super(CommentLt.class, forVariable(variable));
    }

    public QCommentLt(Path<? extends CommentLt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentLt(PathMetadata metadata) {
        super(CommentLt.class, metadata);
    }

}

