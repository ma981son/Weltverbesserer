

object HouseSize extends Enumeration {
  type houseSize = Value;

  val Small,Medium,Large,Residence = Value
}

object ElectricityMap {
  var electricityMap = Map[HouseSize.Value,Double](
    HouseSize.Small -> 0.93,
    HouseSize.Medium -> 1.48,
    HouseSize.Large -> 2.16,
    HouseSize.Residence -> 0.62
  )
}

object GasMap {
  var gasMap = Map[HouseSize.Value,Double](
    HouseSize.Small -> 2.44,
    HouseSize.Medium -> 3.65,
    HouseSize.Large -> 5.48,
    HouseSize.Residence -> 1.01
  )
}

case class Household(var numPers:Int,
                     var elecSize: HouseSize.Value,
                     var gasSize: HouseSize.Value
                    ) extends CO2 {

  def calcFootprint : Double = {
    var electricity = ElectricityMap.electricityMap(elecSize)
    var gas = GasMap.gasMap(gasSize)
    return (electricity + gas) / numPers
  }
}
