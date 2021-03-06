package com.company;

import com.company.database.DBException;
import com.company.database.jdbc.DAOImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class DatabaseUtil extends DAOImpl {
    public void cleanDatabase() throws DBException{
        for (String tableName : getTableNames()) {
            Connection connection = getConnection();
            try {
                connection = getConnection();
                String sql = "delete from " + tableName;
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            } catch (Throwable e) {
                System.out.println("Exception while execute cleanDatabase() for table " + tableName);
                e.printStackTrace();
                throw new DBException(e);
            } finally {
                closeConnection(connection);
            }
        }
    }
    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        tableNames.add("GUESTS");
        return tableNames;
    }
}
