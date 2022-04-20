
object OrganicFood extends Enumeration {
  var organicFood = Value;

  var None,Some,Most,All = Value
}

object MeatDiary extends Enumeration {
  var meatDiary = Value

  var Above_Average,Average,Below_Average,Vegetarian,Vegan = Value
}

object HowMuch extends Enumeration {
  var howMuch = Value

  var Above_Average,Average,Below_Average,Very_Little = Value
}

object organicMap {
  var organicFoodMap = Map[OrganicFood.Value,Double](
    OrganicFood.None -> 0.7,
    OrganicFood.Some -> 0.5,
    OrganicFood.Most -> 0.2,
    OrganicFood.All -> 0
  )
}

object meatMap {
  var meatMap = Map[MeatDiary.Value,Double](
    MeatDiary.Vegan -> 0,
    MeatDiary.Vegetarian -> 0.1,
    MeatDiary.Below_Average -> 0.25,
    MeatDiary.Average -> 0.4,
    MeatDiary.Above_Average -> 0.6
  )
}

object FoodMilesMap {
  var foodMilesMap = Map[HowMuch.Value,Double](
    HowMuch.Very_Little -> 0.5,
    HowMuch.Below_Average -> 0.3,
    HowMuch.Average -> 0.2,
    HowMuch.Above_Average -> 0.1
  )
}

object FoodPackagingMap {
  var foodPackagingMap = Map[HowMuch.Value,Double](
    HowMuch.Very_Little -> 0.05,
    HowMuch.Below_Average -> 0.2,
    HowMuch.Average -> 0.4,
    HowMuch.Above_Average -> 0.6
  )
}

object WasteMap {
  var wasteMap = Map[HowMuch.Value,Double](
    HowMuch.Very_Little -> 0.03,
    HowMuch.Below_Average -> 0.19,
    HowMuch.Average -> 0.4,
    HowMuch.Above_Average -> 0.62
  )
}

case class Food(organicFood: OrganicFood.Value,
                meatDiary: MeatDiary.Value,
                foodMiles: HowMuch.Value,
                foodPackaging: HowMuch.Value,
                composting: HowMuch.Value) extends CO2 {

  override def calcFootprint(): Double = {
    var organic = organicMap.organicFoodMap(organicFood)
    var meat = meatMap.meatMap(meatDiary)
    var miles = FoodMilesMap.foodMilesMap(foodMiles)
    var packaging = FoodPackagingMap.foodPackagingMap(foodPackaging)
    var waste = WasteMap.wasteMap(composting)

    return organic + meat + miles + packaging + waste

  }
}
