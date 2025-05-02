package com.example.boardproject.application.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommentUt is a Querydsl query type for CommentUt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentUt extends EntityPathBase<CommentUt> {

    private static final long serialVersionUID = -1592421408L;

    public static final QCommentUt commentUt = new QCommentUt("commentUt");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<java.math.BigInteger> boardUtId = createNumber("boardUtId", java.math.BigInteger.class);

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> ownerUserId = createNumber("ownerUserId", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> parentCommentUtId = createNumber("parentCommentUtId", java.math.BigInteger.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCommentUt(String variable) {
        super(CommentUt.class, forVariable(variable));
    }

    public QCommentUt(Path<? extends CommentUt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommentUt(PathMetadata metadata) {
        super(CommentUt.class, metadata);
    }

}

