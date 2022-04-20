import org.junit.Test
import junit.framework.TestCase.assertEquals

class TotalCarbonFootprintTest {
  @Test
  def calcFootprint: Unit = {
    //Setup
    var myHouse = Household(4,HouseSize.Small,HouseSize.Small)
    var myFood = Food(OrganicFood.None,MeatDiary.Vegan,HowMuch.Very_Little,HowMuch.Very_Little,HowMuch.Very_Little)
    var total = TotalCarbonFootprint(myHouse,myFood)
    //Execute
    val result = total.calcFootprint()
    //Verify
    assertEquals(3.2225,result)
  }
}
