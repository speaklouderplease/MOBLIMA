import enums.AgeGroup;
import enums.Days;
import enums.CinemaType;
  
  
public class Pricing{
//method to get price of 1 ticket
//maybe method should change to getprice of all ticket member, not 1 by 1 
//Justin's note: I think its fine. Easier to just call one by one. Also need to add CinemaType
/**
 * 
 * @param day
 * @param age
 * @return finalprice
 */
  public static double getPrice(Days day,AgeGroup age,CinemaType cinema){
    
    double finalPrice = 0;
   //if day = fri sat sun holi, plus extra
   if (day == Days.FRIDAY || day == Days.SATURDAY || day == Days.SUNDAY){
    finalPrice = finalPrice + 3;
   }    
    
   //if senior / child, discount
   if (age == AgeGroup.SENIOR || age == AgeGroup.CHILD){
    finalPrice = finalPrice - 4;
   }
    
    return finalPrice;
  }
}
