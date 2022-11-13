import enums.AgeGroup;

/**
 * @author Ang Teck Yee
 * Contains essential information of the customer of the theatre and allows setting and getting of personal information
 */
public class MovieGoer extends User{
  //members
  private String mobileNumber;
  private String emailAddress;
  private int age;
  private AgeGroup ageGroup;
  
  public MovieGoer(String username, String lastname, String password,int age,String mobileNumber,String emailAddress){
    super(username,lastname);
    this.age = age;
    this.mobileNumber = mobileNumber;
    this.emailAddress = emailAddress;
    setPassword(password);
  }
  
  //get set
  public String getemailAddress(){
    return this.emailAddress;
  }
  public void setemailAddress(String emailAddress){
    this.emailAddress = emailAddress;
  }
  
  public String getmobileNumber(){
    return this.mobileNumber;
  }
  
  public void setmobileNumber(String mobileNumber){
    this.mobileNumber = mobileNumber;
  }
  
  //age and sort into agegroup
  
  public void setAge(int age){
    this.age = age;
  }
  
  public int getAge(){
    return this.age;
  }
  
  public void setageGroup(int age){
    this.age = age;
    if (age<18){
      this.ageGroup = AgeGroup.CHILD;
      }
    else if (age>60){
      this.ageGroup = AgeGroup.SENIOR;
      }
    else {
      this.ageGroup = AgeGroup.ADULT;
      }
  }
  
  public AgeGroup getAgeGroup(){
    return this.ageGroup;
  }
}
