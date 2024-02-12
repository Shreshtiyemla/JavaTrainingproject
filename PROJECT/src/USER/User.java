package USER;

public class User {
    private String userName;
    private String password;
    int userId;
    long phNumber;
    public User(String userName, String password, long phNumber){
        this.userName=userName;
        this.password=password;
        this.phNumber=phNumber;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String UserName){

        this.userName = UserName;
    }
    public String getPassword(){

        return password;
    }
    public void setPassword(String Password){

        this.password = Password;
    }


}
