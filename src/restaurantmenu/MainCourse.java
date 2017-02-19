package restaurantmenu;
import java.awt.List;
public class MainCourse extends Dish<String> {
		
    public MainCourse(String customerName, String dishName, String dishType, String mainIngredient, String preferredDrink) {
        super(customerName, dishName, dishType);
        this.mainIngredient = mainIngredient;
        this.preferredDrink = preferredDrink;
    }	
		//Dish main ingredient
		private String mainIngredient;
		private String preferredDrink;
	    public String toString() {
	     	String string = super.toString();
	        string += "Main Ingredient: "+mainIngredient+". ";
	        string += "Preferred Drink: "+preferredDrink+". ";
	      	return string;
	    }
}
