package models;

public class user {
    private int id;
    private String username ;
    private int department ;
    private String role ;
    private String position ;

    public user(String username, int department, String role, String position){
        this.department = department;
        this.username = username ;
        this.role = role;
        this.position = position ;
    }
}
