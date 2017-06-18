package entity;

/**
 * Created by askol on 6/13/2017.
 */
public class User {
    private int userID;
    private String name;
    private int age;
    private String address;
    private String password;
    private String login;

    public User(String name, int age, String address, String password, String login) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.password = password;
        this.login = login;
    }

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
