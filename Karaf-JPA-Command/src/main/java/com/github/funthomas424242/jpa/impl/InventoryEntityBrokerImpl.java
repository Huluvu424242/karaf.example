package com.github.funthomas424242.jpa.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.github.funthomas424242.jpa.InventoryCategory;
import com.github.funthomas424242.jpa.InventoryEntityBroker;
import com.github.funthomas424242.jpa.InventoryItem;



public class InventoryEntityBrokerImpl implements InventoryEntityBroker {
    EntityManager em;

    void close() {
        em.close();
    }
    
	/**
	 * @param em
	 *            the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

    // Item methods
    /* (non-Javadoc)
	 */
    public List<InventoryItem> getAllItems() {
        Query q = em.createQuery("SELECT item FROM InventoryItem item ORDER BY item.itemName");

        return (List<InventoryItem>) q.getResultList();
    }

    /* (non-Javadoc)
	 */
    public InventoryItem getSingleItem(int id) {
        Query q = em.createQuery("SELECT item FROM InventoryItem item WHERE item.id=" + id);
        return (InventoryItem) q.getSingleResult();
    }
    
    /* (non-Javadoc)
	 */
    public void addItem(String name, String description, float price, int categoryID) 
    {

        InventoryItem item = new InventoryItem();
        item.setItemName(name);
        item.setItemDescription(description);
        item.setItemPrice(price);
        item.setCategory(getSingleCategory(categoryID));
        
        em.persist(item);
    }

    /* (non-Javadoc)
	 */
    public void updateItem(int id, String name, String description, float price, int categoryID) {

    	InventoryItem item = em.find(InventoryItem.class, id);
        item.setItemName(name);
        item.setItemDescription(description);
        item.setItemPrice(price);
        item.setCategory(getSingleCategory(categoryID));

        em.merge(item);
    }

    /* (non-Javadoc)
	 */
    public void deleteItem(int id) {
    	InventoryItem item = em.find(InventoryItem.class, id);

        em.remove(item);
    }
    
//Category Methods    
    /* (non-Javadoc)
	 */
    public List<InventoryCategory> getAllCategories() {
        Query q = em.createQuery("SELECT cat FROM InventoryCategory cat ORDER BY cat.categoryName");

        return (List<InventoryCategory>) q.getResultList();
    }

    /* (non-Javadoc)
	 */
    public InventoryCategory getSingleCategory(int id) {
        Query q = em.createQuery("SELECT cat FROM InventoryCategory cat WHERE cat.id=" + id);
        return (InventoryCategory) q.getSingleResult();
    }
    
    /* (non-Javadoc)
	 */
    public void addCategory(String name, String description) 
    {
        InventoryCategory cat = new InventoryCategory();
        cat.setCategoryName(name);
        cat.setCategoryDescription(description);
        
        em.persist(cat);
    }

    /* (non-Javadoc)
	 */
    public void updateCategory(int id, String name, String description) {

    	InventoryCategory cat = em.find(InventoryCategory.class, id);
        cat.setCategoryName(name);
        cat.setCategoryDescription(description);

        em.merge(cat);
    }

    /* (non-Javadoc)
	 */
    public void deleteCategory(int id) {
    	InventoryCategory cat = em.find(InventoryCategory.class, id);

        em.remove(cat);
    }

	public void deleteCategoryByName(String name) {
		em.remove(getCategoryByName(name));
	}

	public InventoryCategory getCategoryByName(String name) {
		TypedQuery<InventoryCategory> query = em.createQuery("SELECT cat FROM InventoryCategory cat where cat.categoryName = :name", InventoryCategory.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}

	public List<InventoryItem> getAllItemsByCategory(String categoryName) {
		TypedQuery<InventoryItem> query = em.createQuery("SELECT item FROM InventoryItem item where item.category.categoryName = :name ORDER BY item.itemName", InventoryItem.class);
		query.setParameter("name", categoryName);
        return query.getResultList();
	}

	public void deleteItemByName(String name) {
		InventoryItem inventoryItem = getInventoryItemByName(name); 
		deleteItem(inventoryItem.getId());
	}

	public InventoryItem getInventoryItemByName(String name) {
		TypedQuery<InventoryItem> query = em.createQuery("SELECT item FROM InventoryItem item where item.itemName = :name", InventoryItem.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
}
