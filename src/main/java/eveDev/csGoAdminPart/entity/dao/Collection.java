package evedev.csgoadminpart.entity.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Collection entity from lootpro database
 *
 * @author Alexander Eveler
 */
@Entity
@Table(name = "collection", schema = "lootpro")
@NamedQueries({
        @NamedQuery(name = "Collection.getAll", query = "SELECT a FROM Collection a"),
        @NamedQuery(name = "Collection.getByCategoryId", query = "SELECT a FROM Collection a WHERE a.category.id = ?")
})
public class Collection implements Serializable {

    private static final long serialVersionUID = 6308269658635326947L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 20, nullable = false)
    private long id;

    @Column(name = "name", length = 1024, nullable = false, columnDefinition = "varchar(255) default ''")
    private String name;

    @Column(name = "price", length = 10, nullable = false, columnDefinition = "decimal(10,2) default 0.00")
    private double price;

    @Column(name = "image_path", length = 1024, nullable = false, columnDefinition = "varchar(1024) default ''")
    private String imagePath;

    @OneToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "item_collection",
            joinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> items;

    public Collection() {
    }

    public Collection(String name, double price, String imagePath, Category category) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                ", category=" + category +
                ", items=" + items.toString() +
                '}';
    }
}