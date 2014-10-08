package com.github.funthomas424242.jpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class InventoryItem {
    private int version;
    private int id;
    
    private String itemName;
    private String itemDescription;
    private float itemPrice;

    protected InventoryCategory category;
    
    public InventoryItem(){}
    
    @Column(name = "itemName")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    @Column(name = "itemDescription")
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String description) {
        this.itemDescription = description;
    }

    @Column(name = "itemPrice")
    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float price) {
        this.itemPrice = price;
    }

    
    @Version
    @Column(name = "version_field")
    // not required
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	@ManyToOne
	@JoinColumn(name="CAT_ID", nullable=false)
	public InventoryCategory getCategory()
	{
	    return category;
	}
    
    public void setCategory(InventoryCategory category)
    {
        this.category = category;
    }
}

