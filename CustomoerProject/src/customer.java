
public class customer {
  
  private String FirstName;
  private String LastName;
  private String Title;
  private String StreetAddress;
  private String City;
  private String State;
  private String ZipCode;
  private String Email;
  private String Position;
  private String Company;
  
  public customer()
  { 
	  this.FirstName="";
	  this.LastName="";
	  this.Title="";
	  this.StreetAddress="";
	  this.City="";
	  this.State="";
	  this.ZipCode="";
	  this.Email="";
	  this.Position="";
	  this.Company="";
  }
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getStreetAddress() {
	return StreetAddress;
}
public void setStreetAddress(String streetAddress) {
	StreetAddress = streetAddress;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public String getZipCode() {
	return ZipCode;
}
public void setZipCode(String zipCode) {
	ZipCode = zipCode;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPosition() {
	return Position;
}
public void setPosition(String position) {
	Position = position;
}
public String getCompany() {
	return Company;
}
public void setCompany(String company) {
	Company = company;
}
@Override
public String toString() {
	return "customer [FirstName=" + FirstName + ", LastName=" + LastName + ", Title=" + Title + ", StreetAddress="
			+ StreetAddress + ", City=" + City + ", State=" + State + ", ZipCode=" + ZipCode + ", Email=" + Email
			+ ", Position=" + Position + ", Company=" + Company + "]";
} 
}
