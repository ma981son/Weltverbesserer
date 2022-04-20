import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class FoodTest {

 @Test
  def calcFootprint: Unit = {
   //Setup
   val myFood = Food(OrganicFood.None,MeatDiary.Vegan,HowMuch.Very_Little,HowMuch.Very_Little,HowMuch.Very_Little);
   //Execution
   val result = myFood.calcFootprint()
   //Verify
   assertEquals(1.28,result)
 }
}
