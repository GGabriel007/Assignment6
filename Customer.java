/*
 * Class: CMSC203 
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Represents a Customer 
 * Due: 12/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gabriel Gonzalez
*/
// Customer

public class Customer {
	
	// Instance variables
	
	private String name;
	private int age;
	
	// Parametrized constructor 
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	// Copy constructor
	
	public Customer(Customer other) {
		this.name = other.name;
		this.age = other.age;
		
	}
	
	// Overridden toString method 
	@Override 
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
	
	// Getters and setters 
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}