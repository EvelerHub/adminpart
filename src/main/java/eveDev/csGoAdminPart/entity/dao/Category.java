package evedev.csgoadminpart.entity.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Category entity from lootpro database.
 *
 * @author Alexander Eveler
 */
@Entity
@Table(name = "category", schema = "lootpro")
@NamedQuery(name = "Category.getAll", query = "SELECT a FROM Category a")
public class Category implements Serializable {

    private static final long serialVersionUID = -6786874875668454292L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "Id", length = 20, nullable = false)
    private long id;

    @Column(name = "name", length = 1024, nullable = false, columnDefinition = "varchar(1024) default ''")
    private String name;

    public Category() {
    }

    public Category(String name) {
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
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
