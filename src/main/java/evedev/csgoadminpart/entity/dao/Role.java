package evedev.csgoadminpart.entity.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Alexander Eveler
 */
@Entity
@Table(name = "roles", schema = "lootpro")
@NamedQuery(name = "Role.getAll", query = "SELECT a FROM Role a")
public class Role {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 20, nullable = false)
    private long id;

    @Column(name = "name", length = 255, nullable = false, columnDefinition = "varchar(255) default NULL")
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
