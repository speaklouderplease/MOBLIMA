import enums.AgeGroup
import enums.Day
  
  
  
public class Pricing{
//method to get price of 1 ticket
//maybe method should change to getprice of all ticket member, not 1 by 1
  public double getPrice(Day day,AgeGroup age){
    double normalPrice = 8;
    double finalPrice = 0;
   //if day = fri sat sun holi, plus extra
   if (day == Day.FRIDAY || day == day.
    
    
   //if senior / child, discount
   if (age == AgeGroup.SENIOR || age == AgeGroup.CHILD){
    finalPrice = 

  
  return finalPrice;
  }
