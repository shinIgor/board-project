package com.example.boardproject.application.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountUt is a Querydsl query type for AccountUt
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountUt extends EntityPathBase<AccountUt> {

    private static final long serialVersionUID = -1924434898L;

    public static final QAccountUt accountUt = new QAccountUt("accountUt");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<BoardUt, QBoardUt> boardList = this.<BoardUt, QBoardUt>createList("boardList", BoardUt.class, QBoardUt.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final StringPath nickName = createString("nickName");

    public final StringPath passwordKey = createString("passwordKey");

    public final StringPath passwordValue = createString("passwordValue");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userId = createString("userId");

    public QAccountUt(String variable) {
        super(AccountUt.class, forVariable(variable));
    }

    public QAccountUt(Path<? extends AccountUt> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountUt(PathMetadata metadata) {
        super(AccountUt.class, metadata);
    }

}

