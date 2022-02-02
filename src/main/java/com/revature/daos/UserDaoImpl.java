package com.revature.daos;

import com.revature.models.User;
import com.revature.models.UserType;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl  implements UserDao{

    @Override
    public boolean createUser(User user) {
        String sql = "insert into users(user_UserType,first_name,last_name,email,password)values(?, ?, ?, ?, ?)";
        try(Connection c = ConnectionUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql); ){
            ps.setInt(1, user.getType().ordinal());
            // set first as param index 2  -- set the name using the User object (p)
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());


            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1){
                return true;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        String sql = "select * from users where userid = ?";
        try (Connection c = ConnectionUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                User user = new User();
                user.setUserId(id);
                // get the 0/1 ordinal value that is stored in the database
                int UserTypeOrdinal = rs.getInt("user_UserType");
                // obtain the values in the ENUM, in an array format where their ordinal corresponds
                // with their position in the array
                UserType[] UserTypes = UserType.values(); //["TEACHER", "STUDENT"]
                // access the appropriate UserType using the array and ordinal value
                user.setType(UserTypes[UserTypeOrdinal]);

                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        String sql = "select * from User where email = ? and password = ?";

        try(Connection connection = ConnectionUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "email");
            preparedStatement.setString(2, "password");

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                User User = new User();
                UserType[] UserTypes = UserType.values();
                User.setUserId(resultSet.getInt("userId"));
                int UserTypeOrdinal = resultSet.getInt("UserType");
                User.setType(UserTypes[UserTypeOrdinal]);

                User.setFirstname(resultSet.getString("first_name"));
                User.setLastname(resultSet.getString("last_name"));
                User.setEmail(resultSet.getString("email"));
                User.setPassword(resultSet.getString("password"));

                return User;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(User user) {
        String sql = "update person set type = ?, first_name = ?, last_name = ?, email = ?, password = ? where id = ?";

        try(Connection connection = ConnectionUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, user.getType().ordinal());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());


            if(preparedStatement.executeUpdate() == 1) { return true; }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    }

