package com.minivision.reus.common.util;

import com.minivision.plus.core.toolkit.CollectionUtils;
import com.minivision.reus.common.dto.database.DatabaseConfig;
import com.minivision.reus.common.dto.database.DatabaseDTO;
import com.minivision.reus.common.dto.database.DbType;

import com.minivision.reus.common.exception.DbDriverLoadingException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.internal.util.ClassloaderUtility;

import java.sql.*;
import java.util.*;

/**
 * Created by Owen on 6/12/16.
 */
@Slf4j
public class DbUtil {

    private static final int DB_CONNECTION_TIMEOUTS_SECONDS = 1;

    private static Map<DbType, Driver> drivers = new HashMap<>();

    public static Connection getConnection(DatabaseDTO config) throws ClassNotFoundException, SQLException {
        DbType dbType = DbType.valueOf(config.getDatabaseType());
        if (drivers.get(dbType) == null) {
            loadDbDriver(dbType);
        }

        String url = getConnectionUrlWithSchema(config);
        Properties props = new Properties();

        props.setProperty("user", config.getUserName()); //$NON-NLS-1$
        props.setProperty("password", config.getPassword()); //$NON-NLS-1$
        DriverManager.setLoginTimeout(DB_CONNECTION_TIMEOUTS_SECONDS);
        Connection connection = drivers.get(dbType).connect(url, props);
        log.info("getConnection, connection url: {}", connection);
        return connection;
    }

    @Deprecated
    public static Connection getConnection(DatabaseConfig config) throws ClassNotFoundException, SQLException {
        DbType dbType = DbType.valueOf(config.getDbType());
        if (drivers.get(dbType) == null) {
            loadDbDriver(dbType);
        }

        String url = getConnectionUrlWithSchema(config);
        Properties props = new Properties();

        props.setProperty("user", config.getUsername()); //$NON-NLS-1$
        props.setProperty("password", config.getPassword()); //$NON-NLS-1$

        DriverManager.setLoginTimeout(DB_CONNECTION_TIMEOUTS_SECONDS);
        Connection connection = drivers.get(dbType).connect(url, props);
        log.info("getConnection, connection url: {}", connection);
        return connection;
    }

    public static List<String> getTableNames(DatabaseDTO config) throws ClassNotFoundException, SQLException {
        String url = getConnectionUrlWithSchema(config);
        log.info("getTableNames, connection url: {}", url);
        Connection connection = getConnection(config);
        try {

            List<String> tables = new ArrayList<>();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs;
            log.info("[DbUtil] the DbType Sql_Server is {}", DbType.SQL_Server);
            if (DbType.valueOf(config.getDatabaseType()) == DbType.SQL_Server) {
                String sql = "select name from sysobjects  where xtype='u' or xtype='v' ";
                rs = connection.createStatement().executeQuery(sql);
                while (rs.next()) {
                    tables.add(rs.getString("name"));
                }
            } else if (DbType.valueOf(config.getDatabaseType()) == DbType.Oracle) {
                rs = md.getTables(null, config.getUserName().toUpperCase(), null, new String[] { "TABLE", "VIEW" });
            } else if (DbType.valueOf(config.getDatabaseType()) == DbType.Sqlite) {
                String sql = "Select name from sqlite_master;";
                rs = connection.createStatement().executeQuery(sql);
                while (rs.next()) {
                    tables.add(rs.getString("name"));
                }
            } else {
                // rs = md.getTables(null, config.getUsername().toUpperCase(), null, null);

                rs = md.getTables(config.getDatabase(), null, "%", new String[] { "TABLE", "VIEW" });            //针对 postgresql 的左侧数据表显示
            }
            while (rs.next()) {
                tables.add(rs.getString(3));
            }
            return tables;
        } finally {
            if (connection != null) {
                connection.close();
            }

        }
    }

