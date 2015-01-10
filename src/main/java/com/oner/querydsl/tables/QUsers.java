package com.oner.querydsl.tables;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.oner.querydsl.models.Users;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QUsers extends com.mysema.query.sql.RelationalPathBase<Users> {

    private static final long serialVersionUID = -1013316184;

    public static final QUsers users = new QUsers("USERS");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QUsers(String variable) {
        super(Users.class, forVariable(variable), "PUBLIC", "USERS");
        addMetadata();
    }

    public QUsers(String variable, String schema, String table) {
        super(Users.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "USERS");
        addMetadata();
    }

    public QUsers(PathMetadata<?> metadata) {
        super(Users.class, metadata, "PUBLIC", "USERS");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(enabled, ColumnMetadata.named("ENABLED").withIndex(3).ofType(Types.BOOLEAN).withSize(0));
        addMetadata(password, ColumnMetadata.named("PASSWORD").withIndex(2).ofType(Types.VARCHAR).withSize(256));
        addMetadata(username, ColumnMetadata.named("USERNAME").withIndex(1).ofType(Types.VARCHAR).withSize(256));
    }

}

