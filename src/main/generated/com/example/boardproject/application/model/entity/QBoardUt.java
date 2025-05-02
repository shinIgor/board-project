package com.example.boardproject.application.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardUt is a Querydsl query type for BoardUt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardUt extends EntityPathBase<BoardUt> {

    private static final long serialVersionUID = -336967897L;

    public static final QBoardUt boardUt = new QBoardUt("boardUt");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath boardName = createString("boardName");

    public final StringPath boardPost = createString("boardPost");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final NumberPath<java.math.BigInteger> ownerUserId = createNumber("ownerUserId", java.math.BigInteger.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QBoardUt(String variable) {
        super(BoardUt.class, forVariable(variable));
    }

    public QBoardUt(Path<? extends BoardUt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardUt(PathMetadata metadata) {
        super(BoardUt.class, metadata);
    }

}

