package evedev.csgoadminpart.entity.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Rarity entity from lootpro database.
 *
 * @author Alexander Eveler
 */

@Entity
@Table(name = "rarity", schema = "lootpro")
@NamedQuery(name = "Rarity.getAll", query = "SELECT a FROM Rarity a")
public class Rarity implements Serializable {

    private static final long serialVersionUID = -1053102400052028093L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "Id", length = 20, nullable = false)
    private long id;

    @Column(name = "name", length = 1024, nullable = false, columnDefinition = "varchar(1024) default ''")
    private String name;

    @Column(name = "series", length = 1024, nullable = false, columnDefinition = "varchar(1024) default ''")
    private String series;

    public Rarity() {
    }

    public Rarity(String name, String series) {
        this.name = name;
        this.series = series;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Rarity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}
