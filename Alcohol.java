/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents Alcohol Beverage
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/

// Alcohol 


public class Alcohol extends Beverage {
	
	// Additional instance variable
	private final boolean offeredInWeekend;
	
	// Constants 
	private static final double WEEKEND_COST = 0.6;
	
	// Parametrized constructor 
	public Alcohol(String name, Size size, boolean offeredInWeekend) {
		super(name, Type.ALCOHOL, size);
		this.offeredInWeekend = offeredInWeekend;
		
	}
	
	// Overridden calcPrice method 
	@Override
	public double calcPrice() {
	    double price = BASE_PRICE;

	    // Additional charge for drinks offered in the weekend
	    if (offeredInWeekend) {
	        price += WEEKEND_COST;
	    }

	    // Additional charge based on size
	    switch (getSize()) {
	        case MEDIUM:
	            price += SIZE_PRICE;
	            break;
	        case LARGE:
	            price += SIZE_PRICE * 2;
	            break;
	    }
	    return price;
	}
	
	// Overridden toString method 
    @Override
    public String toString() {
        return "Alcohol{" +
                "name='" + getName() + '\'' +
                ", size=" + getSize() +
                ", offeredInWeekend=" + offeredInWeekend +
                ", price=" + calcPrice() +
                '}';
    }
    
    // Overridden equals method 
    @Override 
    public boolean equals(Object obj) {
    	if (this == obj) return true;
    	if (obj == null || getClass() != obj.getClass()) return false;
    	if (!super.equals(obj)) return false;
    	
    	Alcohol alcohol = (Alcohol) obj;
    	
    	return offeredInWeekend == alcohol.offeredInWeekend;

    }
    
    // Getters and setters 
    public boolean isOfferedInWeekend() {
    	return offeredInWeekend;
    }
	
}