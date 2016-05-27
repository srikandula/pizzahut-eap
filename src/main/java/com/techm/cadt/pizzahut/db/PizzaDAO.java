/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.cadt.pizzahut.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;

import com.techm.cadt.pizzahut.model.CustomerOrder;
import com.techm.cadt.pizzahut.model.Menu;
import com.techm.cadt.pizzahut.model.MenuItem;
/**
 *
 * @author SK69016
 *
CREATE TABLE menu_item(
   menu_id       INT NOT NULL,
   item_name     VARCHAR(255) NOT NULL,
   size          ENUM ('PAN','SMALL','MEDIUM','LARGE'),
   crest_type    ENUM ('THIN_CREST','NORMAL','DOUBLE_CHEESE','OTHERS'),
   cost          INT,
   veg_type      ENUM ('VEG','NON-VEG'),
   topings       VARCHAR(255),
   CONSTRAINT pk_menu_item PRIMARY KEY (menu_id)
);
 */
public class PizzaDAO {

	static DataSource ds = null;
    static CustomerOrder order = new CustomerOrder();

    static String ALL_ITEMS = "select menu_id, item_name, size, crest_type, cost, veg_type, topings from menu_item";

    public Menu loadMenu(){
    	Menu menu = new Menu();
    	try(Connection connection = getConnection()){
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(ALL_ITEMS);
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		while(rs.next()){
    			list.add(new MenuItem(
    					rs.getInt("menu_id"),
    					rs.getString("item_name"),
    					rs.getString("size"),
    					rs.getString("crest_type"),
    					rs.getInt("cost"),
    					rs.getString("veg_type"),
    					StringUtils.split(rs.getString("topings"),",")
    					));
    		}
    		rs.close();
    		stmt.close();
    		menu.setItems(list.toArray(new MenuItem[0]));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}

        return menu;
    }

    /**
     *
     * @param size
     * @param isVeg
     * @param cost
     * @return
     */
    public Menu filterMenu(String size, String isVeg, int cost){

        Menu menu = new Menu();
    	try(Connection connection = getConnection()){

    		Statement stmt = connection.createStatement();
    		StringBuffer buffer = new StringBuffer();

    		buffer.append(ALL_ITEMS);

    		if(size != null || isVeg != null || cost > 0){
	    		buffer.append(" where ");
	    		boolean isAnd = false;
	    		if(size != null ){
	            	buffer.append(" size = '").append(size).append("'");
	            	isAnd = true;
	            }
	    		if(isVeg !=null ){
	    			if(isAnd){
	    				buffer.append(" and ");
	    			}
	            	buffer.append(" veg_type = '").append(isVeg).append("'");
	            	isAnd = true;
	            }
	    		if(cost > 0){
	    			if(isAnd){
	    				buffer.append(" and ");
	    			}
	            	buffer.append(" cost = ").append(cost);
	            }
    		}
    		//System.out.println(buffer.toString());

    		ResultSet rs = stmt.executeQuery(buffer.toString());
    		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
    		while(rs.next()){
    			list.add(new MenuItem(
    					rs.getInt("menu_id"),
    					rs.getString("item_name"),
    					rs.getString("size"),
    					rs.getString("crest_type"),
    					rs.getInt("cost"),
    					rs.getString("veg_type"),
    					StringUtils.split(rs.getString("topings"),",")
    					));
    		}
    		rs.close();
    		stmt.close();
    		menu.setItems(list.toArray(new MenuItem[0]));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}

        return menu;
    }

    public CustomerOrder saveOrder(MenuItem item){
        if(order.getOrderItems() == null || order.getOrderItems().length ==0 ){
            order.setOrderItems(new MenuItem[]{item});
        }
        return order;
    }

    private Connection getConnection() throws Exception{
    	if(ds == null){
	    	Context initCtx = new InitialContext();
	    	//Context envCtx = (Context) initCtx.lookup("java:comp/env");
	    	ds = (DataSource)initCtx.lookup("java:jboss/datasources/pizzahutDS");
    	}
    	return ds.getConnection();
    }

}
