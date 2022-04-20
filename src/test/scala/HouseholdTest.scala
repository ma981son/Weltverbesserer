import junit.framework.TestCase.assertEquals
import org.junit.Test

class HouseholdTest {

  @Test
  def calcFootprint ={
    //Setup
    var myHouse = Household(4,HouseSize.Small,HouseSize.Small)
    //Execute
    var result = myHouse.calcFootprint
    //Verify
    assertEquals(0.8425,result)
  }
}
