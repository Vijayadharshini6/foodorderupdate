package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.customerdetails;
import model.menumodel;

public class recipecontrol {
	  List<menumodel> recipes = new ArrayList<>();
	  List<customerdetails> orderHistory = new ArrayList<>();		  
	    public void addRecipe(String receipe, int price, String time) {
	    	menumodel recipe = new menumodel(receipe, price, time);
	        recipe.setRecipe(receipe);
	        recipe.setPrice(price);
	        recipe.setTime(time);
	        recipes.add(recipe);
	    }
	    public void deleteRecipe(String name) {
	    	 Iterator<menumodel> iterator = recipes.iterator();
	         while (iterator.hasNext()) {
	        	 menumodel recipe = iterator.next();
	             if (recipe.getRecipe().equals(name)) {
	                 iterator.remove();
	                 System.out.println("Recipe deleted successfully!");
	                 return;
	             }
	         }
	         System.out.println("Recipe not found!");
	    }
	    public List<menumodel> getAllRecipes() {
	        return recipes;
	    }
	    public List<menumodel> getRecipesByTime(String time) {
	        List<menumodel> filteredRecipes = new ArrayList<>();
	        for (menumodel recipe : recipes) {
	            if (recipe.getTime().equalsIgnoreCase(time)) {
	                filteredRecipes.add(recipe);
	            }
	        }
	        return filteredRecipes;
	    }
	    public void placeOrder(customerdetails customer, menumodel selectedRecipe) {
	        if (customer != null && selectedRecipe != null) {
	            customer.setOrderrecipe(selectedRecipe);
	            orderHistory.add(customer);
	        } else {
	            System.out.println("Invalid customer or recipe selection!");
	        }
	    }
	    public List<customerdetails> getOrderHistory() {
	        return orderHistory;
	    }
}
