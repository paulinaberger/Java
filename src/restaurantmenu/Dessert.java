package restaurantmenu;
import java.awt.List;

public class Dessert extends Dish<Integer> {

    public Dessert(String customerName, String dishName, String dishType, int calories) {
        super(customerName, dishName, dishType);
        this.calories = calories;
        this.dishType = dishType;
    }

	private int calories;	
 	public String toString(){
		return super.toString() + "Total Calories:" +calories+". ";
	}
}
 