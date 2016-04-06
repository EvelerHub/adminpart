package evedev.csgoadminpart.entity.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Alexander Eveler
 */
@Entity
@Table(name = "admins", schema = "lootpro")
@NamedQueries({
        @NamedQuery(name = "Admin.getAll", query = "SELECT a FROM Admin a"),
        @NamedQuery(name = "Admin.getByNameAndPassword", query = "SELECT a FROM Admin a WHERE a.login = ? AND a.password = ?")
})
public class Admin {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 20, nullable = false)
    private long id;

    @Column(name = "name", length = 255, nullable = false, columnDefinition = "varchar(255) default NULL")
    private String name;

    @Column(name = "surname", length = 255, nullable = false, columnDefinition = "varchar(255) default NULL")
    private String surname;

    @Column(name = "login", length = 255, nullable = false, columnDefinition = "varchar(255) default NULL")
    private String login;

    @Column(name = "password", length = 255, nullable = false, columnDefinition = "varchar(255) default NULL")
    private String password;

    @OneToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Admin() {
    }

    public Admin(String name, String surname, String login, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
