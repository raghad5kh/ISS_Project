package org.maven.Project_ISS.dao;

public interface ProfessorDao {
    void  save(Professor professor);

    public boolean exist(int id_number);

    public boolean exist_account(String username,String password);

    String get_national_number(int id_number);
}
