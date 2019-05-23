package BU.CarReservation;

public class Reserve {
	String StartDate, EndDate;
	Customer customer;
	Car car;

	public Reserve() {
		super();
	}

	public Reserve(String startDate, String endDate, Customer customer, Car car) {
		super();
		StartDate = startDate;
		EndDate = endDate;
		this.customer = customer;
		this.car = car;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}