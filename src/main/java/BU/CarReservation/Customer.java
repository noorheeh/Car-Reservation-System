package BU.CarReservation;

public class Customer {
	String UserName, Pass, Name, IDNum, Gender, Birthday, PhoneNum, Address;

	public Customer() {
		super();
	}

	public Customer(String userName, String pass, String name, String iDNum, String gender, String birthday,
			String phoneNum, String address) {
		super();
		UserName = userName;
		Pass = pass;
		Name = name;
		IDNum = iDNum;
		Gender = gender;
		Birthday = birthday;
		PhoneNum = phoneNum;
		Address = address;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIDNum() {
		return IDNum;
	}

	public void setIDNum(String iDNum) {
		IDNum = iDNum;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "{"+"\""+"userName\":" + UserName + ",\"pass\":" + Pass + ",\"name\":" + Name + ",\"idnum\":" + IDNum + ",\"gender\":"
				+ Gender + ",\"birthday\":" + Birthday + ",\"phoneNum\":" + PhoneNum + ",\"address\":" + Address + "}";
	}

}