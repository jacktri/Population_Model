package project.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import project.data.PersonData
import project.domain.Person
import project.service.{PopulationModeller, StatisticCalculator}
import scala.collection.JavaConverters._
@Service
class PopulationModellerImpl extends PopulationModeller{

  @Autowired
  private val statisticCalculator : StatisticCalculator = null
  @Autowired
  private val personData: PersonData = null

  override def generatePopulation(): Long = {
    personData.deleteAll()
    val r = scala.util.Random
    val personList = new java.util.ArrayList[Person]
    for(x <- 1 to 64700){
      personList.add(new Person(r.nextInt(81), true))
    }
    personData.save(personList.asScala)
    personData.setList()

    return statisticCalculator.totalPopulation()
  }
}
