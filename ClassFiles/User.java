/**
 * super class of cinema staff and moviegoer 
 */
import enums.UserType;
public class User extends Person{
  
  
  //members
  private String username;
  private String password;
  private UserType usertype;
  
  
  
  /** 
   * @param password
   */
  //get set
  public void setPassword(String password){
    this.password = password;
  }
  
  
  /** 
   * @param username
   */
  public void setUsername(String username){
    this.username = username;
  }
    
  
  /** 
   * @param usertype
   */
  public void setUserType(UserType usertype){
    this.usertype = usertype;
  }

  
  /** 
   * @return UserType
   */
  public UserType getUserType(){
    return this.usertype;
  }

  
  /** 
   * @return String
   */
  public String getUsername(){
    return username;
  }

  
  /** 
   * @return String
   */
  public String getPw(){
    return password;
  }
  //methods
  
  public User(String firstName, String lastName){
    super(firstName,lastName);
    this.username = firstName + lastName;
    this.password = "11111"; //default password
    }
}
