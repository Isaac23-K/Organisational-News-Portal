package models;

import java.util.List;

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

    public static List<News> getAll() {
        return getAll();
    }

    public int getIdDepartment(int idDepartment){
        return idDepartment;
    }
    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(int usernameId) {
        this.usernameId = usernameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void save(News newNews) {
    }
}
