package ADMIN;

public class Admin {

    private String UserName;
    private String Password;
    public Admin(){
        UserName="Shreshti";
        Password="12345";
    }
    public String getUserName(){
        return UserName;
    }
    public void setUserName(String UserName){
        this.UserName=UserName;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }


}
