public class Person{
  private String firstName;
  private String lastName;
  
  //constructor
  Person(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  
  /** 
   * @return String
   */
  //methods
  
  public String getFirstName(){
    return this.firstName;
  }
  
  
  /** 
   * @return String
   */
  public String getlastName(){
    return this.lastName;
  }
}