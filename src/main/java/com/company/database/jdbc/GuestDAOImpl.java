package com.company.database.jdbc;

import com.company.database.DBException;
import com.company.database.GuestDAO;
import com.company.database.jdbc.DAOImpl;
import com.company.domian.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.Throwable;

import static com.company.domian.GuestBuilder.createGuest;

public class GuestDAOImpl extends DAOImpl implements GuestDAO {
    @Override
    public Guest save(Guest guest) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into GUESTS(id, name, description) values(default, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                guest.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute GuestDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return guest;
    }
    @Override
    public Optional<Guest> getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from GUESTS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Guest guest = null;
            if (resultSet.next()) {
                guest = createGuest()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withDescription(resultSet.getString("description")).build();
            }
            return Optional.ofNullable(guest);
        } catch (Throwable e) {
            System.out.println("Exception while execute GuestDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    @Override
    public Optional<Guest> getByName(String name) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from GUESTS where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            Guest guest = null;
            if (resultSet.next()) {
                guest = createGuest()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withDescription(resultSet.getString("description")).build();
            }
            return Optional.ofNullable(guest);
        } catch (Throwable e) {
            System.out.println("Exception while execute GuestDAOImpl.getByName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    @Override
    public List<Guest> getAll() throws DBException {
        List<Guest> guests = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from GUESTS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Guest guest = createGuest()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withDescription(resultSet.getString("description")).build();
                guests.add(guest);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting guest list GuestDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return guests;
    }
    @Override
    public void delete(Guest guest) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from GUESTS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, guest.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute GuestsDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
