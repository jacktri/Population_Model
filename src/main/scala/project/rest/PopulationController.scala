package project.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import project.service.{FutureModeller, PopulationModeller, StatisticCalculator}

@RestController
class PopulationController {

  @Autowired
  private val futureModeller : FutureModeller = null
  @Autowired
  private val statisticCalculator : StatisticCalculator = null
  @Autowired
  private val populationModeller : PopulationModeller = null

  @RequestMapping(Array("/population"))
  def showPopulation(): String = {
    val population = statisticCalculator.totalPopulation()
    s"population is $population"
  }

  @RequestMapping(Array("year"))
  def showYear(): String ={
    val year = futureModeller.retrieveYear()
    s"year is $year"
  }

  @RequestMapping(Array("/status"))
  def statusCheck: java.util.Map[String, String] ={
    val statusMap: java.util.Map[String,String] = new java.util.LinkedHashMap[String,String]
    statusMap.put("year", futureModeller.retrieveYear().toString)
    statusMap.put("population", statisticCalculator.totalPopulation().toString)
    statusMap
  }

  @RequestMapping(value = Array("/passTime"), method = Array(RequestMethod.POST))
  def passTime(years : Integer): String ={
    futureModeller.increaseYear(years)
    s"Successfully passed $years"
  }

  @RequestMapping(Array("/generatePopulation"))
  def generatePopulation: String = {
    val population : Long = populationModeller.generatePopulation()
    s"Population is $population"
  }
}
