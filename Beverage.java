/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents a Beverage Object
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/

public abstract class Beverage {

	private String name; 
	private Type type;
	private Size size;
	
	//Constants 
	
	public static final double BASE_PRICE = 2.0;
	public static final double SIZE_PRICE = 1.0;
	
	//Parametrized constructor
	
	public Beverage(String name, Type type, Size size) {
		
		this.name = name;
		this.type = type;
		this.size = size; 
	}
	
	// Abstract method to calculate beverage price 
	public abstract double calcPrice();
	
    // toString method
    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
	
	//Overrideen equals method 
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) return true;
    	if (obj == null || getClass() != obj.getClass()) return false;
    	
    	Beverage beverage = (Beverage) obj;
    	
    	if (!name.equals(beverage.name)) return false;
    	if (type != beverage.type) return false;
    	return size == beverage.size;
    }
    
    // Getters and setters 
    public String getName() {
    	return name;
    }

    public void setName(String name) {
    	this.name = name;
    }
	
    public Type getType() {
    	return type;
    }
    
    public void setType(Type type) {
    	this.type = type;
    }
    
    public Size getSize() {
    	return size;
    }
    
    public void setSize(Size size) {
    	this.size = size;
    }
    
}
