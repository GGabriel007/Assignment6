/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represent a Coffee beverage
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/
// Coffee

public class Coffee extends Beverage {
	
	// Additional instance variables 
	
	private final boolean extraShot;
	private final boolean extraSyrup;
	
	// Constants
	
	private static final double EXTRA_SHOT_COST = 0.5;
	private static final double EXTRA_SYRUP_COST = 0.5;
	
	// Parametrized constructor
	
	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;

	}
	
	// Overried calPrice method 
	@Override
	public double calcPrice() {
	    double price = BASE_PRICE;

	    // Additional charges for extra shot and extra syrup
	    if (extraShot) {
	        price += EXTRA_SHOT_COST;
	    }
	    if (extraSyrup) {
	        price += EXTRA_SYRUP_COST;
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
	
	// Overriedden toString method
	@Override 
	public String toString() {
        return "Coffee{" +
                "name='" + getName() + '\'' +
                ", size=" + getSize() +
                ", extraShot=" + extraShot +
                ", extraSyrup=" + extraSyrup +
                ", price=" + calcPrice() +
                '}';
	}
	
	//Overrideen equals method 
	@Override 
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		if (!super.equals(obj))return false;
		
		Coffee coffee = (Coffee) obj;
		
		if (extraShot != coffee.extraShot) return false;
		return extraSyrup == coffee.extraSyrup;
	}
	
	// Getters and setters 
	public boolean isExtraShot() {
		return extraShot;
	}
	
	public boolean isExtraSyrup() {
		return extraSyrup;
	}
	
	
}