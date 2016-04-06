package evedev.csgoadminpart.entity.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Item entity from lootpro database.
 *
 * @author Alexander Eveler
 */
@Entity
@Table(name = "item", schema = "lootpro")
@NamedQuery(name = "Item.getAll", query = "SELECT a FROM Item a")
public class Item implements Serializable {

    private static final long serialVersionUID = 4106730255087834114L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 20, nullable = false)
    private long id;

    @Column(name = "image_path", length = 1024, nullable = false, columnDefinition = "varchar(1024) default ''")
    private String image;

    @Column(name = "name", length = 1024, nullable = false, columnDefinition = "varchar(1024) default ''")
    private String name;

    @Column(name = "number", length = 11, nullable = false, columnDefinition = "int(11) default 0")
    private long number;

    @Column(name = "price", length = 10, nullable = false, columnDefinition = "decimal(10,2) default 0.00")
    private double price;

    @OneToOne(optional = false)
    @JoinColumn(name = "weapon_id", nullable = false)
    private Weapon weapon;

    @OneToOne(optional = false)
    @JoinColumn(name = "rarity_id", nullable = false/*, updatable = false*/)
    private Rarity rarity;

    public Item() {
    }

    public Item(String image, String name, long number, double price, Weapon weapon, Rarity rarity) {
        this.image = image;
        this.name = name;
        this.number = number;
        this.price = price;
        this.weapon = weapon;
        this.rarity = rarity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", weapon=" + weapon +
                ", rarity=" + rarity +
                '}';
    }
}
