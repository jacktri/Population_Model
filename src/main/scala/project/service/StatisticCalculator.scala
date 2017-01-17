package project.service

trait StatisticCalculator {

  def averageAge() : Float
  def totalPopulation() : Long
  def totalWorkingAgePopulation() : Long
  def totalEducationAgePopulation() : Long
  def totalRetiredPopulation() : Long
  def workingAgePopulationPercentage() : Float
  def educationPopulationPercentage() : Float
  def retiredPopulationPercentage() : Float
  def totalWorkingPopulation() : Long
  def unemploymentRate() : Double
  def britishBornPopulation() : Long
  def foreignBornPopulation() : Long
}
