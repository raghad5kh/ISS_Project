package org.maven.Project_ISS.socket.ClientComponents;

import org.maven.Project_ISS.AES.AsymmetricEncryption;
import org.maven.Project_ISS.dao.*;

import java.io.PrintWriter;
import java.util.Scanner;

public class UserInfo {

    private static void getClientDetails(PrintWriter out , String clientIPAddress,int clientPortNumber ) {
        out.println(clientIPAddress);
        out.println(clientPortNumber);
    }

    public  void StudentInfo(PrintWriter out, Scanner scanner, String clientIPAddress, int clientPortNumber, int id_number, String name, String password) throws Exception {

        StudentDao studentDao = new StudentDaoImpl();


        String key = studentDao.get_national_number(id_number);
        String address;
        String phone_number;
        String mobile_number;

        System.out.println("Complete your information...............");
        System.out.println("Enter your address");
        address = scanner.next();
        System.out.println("Your address: " + address);
        out.println(address);
        String address_after = AsymmetricEncryption.decrypt(address,key);
        System.out.println("Enter your phone_number");
        phone_number = scanner.next();
        out.println(phone_number);
        System.out.println("Your phone_number: " + phone_number);

        int phone_number_after = Integer.parseInt(AsymmetricEncryption.decrypt(phone_number,key));
        System.out.println("Enter your mobile_number");
        mobile_number = scanner.next();
        out.println(mobile_number);
        System.out.println("Your mobile_number: " + mobile_number);

        int mobile_number_after = Integer.parseInt(AsymmetricEncryption.decrypt(mobile_number,key));
        if(studentDao.exist(id_number)) {
            Student student = new Student(0,name,password,address_after,phone_number_after,mobile_number_after);
            studentDao.save(student);}
        getClientDetails(out,clientIPAddress,clientPortNumber);

        out.flush();
    }



    public  void ProfessorInfo(PrintWriter out, Scanner scanner, String clientIPAddress, int clientPortNumber, int id_number, String name, String password) throws Exception {

        ProfessorDao professorDao = new ProfessorDaoImpl();


        String key = professorDao.get_national_number(id_number);
        String address;
        String phone_number;
        String mobile_number;

        System.out.println(key);
        System.out.println("Complete your information...............");
        System.out.println("Enter your address");
        address = scanner.next();
        System.out.println("Your address: " + address);
        out.println(address);
        String address_after = AsymmetricEncryption.decrypt(address,key);
        System.out.println("Enter your phone_number");
        phone_number = scanner.next();
        out.println(phone_number);
        System.out.println("Your phone_number: " + phone_number);

        int phone_number_after = Integer.parseInt(AsymmetricEncryption.decrypt(phone_number,key));
        System.out.println("Enter your mobile_number");
        mobile_number = scanner.next();
        out.println(mobile_number);
        System.out.println("Your mobile_number: " + mobile_number);

        int mobile_number_after = Integer.parseInt(AsymmetricEncryption.decrypt(mobile_number,key));
        if(professorDao.exist(id_number)) {
            Professor professor = new Professor(0,name,password,address_after,phone_number_after,mobile_number_after);
            professorDao.save(professor);}
        getClientDetails(out,clientIPAddress,clientPortNumber);

        out.flush();
    }
}
