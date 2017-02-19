package restaurantmenu;

public abstract class Dish<T>  
{	
 
	//  Glutten Free Dish

	protected  Boolean mGfd;
	public boolean ismGfd(){
		return mGfd;
	}
 
	public boolean setmGfd(Boolean mGfd) {
		return this.mGfd = mGfd;
	}

	// Vegetarian Dish
	protected  Boolean vgd;
	public void setVgd(Boolean vgd) {
		this.vgd = vgd;
	}
	
	public boolean isvgd(){
		return vgd;
	}
 	
	// Seafood Dish
	protected  Boolean sfd;
	public boolean issfd(){
		return sfd;
	}
	public void setSfd(Boolean sfd) {
		this.sfd = sfd;
	}
 
	// Halal Meat
	protected  Boolean hmd;
	public boolean ishmd(){
		return hmd;
	}
 
	public void setHmd(Boolean hmd) {
		this.hmd = hmd;
	}
	
	// Dish Name and Dish Type
	String dishName;
	private boolean gluttenFree = false, vegetarian = false, halalMeat = false, seafoodFree = false;
	protected static String dishType;
 	
 	 Dish(String customerName, String dishName, String dishType) {
	     	this.customerName = customerName;
	        this.dishName = dishName;
	        this.dishType = dishType;
	    }
	
	public String getDishName() { 
	return dishName; 
	}
	
	protected String customerName;
	public String getCustomerName(){
		return this.customerName;
	}
	
	public  Class getdishType(String dishType) {
        switch (dishType) {
            case "Starter":
                return Starter.class;
            case "Main Course":
                return MainCourse.class;
            case "Dessert":
                return Dessert.class;
            default:
                throw new Error("Unknown dish type: "+dishType);
        }
    }
	
	@Override
	public String toString() {
     	String string = "Customer: "+ customerName+". ";
       	string += "Dish Name: "+dishName+". ";
       	string += "Type of Dish:" +dishType+". ";
       	string += "Gluten-free: "+mGfd+".";
       	string += "Vegetarian: "+vgd+".";
       	string += "Halal-meat: "+hmd+".";
       	string += "Seafood: "+sfd+".";
        return string;
    }

}
 
 