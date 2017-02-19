package restaurantmenu;

import java.util.ArrayList;
import java.util.List;

	public class OrderManager implements OnlineOrderOps{

		@Override
			public int getNumberOrders(List orderList){
			return orderList.size();
			}

		@Override
		public Object getOrder(List orderList, int orderIndex) {
			// TODO Auto-generated method stub
			return orderList.get(orderIndex);
		}

		@Override
		public String getAllOrdersToString(List dishList) {
			String string = "";
          	for (Object dish : dishList) {
                string += dish.toString() + "\n";
            }
          	return string;
		}

		@Override
		public String getDish(List dishList, int dishIndex) {
			return  "Dish Name: " +((Dish) dishList.get(dishIndex)).dishName;
		}	

		@Override
		public String getAllDishToString(List dishList) {
		  	String string = "";
          	for (Object dish : dishList) {
                string += ((Dish) dish).getDishName() + " | ";
            }
          	return string;
			// TODO Auto-generated method stub
 		}

	       @Override
	        public List<Object> getDishesByType(List dishList, String dishType) {
	            List<Object> dishByType = new ArrayList<>();
	            for (Object dish : dishList) { 
					if (isOfType(dish, dishType)) {
						dishByType.add(dish); 
	                }
	            }
	            return dishByType;
	        }
	      
	        public boolean isOfType(Object object, String dishType) {
				//Alternative Method
				switch (dishType) {
	              case "st":
	                return object instanceof Starter;
				case "mc":
	                return object instanceof MainCourse;
				case "ds":
	                return object instanceof Dessert;
	             }
	            return false;
	        }


		@Override
		public List getDishesByFeature(List dishList, String feature) {
            List dishesByFeatures = new ArrayList<>();
            for (Object dish : dishList) { 
				if (isOfFeature(dish, feature)) {
					dishesByFeatures.add(((Dish) dish).dishName); 
                }
            }
            return dishesByFeatures;
        }
      
        private boolean isOfFeature(Object object, String dishfeature) {
			//Alternative Method
			switch (dishfeature) {
              case "hmd":
                return ((Dish) object).ishmd();
			case "gfd":
				 return ((Dish) object).ismGfd();
			case "sfd":
				 return ((Dish) object).issfd();
			case "vgd":
			 	return ((Dish) object).isvgd();
             }
			
            return false;
        }		 

		@Override
		public String getStatsByDishType(List dishList, String dishType) {
			// TODO Auto-generated method stub
        	List dishes = getDishesByType(dishList, dishType);
        	double gfd = 0, vgd = 0, hmd = 0, sfd = 0;
        	for (Object dishObject : dishes) {
                Dish dish = (Dish) dishObject;
                if (dish.ismGfd()) gfd++;
                if (dish.isvgd()) vgd++;
                if (dish.ishmd()) hmd++;
                if (dish.issfd()) sfd++;
        	}
            double gfdPercent = gfd / dishList.size() * 100, //Example: 1 / 4 = 0.25, 0.25 * 100 = 25%
                    vgdPercent = vgd / dishList.size() * 100,
                    hmdPercent = hmd / dishList.size() * 100,
                    sfdPercent = sfd / dishList.size() * 100;
            return "Of the dishes ordered which are of type "+dishType+", "+gfdPercent+
                    "% are gluten-free, "+vgdPercent+"% are vegetarian, "+hmdPercent+"% are halal-meat, and "+
                    sfdPercent+"% are seafood-free.";
        }
 }