    @Deprecated
    public static List<String> getTableNames(DatabaseConfig config) throws Exception {
        String url = getConnectionUrlWithSchema(config);
        log.info("getTableNames, connection url: {}", url);
        Connection connection = getConnection(config);
        try {
            List<String> tables = new ArrayList<>();
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs;
            if (DbType.valueOf(config.getDbType()) == DbType.SQL_Server) {
                String sql = "select name from sysobjects  where xtype='u' or xtype='v' ";
                rs = connection.createStatement().executeQuery(sql);
                while (rs.next()) {
                    tables.add(rs.getString("name"));
                }
            } else if (DbType.valueOf(config.getDbType()) == DbType.Oracle) {
                rs = md.getTables(null, config.getUsername().toUpperCase(), null, new String[] { "TABLE", "VIEW" });
            } else if (DbType.valueOf(config.getDbType()) == DbType.Sqlite) {
                String sql = "Select name from sqlite_master;";
                rs = connection.createStatement().executeQuery(sql);
                while (rs.next()) {
                    tables.add(rs.getString("name"));
                }
            } else {
                // rs = md.getTables(null, config.getUsername().toUpperCase(), null, null);

                rs = md.getTables(config.getSchema(), null, "%", new String[] { "TABLE", "VIEW" });            //针对 postgresql 的左侧数据表显示
            }
            while (rs.next()) {
                tables.add(rs.getString(3));
            }
            return tables;
        } finally {
            connection.close();
        }
    }

    /*public static List<UITableColumnVO> getTableColumns(DatabaseConfig dbConfig, String tableName) throws Exception {
        String url = getConnectionUrlWithSchema(dbConfig);
        _LOG.info("getTableColumns, connection url: {}", url);
		Connection conn = getConnection(dbConfig);
		try {
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getColumns(null, null, tableName, null);
			List<UITableColumnVO> columns = new ArrayList<>();
			while (rs.next()) {
				UITableColumnVO columnVO = new UITableColumnVO();
				String columnName = rs.getString("COLUMN_NAME");
				columnVO.setColumnName(columnName);
				columnVO.setJdbcType(rs.getString("TYPE_NAME"));
				columns.add(columnVO);
			}
			return columns;
		} finally {
			conn.close();
		}
	}*/

    public static String getConnectionUrlWithSchema(DatabaseConfig dbConfig) throws ClassNotFoundException {
        DbType dbType = DbType.valueOf(dbConfig.getDbType());
        String connectionUrl = String
                .format(dbType.getConnectionUrlPattern(), dbConfig.getHost(), dbConfig.getPort(), dbConfig.getSchema(), dbConfig.getEncoding());
        log.info("getConnectionUrlWithSchema, connection url: {}", connectionUrl);
        return connectionUrl;
    }

    public static String getConnectionUrlWithSchema(DatabaseDTO dbConfig) throws ClassNotFoundException {
        DbType dbType = DbType.valueOf(dbConfig.getDatabaseType());
        String connectionUrl = String
                .format(dbType.getConnectionUrlPattern(), dbConfig.getHostName(), dbConfig.getPort(), dbConfig.getDatabase(), dbConfig.getEncoding());
        log.info("getConnectionUrlWithSchema, connection url: {}", connectionUrl);
        return connectionUrl;
    }

    /**
     * 加载数据库驱动
     *
     * @param dbType 数据库类型
     */
    private static void loadDbDriver(DbType dbType) {
        List<String> driverJars = ConfigHelper.getAllJDBCDriverJarPaths();
        ClassLoader classloader = ClassloaderUtility.getCustomClassloader(driverJars);
        try {
            Class clazz = Class.forName(dbType.getDriverClass(), true, classloader);
            Driver driver = (Driver) clazz.newInstance();
            log.info("load driver class: {}", driver);
            drivers.put(dbType, driver);
        } catch (Exception e) {
            log.error("load driver error", e);
            throw new DbDriverLoadingException("找不到" + dbType.getConnectorJarFile() + "驱动");
        }
    }
}
