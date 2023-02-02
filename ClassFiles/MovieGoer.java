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
  
  
  /** 
   * @return String
   */
  //get set
  public String getemailAddress(){
    return this.emailAddress;
  }
  
  /** 
   * @param emailAddress
   */
  public void setemailAddress(String emailAddress){
    this.emailAddress = emailAddress;
  }
  
  
  /** 
   * @return String
   */
  public String getmobileNumber(){
    return this.mobileNumber;
  }
  
  
  /** 
   * @param mobileNumber
   */
  public void setmobileNumber(String mobileNumber){
    this.mobileNumber = mobileNumber;
  }
  
  
  /** 
   * @param age
   */
  //age and sort into agegroup
  
  public void setAge(int age){
    this.age = age;
  }
  
  
  /** 
   * @return int
   */
  public int getAge(){
    return this.age;
  }
  
  
  /** 
   * @param age
   */
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
  
  
  /** 
   * @return AgeGroup
   */
  public AgeGroup getAgeGroup(){
    return this.ageGroup;
  }
}
