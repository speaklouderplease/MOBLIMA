
import enums.UserType;
public class User extends Person{
  
  
  //members
  private String username;
  private String password;
  private UserType usertype;
  
  
  //get set
  public void setPassword(String password){
    this.password = password;
  }
  
  public void setUsername(String username){
    this.username = username;
  }
    
  public void setUserType(UserType usertype){
    this.UserType = usertype;
  }

    public UserType getUserType(){
    return this.UserType;
  }
  //methods
  
  public User(String firstName, String lastName){
    super(firstName,lastName);
    this.username = firstName + lastName;
    this.password = "11111"; //default password
    }
  
