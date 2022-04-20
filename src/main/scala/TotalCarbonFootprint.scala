case class TotalCarbonFootprint(household: Household,
                                food: Food
                               ) extends CO2 {

  override def calcFootprint(): Double = {
    return household.calcFootprint + food.calcFootprint() + 1.1
  }
}
