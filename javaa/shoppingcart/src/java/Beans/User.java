package Beans;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String pwd;
    private int age;
    private String reminder;

    public User() {}
    
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public boolean isName(String newName) {
        return newName == this.name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String newPwd) {
        this.pwd = newPwd;
    }

    public boolean isPwd(String newPwd) {
        return newPwd == this.pwd;
    }

}
