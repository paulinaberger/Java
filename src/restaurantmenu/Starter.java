package restaurantmenu;

public class Starter extends Dish<String> {

	public Starter(String customerName, String dishName, String dishType, String cutlery) {
        super(customerName, dishName, dishType);
        this.cutlery = cutlery;
    }	
	
	//sets the specific type of cultery needed
	private String cutlery;
	public String toString(){
		return super.toString() + "Cutlery:" +cutlery+". ";
		
	}

}