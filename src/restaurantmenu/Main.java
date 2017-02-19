package restaurantmenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {
	
	public static void main (String[] args) throws IOException {
		List<Dish> dishList = getDishes("/Users/paulinaberger/Documents/workspace/restaurantmenu/online_order_sample.csv");
		for (Dish dish : dishList) {
         	System.out.println(dish + "\n");
             }
        OnlineOrderOps orderManager = new OrderManager();
        OrderManager object = new OrderManager();
 	        System.out.println("Total Orders " + orderManager.getNumberOrders(dishList));
 			System.out.println(" ----------PERFORMING SOME REQUESTS ----------");

 			System.out.println("\n Number of Orders:\n"+object.getNumberOrders(dishList)+"\n");
 			System.out.println("Getting the Order:\n" + object.getOrder(dishList, 3)+"\n");
 			System.out.println("All Orders (toString):\n" + object.getAllOrdersToString(dishList)+"\n");
 			System.out.println("Getting Dish:\n" + object.getDish(dishList, 1)+ "\n");
 			System.out.println("All Dishes (toString):\n" + object.getAllDishToString(dishList)+ "\n");
 			System.out.println("Dishes by Type:\n" + object.getDishesByType(dishList, "mc")+"\n");
 			System.out.println("Dishes by Features (Halal):\n" + object.getDishesByFeature(dishList, "hmd")+"\n");
 			System.out.println("Dishes by Features (Vegetarian):\n" + object.getDishesByFeature(dishList, "vgd")+"\n");
 			System.out.println("Dishes by Features (Glutten-Free):\n" + object.getDishesByFeature(dishList, "gfd")+"\n");
 			System.out.println("Dishes by Features (Seafood):\n" + object.getDishesByFeature(dishList, "sfd")+"\n");
 			System.out.println("Total Stats by Dish Type:\n" + object.getStatsByDishType(dishList, "st")+"\n");
 	 	} 
 		
	
  
    private static List<Dish> getDishes(String filePath) throws IOException {
      	List<Dish> dishList = new ArrayList<>();
        Path path = Paths.get(filePath);
        List<String> fileLines = Files.readAllLines(path);
        for (String order : fileLines) {
            String[] details = order.split(",");
            if (details.length != 8) {
              throw new Error("Dish length should have been 8, but was: "+details.length);
            }
            String customerName = details[0];
            String dishName = details[1];
            String extras = details[7];
            String dishType = details[2];
            String glutenFree = details[3];
            String vegeterian = details[4];
            String halalMeat = details[5];
            String seafoodFree = details[6];
            Dish dish = makeDishFromDetails(customerName, dishName, extras, dishType);
            dish.setmGfd(glutenFree.equals("true"));
            dish.setVgd(vegeterian.equals("true"));
            dish.setHmd(halalMeat.equals("true"));
            dish.setSfd(seafoodFree.equals("true"));
            dishList.add(dish);
        }
        return dishList;
    }

  	private static Dish makeDishFromDetails(String customerName, String dishName,
                                            String extras, String dishType) {      
      		switch (dishType) {
              case "st":
                return new Starter(customerName, dishName, dishType, extras);
              case "mc":
                String mcExtras[] = extras.split("-");
                if (mcExtras.length != 2) {
                  throw new Error("Main Course Extras length should have been 2, but was"+mcExtras.length);
                }
                String mainIngredient = mcExtras[0];
                String preferredDrink = mcExtras[1];
                return new MainCourse(customerName, dishName,dishType,  mainIngredient, preferredDrink);
              case "ds":
                int calories;
                try {
                  	calories = Integer.valueOf(extras);
                } catch (NumberFormatException e) {
                  	throw new Error("Error reading calories: " + extras, e);
                }
                return new Dessert(customerName, dishName,dishType, calories);
              default:
                	throw new Error("Unknown course type: " + dishType);
          }     	      		
       	}
  	
 
	private static List<String> readFile(String string) throws IOException {
        return Files.readAllLines(Paths.get(string));
    }
}






 