package project.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import project.data.PersonData
import project.domain.Person
import project.service.StatisticCalculator

@Service
class StatisticCalculatorImpl extends StatisticCalculator {

  @Autowired
  private val personData: PersonData = null

  private val populationModifier : Int = 1000
  private val retirementAge : Int = 68
  private val workAge : Int = 22
  private val bornAge : Int = 0
  private val unemploymentRateVar : Double = 4.8

  override def averageAge(): Float = {
    var totalAge : Float = 0
    val personList : List[Person] = personData.findAll()
    personList.foreach((p : Person) => totalAge+=p.age)
    totalAge / personList.length
  }

  override def totalPopulation(): Long = {
    personData.getPopulation() * populationModifier
  }

  override def britishBornPopulation(): Long = {
    personData.findAll().filter(_.bornInUk == true).length * populationModifier
  }

  override def foreignBornPopulation(): Long = {
    personData.findAll().filter(_.bornInUk == false).length * populationModifier
  }

  override def totalWorkingAgePopulation(): Long = {
    personData.countBetweenAges(workAge,retirementAge-1) * populationModifier
  }

  override def totalEducationAgePopulation(): Long = {
    personData.countBetweenAges(bornAge,workAge-1) * populationModifier
  }

  override def totalRetiredPopulation(): Long = {
    personData.countBetweenAges(retirementAge,500) * populationModifier
  }

  override def workingAgePopulationPercentage(): Float = {
    calculateAverage(workAge,retirementAge-1)
  }

  override def educationPopulationPercentage(): Float = {
    calculateAverage(bornAge,workAge-1)
  }

  override def retiredPopulationPercentage(): Float = {
    calculateAverage(retirementAge,500)
  }

  override def totalWorkingPopulation(): Long = {
    (totalWorkingAgePopulation() * ((100-unemploymentRate) / 100)).toLong
  }

  override def unemploymentRate(): Double = {
    unemploymentRateVar
  }


  private def calculateAverage(min : Int, max : Int): Float = {
    val personList : List[Person] = personData.findAll()
    val subPopulation = personList.filter(_.age >= min).filter(_.age <= max)
    subPopulation.length.toFloat / personList.length * 100
  }
}
