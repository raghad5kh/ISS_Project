package org.maven.Project_ISS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDaoImpl implements ProfessorDao{
    @Override
    public void save(Professor professor) {
        Connection con = DBConnection.getConnection();
        if(con==null){
            return ;
        }
        String query ="INSERT INTO professor(username,password) VALUES (?,?);";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setString(1,professor.getUsername());
            preparedStatement.setString(2,professor.getPassword());
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
    public boolean exist(int id_number) {
        Connection con = DBConnection.getConnection();
        if(con==null){
            return false;
        }
        String query ="SELECT * FROM list_pro_id WHERE id_number= ?;";
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
        String query ="SELECT * FROM professor WHERE username= ? AND password=?;";
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
