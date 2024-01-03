
package view;
import controller.recipecontrol;
import model.customerdetails;
import model.menumodel;
import java.util.List;
import java.util.Scanner;
public class recipeview {
	private recipecontrol controller = new recipecontrol();
    Scanner sc = new Scanner(System.in);
    public void displayMenu() {
    	int choice = 0;
    	System.out.println("Welcome To Yazh Restaurants\n");    		
    	do {
    		System.out.println("1. Add Receipe \n2. Delete Receipe\n3. View Receipe Menu\n4. order\n5. order History\n6. Exit");
    		if (sc.hasNextInt()) {
    			choice = sc.nextInt();          
    		sc.nextLine();
    		switch(choice){
			case 1:
				addRecipe();
				break;
			case 2:
				deleteRecipe();
				break;
			case 3:
				viewRecipeMenu();
				break;
			case 4:
				placeOrder();
				break;
			case 5:
				viewOrderHistory();
				break;
			case 6:
				System.exit(0);
    		}
    		 } else {
                 System.out.println("Invalid choice.");
                 System.exit(0);
             }
    }while(choice!=0);
    }
    public void addRecipe() {
        System.out.println("Recipe Name: ");
        String name = sc.nextLine();
        System.out.println("Recipe Price: ");
        int price = 0;
        if (sc.hasNextInt()) {
         price = sc.nextInt();
        sc.nextLine();
        }
        else {
    		System.out.println("Invalid price");
    		 System.exit(0);
    	}
        System.out.println("Available Time(morning/afternoon/night): ");
        if (sc.hasNextLine()) {   		
            String time = sc.nextLine();
            if(time.equals("morning")||time.equals("afternoon")||time.equals("night")) {            	
       
		controller.addRecipe(name, price, time);
        System.out.println("Recipe added successfully!");
            }
            else {
        		System.out.println("Invalid Time");
        		 System.exit(0);
        	}
        }       
    }
    public void deleteRecipe() {
    	System.out.println("Enter the recipe name to delete: ");
        String name = sc.nextLine();
        controller.deleteRecipe(name);
    }
    public void viewRecipeMenu() {
    	System.out.println("Enter the time (morning/afternoon/night): ");
    	if (sc.hasNextLine()) {   		
        String time = sc.nextLine();
        if(time.equals("morning")||time.equals("afternoon")||time.equals("night")) {
        	List<menumodel> recipes = controller.getRecipesByTime(time);
            if (recipes.isEmpty()) {
                System.out.println("No recipes available for the specified time.");
            } else {
                System.out.println("Recipe Menu for "+time+":");
                for (menumodel recipe : recipes) {
                    System.out.println("Name: "+recipe.getRecipe()+"\n Price: "+recipe.getPrice()+"\n Time: "+recipe.getTime());
                }
        }
    	}
    	else {
    		System.out.println("Invalid Time");
    		 System.exit(0);
    	}        
        }
    }
    public void placeOrder() {
        System.out.println("Enter customer name: ");
        String name = sc.nextLine();
        System.out.println("Enter customer mobile number: ");
        String mobile = sc.nextLine();
        System.out.println("Enter customer address: ");
        String address = sc.nextLine();
        customerdetails customer = new customerdetails(name, mobile, address, null);
        customer.setName(name);
        customer.setMobileNumber(mobile);
        customer.setAddress(address);
        System.out.println("Enter the name of the recipe to order: ");
        String recipeName = sc.nextLine();
        menumodel selectedRecipe = null;
        for (menumodel recipe : controller.getAllRecipes()) {
            if (recipe.getRecipe().equalsIgnoreCase(recipeName)) {
                selectedRecipe = recipe;
                break; 
            }
        }
        controller.placeOrder(customer, selectedRecipe);
        System.out.println("Order placed successfully!");
    }
    public void viewOrderHistory() {
        List<customerdetails> orderHistory = controller.getOrderHistory();
        if (orderHistory.isEmpty()) {
            System.out.println("No orders placed.");
        } else {
            System.out.println("Order History:");
            for (customerdetails customer : orderHistory) {
                System.out.println("Customer Name: " + customer.getName()+"\n Mobile Number: "+customer.getMobileNumber()+
                        "\n Address: " + customer.getAddress()+"\n Recipe Ordered: " + customer.getOrderrecipe().getRecipe());
            }
        }
    }
}
