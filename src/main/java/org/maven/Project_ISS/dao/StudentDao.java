package org.maven.Project_ISS.dao;

import java.util.List;

public interface StudentDao {

    void  save(Student student);

    public boolean exist(int id_number);

    public boolean exist_account(String username,String password);

}
