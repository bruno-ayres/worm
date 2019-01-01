package br.com.engineering.worm.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountManager is a Querydsl query type for AccountManager
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccountManager extends EntityPathBase<AccountManager> {

    private static final long serialVersionUID = 227898325L;

    public static final QAccountManager accountManager = new QAccountManager("accountManager");

    public final QDomain _super = new QDomain(this);

    public final BooleanPath active = createBoolean("active");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.Instant> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.Instant> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public QAccountManager(String variable) {
        super(AccountManager.class, forVariable(variable));
    }

    public QAccountManager(Path<? extends AccountManager> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountManager(PathMetadata metadata) {
        super(AccountManager.class, metadata);
    }

}

