package ua.skillsup.shop.jp1.dao;

/**
 * Created by Aleksey on 14.04.2018.
 */
public class User {

    private Long id;
    private String FirstName;
    private String LastName;
    private int age;

    public User(Long id, String firstName, String lastName, int age) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                '}';
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
