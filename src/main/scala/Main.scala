
object main {
  def main(args: Array[String]): Unit = {

    System.out.println("\n---Calculate Carbon Footprint---")
    System.out.print("\nHow many people live in your household? - ")
    val numPers = scala.io.StdIn.readInt();

    System.out.println("\nHow much electricity is used in your household?")
    System.out.println("[1] Small house/ Flat (3000kWh)")
    System.out.println("[2] Medium (4800kWh)")
    System.out.println("[3] Large house (7000kWh)")
    System.out.println("[4] Residence (2000kWh)")

    System.out.print("Press number to answer - ")
    val elecNum = scala.io.StdIn.readInt();
    var elec = HouseSize.Small

    elecNum match {
      case 1 => elec = HouseSize.Small
      case 2 => elec = HouseSize.Medium
      case 3 => elec = HouseSize.Large
      case 4 => elec = HouseSize.Residence
    }

    System.out.println("\nHow much gas is used in your household?")
    System.out.println("[1] Small house/ Flat (12000 kWh)")
    System.out.println("[2] Medium (18000 kWh)")
    System.out.println("[3] Large house (27000 kWh)")
    System.out.println("[4] Residence (5000 kWh)")

    System.out.print("Press number to answer - ")
    val gasNum = scala.io.StdIn.readInt();
    var gas = HouseSize.Small

    gasNum match {
      case 1 => gas = HouseSize.Small
      case 2 => gas = HouseSize.Medium
      case 3 => gas = HouseSize.Large
      case 4 => gas = HouseSize.Residence
    }

    val myHouse = new Household(numPers, elec, gas)

    System.out.println("\nHow much of the food that you eat is organic?")
    System.out.println("[1] None")
    System.out.println("[2] Some")
    System.out.println("[3] Most")
    System.out.println("[4] All")

    System.out.print("Press number to answer - ")
    val organicNum = scala.io.StdIn.readInt();
    var organic = OrganicFood.None

    organicNum match {
      case 1 => organic = OrganicFood.None
      case 2 => organic = OrganicFood.Some
      case 3 => organic = OrganicFood.Most
      case 4 => organic = OrganicFood.All
    }

    System.out.println("\nHow much meat/dairy do you eat personally?")
    System.out.println("[1] Vegan")
    System.out.println("[2] Vegetarian")
    System.out.println("[3] Below-Average")
    System.out.println("[4] Average")
    System.out.println("[5] Above-Average")

    System.out.print("Press number to answer - ")
    val meatNum = scala.io.StdIn.readInt();
    var meat = MeatDiary.Vegan

    meatNum match {
      case 1 => meat = MeatDiary.Vegan
      case 2 => meat = MeatDiary.Vegetarian
      case 3 => meat = MeatDiary.Below_Average
      case 4 => meat = MeatDiary.Average
      case 5 => meat = MeatDiary.Above_Average
    }

    System.out.println("\nHow much of your food is produced locally?")
    System.out.println("[1] Very little")
    System.out.println("[2] Below-Average")
    System.out.println("[3] Average")
    System.out.println("[4] Above-Average")

    System.out.print("Press number to answer - ")
    val milesNum = scala.io.StdIn.readInt();
    var miles = HowMuch.Very_Little

    milesNum match {
      case 1 => miles = HowMuch.Very_Little
      case 2 => miles = HowMuch.Below_Average
      case 3 => miles = HowMuch.Average
      case 4 => miles = HowMuch.Above_Average
    }

    System.out.println("\nHow much of your food is packaged / processed?")
    System.out.println("[1] Very little")
    System.out.println("[2] Below-Average")
    System.out.println("[3] Average")
    System.out.println("[4] Above-Average")

    System.out.print("Press number to answer - ")
    val packageNum = scala.io.StdIn.readInt();
    var pack = HowMuch.Very_Little

    packageNum match {
      case 1 => pack = HowMuch.Very_Little
      case 2 => pack = HowMuch.Below_Average
      case 3 => pack = HowMuch.Average
      case 4 => pack = HowMuch.Above_Average
    }

    System.out.println("\nHow much food do you waste on average?")
    System.out.println("[1] Very little")
    System.out.println("[2] Below-Average")
    System.out.println("[3] Average")
    System.out.println("[4] Above-Average")

    System.out.print("Press number to answer - ")
    val wasteNum = scala.io.StdIn.readInt();
    var waste = HowMuch.Very_Little

    packageNum match {
      case 1 => waste = HowMuch.Very_Little
      case 2 => waste = HowMuch.Below_Average
      case 3 => waste = HowMuch.Average
      case 4 => waste = HowMuch.Above_Average
    }

    val myFood = new Food(organic,meat,miles,pack,waste)

    System.out.println("\n---Results---")
    System.out.println("Household Carbon Footprint: " + myHouse.calcFootprint + " tonnes CO2")
    System.out.println("Food Carbon Footprint: " + myFood.calcFootprint + " tonnes CO2")
    val totalCO2 = TotalCarbonFootprint(myHouse,myFood).calcFootprint()
    System.out.println("Total Carbon Footprint: " + totalCO2 + " tonnes CO2")
  }
}