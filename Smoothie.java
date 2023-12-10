/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents Smoothie Beverage
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/
// Smoothie

public class Smoothie extends Beverage {
	
	// Additional instance variables
	
	private final int numberOfFruits;
	private final boolean proteinPowder;
	
	// Constants 
	private static final double PROTEIN_COST = 1.5;
	private static final double FRUIT_COST = 0.5;
	
	// Parametrized constructor
	
	public Smoothie(String name, Size size, int numberOfFruits, boolean proteinPowder) {
		
		super(name, Type.SMOOTHIE, size);
		this.numberOfFruits = numberOfFruits;
		this.proteinPowder = proteinPowder;
		
	} 
	
	// Overrideen calcPrice method
	@Override
	public double calcPrice() {
	    double price = BASE_PRICE;

	    // Additional charges for protein powder and fruits
	    if (proteinPowder) {
	        price += PROTEIN_COST;
	    }
	    price += numberOfFruits * FRUIT_COST;

	    // Additional charge based on size
	    switch (getSize()) {
	        case MEDIUM:
	            price += SIZE_PRICE;
	            break;
	        case LARGE:
	            price += SIZE_PRICE * 2;
	            break;
	        // Small size has no additional charge
	    }

	    return price;
	}
	
	// Overrideen toString method
	@Override
    public String toString() {
        return "Smoothie{" +
                "name='" + getName() + '\'' +
                ", size=" + getSize() +
                ", numberOfFruits=" + numberOfFruits +
                ", proteinPowder=" + proteinPowder +
                ", price=" + calcPrice() +
                '}';
    }
	
	// Overrideen equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		if (!super.equals(obj)) return false;
		
		Smoothie smoothie = (Smoothie) obj;
		
		if (numberOfFruits != smoothie.numberOfFruits) return false;
		return proteinPowder == smoothie.proteinPowder;
	}
	
	// Getters and setters 
	public int getNumbersOfFruits() {
		return numberOfFruits;
	}
	
	public boolean isProteinPowder() {
		return proteinPowder;
	}
}