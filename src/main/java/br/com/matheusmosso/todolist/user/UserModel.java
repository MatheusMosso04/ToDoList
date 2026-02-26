package br.com.matheusmosso.todolist.user;

public class UserModel {
    
    private String username;
    private String name;
    private String password;

    public void setUsername(String username) { //Set para inserir o valor
        this.username = username;
    }

    public String getUsername() { //Get para buscar o valor
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
