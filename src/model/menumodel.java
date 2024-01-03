package model; 
public class menumodel {

private String recipe;
private int price;
private String time;
public menumodel(String recipe, int price, String time) {
	//super();
	this.recipe = recipe;
	this.price = price;
	this.time = time;
}
public String getRecipe() {
	return recipe;
}
public void setRecipe(String recipe) {
	this.recipe = recipe;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
}
