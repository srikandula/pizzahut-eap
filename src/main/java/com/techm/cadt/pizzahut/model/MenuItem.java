/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.cadt.pizzahut.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SK69016
 */
@XmlRootElement
public class MenuItem {
    
	public int   id;
    public String itemName;
    public String size;
    public String[] topings;
    public String isVeg;
    
    public String isThinCrest;
    public int cost;
    
    
    public MenuItem(){
        
    }

    public MenuItem(int id,String itemName, String size, String isThinCrest,
             int cost, String isVeg, String[] topings) {
    	this.id  = id;
        this.itemName = itemName;
        this.size = size;
        this.topings = topings;
        this.isThinCrest = isThinCrest;
        this.isVeg = isVeg;
        this.cost = cost;
    }

    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsVeg() {
		return isVeg;
	}

	public String getIsThinCrest() {
		return isThinCrest;
	}

	public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSize() {
        return size;
    }

    
    public void setSize(String size) {
        this.size = size;
    }

    public String[] getTopings() {
        return topings;
    }

    
    public void setTopings(String[] topings) {
        this.topings = topings;
    }

    public String isIsThinCrest() {
        return isThinCrest;
    }

    
    public void setIsThinCrest(String isThinCrest) {
        this.isThinCrest = isThinCrest;
    }

    public String isIsVeg() {
        return isVeg;
    }

    
    public void setIsVeg(String isVeg) {
        this.isVeg = isVeg;
    }
    
    public int getCost() {
        return cost;
    }

    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
}
