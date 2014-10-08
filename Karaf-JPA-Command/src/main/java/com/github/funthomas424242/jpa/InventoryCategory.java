package com.github.funthomas424242.jpa;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class InventoryCategory {
    private int version;
    private int id;
    
    private String categoryName;
    private String categoryDescription;

    List<InventoryItem> items;
   
    public InventoryCategory(){}
    
    @Column(name = "categoryName")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String name) {
        this.categoryName = name;
    }

    @Column(name = "itemDescription")
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String description) {
        this.categoryDescription = description;
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
    
    @OneToMany(targetEntity=InventoryItem.class, 
    		cascade=CascadeType.ALL, 
    		mappedBy="category")
    public List<InventoryItem> getItems() 
    { 
        return items; 
    }
    public void setItems(List<InventoryItem> items)
    {
        this.items = items;
    }
    public void addItem(InventoryItem item)
    {
    	this.items.add(item);
    }
}
