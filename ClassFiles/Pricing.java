import enums.AgeGroup;
import enums.Days;
import enums.CinemaType;
  
  
public class Pricing{

//maybe method should change to getprice of all ticket member, not 1 by 1 

/**
 * @author Ang Teck Yee
 * @param day
 * @param age
 * @return finalprice
 * method to get price of 1 ticket, based on day of the week, the cinema class as well as age group. Children and seniors get discounts
 */
  public static double getPrice(Days day,AgeGroup age,CinemaType cinema){
    
    double finalPrice = 9;
   //if day = fri sat sun holi, plus extra
   if (day == Days.FRIDAY || day == Days.SATURDAY || day == Days.SUNDAY){
    finalPrice = finalPrice + 3;
   }    
    
   //if senior / child, discount
   if (age == AgeGroup.SENIOR || age == AgeGroup.CHILD){
    finalPrice = finalPrice - 4;
   }
  
   if(cinema == CinemaType.PLATINUM){
    finalPrice=finalPrice + 5;
   }
    return finalPrice;
  }
}
