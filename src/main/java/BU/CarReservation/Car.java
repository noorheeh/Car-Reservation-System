package BU.CarReservation;

public class Car {
	String Brand, Model, Engin, Color, Year;
	int Seating, Price;
	public Car() {
		super();
	}
	public Car(String brand, String model, String engin, String color, String year, int seating, int price) {
		super();
		Brand = brand;
		Model = model;
		Engin = engin;
		Color = color;
		Year = year;
		Seating = seating;
		Price = price;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getEngin() {
		return Engin;
	}
	public void setEngin(String engin) {
		Engin = engin;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public int getSeating() {
		return Seating;
	}
	public void setSeating(int seating) {
		Seating = seating;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
}