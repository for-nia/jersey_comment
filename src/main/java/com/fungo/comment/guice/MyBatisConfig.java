package com.fungo.comment.guice;

import com.google.inject.name.Names;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.bonecp.BoneCPProvider;

/**
 * Created by fornia on 16/10/12.
 */
public class MyBatisConfig extends MyBatisModule{

    @Override
    protected void initialize() {
        /*environmentId("development");
        bindDataSourceProviderType(BoneCPProvider.class);
        //bindTransactionFactoryType(JdbcTransactionFactory.class);

        bindConstant().annotatedWith(Names.named("JDBC.driver")).to("com.mysql.jdbc.Driver");
        bindConstant().annotatedWith(Names.named("bonecp.minConnectionsPerPartition")).to(5);
        bindConstant().annotatedWith(Names.named("bonecp.maxConnectionsPerPartition")).to(7);
        bindConstant().annotatedWith(Names.named("bonecp.partitionCount")).to(3);

        bindConstant().annotatedWith(Names.named("bonecp.connectionTimeoutInMs")).to(3000);
        bindConstant().annotatedWith(Names.named("bonecp.closeConnectionWatchTimeoutInMs")).to(3000);

        mapUnderscoreToCamelCase(true);
        defaultStatementTimeout(2);*/

        environmentId("development");
        bindDataSourceProviderType(BoneCPProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        bindConstant().annotatedWith(Names.named("JDBC.driver")).to("com.mysql.jdbc.Driver");
        bindConstant().annotatedWith(Names.named("bonecp.minConnectionsPerPartition")).to(5);
        bindConstant().annotatedWith(Names.named("bonecp.maxConnectionsPerPartition")).to(7);
        bindConstant().annotatedWith(Names.named("bonecp.partitionCount")).to(3);

        bindConstant().annotatedWith(Names.named("bonecp.connectionTimeoutInMs")).to(3000);
        bindConstant().annotatedWith(Names.named("bonecp.closeConnectionWatchTimeoutInMs")).to(3000);

        mapUnderscoreToCamelCase(true);
        defaultStatementTimeout(2);

        addMapperClasses("com.fungo.comment.mapper");
    }
}
