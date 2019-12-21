package com.atovk.execise.mutiple.pool;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectOrderByItem;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

public class JDBCConnectPoolTest {


    public static void main(String[] args) throws Exception {

        String sql = "select a.name, b.id, a.class, a.age, b.ids " +
                "from test.test_table a left join test.table_b b on a.id=b.id where a.id > 100" ;

        String sqlb = "select a.name, a.age, b.class from (select name, age from student) a inner join school b on a.id=b.id";

        List<SQLStatement> statements = SQLUtils.parseStatements(sqlb, JdbcConstants.MYSQL);

        SQLSelectOrderByItem sqlSelectOrderByItem = SQLUtils.toOrderByItem(sql, JdbcConstants.MYSQL);


        SQLSelectItem sqlSelectItem = SQLUtils.toSelectItem(sql, JdbcConstants.MYSQL);


        System.out.println();
    }


}
