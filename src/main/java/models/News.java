package models;

public class News {
    private int id ;
    private String content ;
    private int usernameId;
    private int idDepartment ;

    public News(String content, int idDepartment, int usernameId){
        this.content= content ;
        this.idDepartment= idDepartment;
        this.usernameId= usernameId;
    }
}
