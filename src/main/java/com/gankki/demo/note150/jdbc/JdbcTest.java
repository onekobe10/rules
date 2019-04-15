package com.gankki.demo.note150.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jdbc测试
 */
public class JdbcTest {


    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String, String>> resultList = null;
        String path = "D:\\greencloud.jpg";
        try {
            // 加载驱动 获取连接
            connection = JdbcTest.getConnection();
            // 创建语句
            String sql = "insert into test (name, sex, photo, text) values (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "测试blob");
            preparedStatement.setString(2, "男");
            InputStream is = new FileInputStream(path);
            preparedStatement.setBlob(3, is);
            preparedStatement.setString(4, "幅度萨芬的发放");
            // 执行语句
            preparedStatement.executeUpdate();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            // 关闭资源
            JdbcTest.closeConntection(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 从JDBC 3.0中还引入了Savepoint（保存点）的概念，允许通过代码设置保存点并让事务回滚到指定的保存点
     *
     * @throws Exception
     */
    public static void getSavePoint() throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Savepoint savepoint = null;
        List<Map<String, String>> resultList = null;

        try {
            // 加载驱动 获取连接
            connection = JdbcTest.getConnection();
            // 不自动提交
            connection.setAutoCommit(false);
            // 创建语句
            String sql0 = " update test t set t.sex = '女' where t.id = 1 ";
            statement = connection.createStatement();
            // 执行语句
            statement.executeUpdate(sql0);
            // 设置保存点
            savepoint = connection.setSavepoint();

            String sql1 = " update test t set t.name = '刘浩' where t.id = 2 ";
            int count = statement.executeUpdate(sql1);
            if (count > 0) {
                System.out.println(count + "......");
                throw new Exception();
            }
            connection.commit();
        } catch (Exception e) {
            // 回滚到保存点的位置
            connection.rollback(savepoint);
            System.out.println("回滚到保存点的位置");
            // 回滚到保存点之后再提交
            connection.commit();
        } finally {
            // 关闭资源
            JdbcTest.closeConntection(connection, statement, resultSet);
        }
    }

    /**
     * preparedStatement练习
     */
    public static void getPrepareStatement() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String, String>> resultList = null;

        try {
            // 加载驱动 获取连接
            connection = JdbcTest.getConnection();
            // 创建语句
            String sql = "select * from sys_role t where t.id = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            // 执行语句
            resultSet = preparedStatement.executeQuery();
            // 指定每次抓取数据的记录数，典型的空间换时间策略
            resultSet.setFetchSize(100);
            // 获取列信息
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = resultSetMetaData.getColumnName(i + 1);
            }
            resultList = new ArrayList<>();
            Map<String, String> resultMap = new HashMap<>();
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    resultMap.put(columnNames[i], resultSet.getString(i + 1));
                }
                resultList.add(resultMap);
            }
            System.out.println("成功查询数据库，查得数据：" + resultList);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            // 关闭资源
            JdbcTest.closeConntection(connection, preparedStatement, resultSet);
        }
    }

    /**
     * statement练习
     */
    public static void getStatement() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Map<String, String>> resultList = null;

        try {
            connection = JdbcTest.getConnection();
            statement = connection.createStatement();
            String sql = "select * from sys_role t";
            resultSet = statement.executeQuery(sql);
            // 获取列信息
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnNames[i] = resultSetMetaData.getColumnName(i + 1);
            }
            resultList = new ArrayList<>();
            Map<String, String> resultMap = new HashMap<>();
            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    resultMap.put(columnNames[i], resultSet.getString(i + 1));
                }
                resultList.add(resultMap);
            }
            System.out.println("成功查询数据库，查得数据：" + resultList);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            JdbcTest.closeConntection(connection, statement, resultSet);
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    private static Connection getConnection() throws Exception {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/gankki?user=root&password=root&useOldAliasMetadataBehavior=true&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        // 创建连接
        Connection connection = DriverManager.getConnection(url);
        return connection;
    }

    /**
     * 关闭连接  资源的关闭顺序与开启顺序相反
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    private static void closeConntection(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
