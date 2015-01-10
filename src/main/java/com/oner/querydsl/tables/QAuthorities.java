package com.oner.querydsl.tables;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.oner.querydsl.models.Authorities;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QAuthorities is a Querydsl query type for Authorities
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QAuthorities extends com.mysema.query.sql.RelationalPathBase<Authorities> {

    private static final long serialVersionUID = 993153729;

    public static final QAuthorities authorities = new QAuthorities("AUTHORITIES");

    public final StringPath authority = createString("authority");

    public final StringPath username = createString("username");

    public QAuthorities(String variable) {
        super(Authorities.class, forVariable(variable), "PUBLIC", "AUTHORITIES");
        addMetadata();
    }

    public QAuthorities(String variable, String schema, String table) {
        super(Authorities.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QAuthorities(Path<? extends Authorities> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "AUTHORITIES");
        addMetadata();
    }

    public QAuthorities(PathMetadata<?> metadata) {
        super(Authorities.class, metadata, "PUBLIC", "AUTHORITIES");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(authority, ColumnMetadata.named("AUTHORITY").withIndex(2).ofType(Types.VARCHAR).withSize(256));
        addMetadata(username, ColumnMetadata.named("USERNAME").withIndex(1).ofType(Types.VARCHAR).withSize(256));
    }

}

