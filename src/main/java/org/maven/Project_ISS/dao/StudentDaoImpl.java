package org.maven.Project_ISS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao{


    @Override
    public void save(Student student) {
        Connection con = DBConnection.getConnection();
        if(con==null){
            return ;
        }
        String query ="INSERT INTO students(username,password) VALUES (?,?);";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setString(1,student.getUsername());
            preparedStatement.setString(2,student.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public boolean exist(int id_number){
        Connection con = DBConnection.getConnection();
        if(con==null){
            return false;
        }
        String query ="SELECT * FROM list_stu_id WHERE id_number= ?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setInt(1,id_number);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean exist_account(String username, String password) {
        Connection con = DBConnection.getConnection();
        if(con==null){
            return false;
        }
        String query ="SELECT * FROM students WHERE username= ? AND password=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
