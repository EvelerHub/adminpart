package evedev.csgoadminpart.entity.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Weapon entity from lootpro database.
 *
 * @author Alexander Eveler
 */

@Entity
@Table(name = "weapon", schema = "lootpro")
@NamedQuery(name = "Weapon.getAll", query = "SELECT a FROM Weapon a")
public class Weapon implements Serializable{

    private static final long serialVersionUID = -2128310516550436979L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "Id", length = 20, nullable = false)
    private long id;

    @Column(name = "name", length = 1024, nullable = false, columnDefinition = "varchar(1024) default ''")
    private String name;

    public Weapon() {
    }

    public Weapon(String name) {
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
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
