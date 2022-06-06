package spring_crud.model;


import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Byte age;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "sex")
    private Character sex;

    @Column(name = "is_president")
    private Boolean isPresident;

    public User() {
    }

    public User(String name, String lastname, byte age, String hobby, char sex, boolean isPresident) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.hobby = hobby;
        this.sex = sex;
        this.isPresident = isPresident;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isPresident() {
        return isPresident;
    }

    public void setPresident(boolean president) {
        isPresident = president;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                ", sex=" + sex +
                ", isPresident=" + isPresident +
                '}';
    }
}
