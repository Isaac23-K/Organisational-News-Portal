package models;
import org.sql2o.*;

import java.util.List;

public class User {
    private int id;
    private String username ;
    private int department ;
    private String role ;
    private String position ;

    public User(String username, int department, String role, String position){
        this.department = department;
        this.username = username ;
        this.role = role;
        this.position = position ;
    }
}
