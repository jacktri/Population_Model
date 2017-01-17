package project

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import project.service.{FutureModeller, PopulationModeller, StatisticCalculator}

object Application extends App{
    SpringApplication.run(classOf[Config])

  @SpringBootApplication
  class Config{

    private val log: Logger = LoggerFactory.getLogger(classOf[Config])

    @Autowired
    private val statisticCalculator: StatisticCalculator = null
    @Autowired
    private val futureModeller: FutureModeller = null
    @Autowired
    private val populationModeller : PopulationModeller = null

      @Bean
      def init: CommandLineRunner = new CommandLineRunner {
          override def run(args: String*): Unit = {
            log.info("START:")
            populationModeller.generatePopulation()
            log.info("## AVERAGE AGE IS " + statisticCalculator.averageAge())
            log.info("POPULATION IS " + statisticCalculator.totalPopulation())
            log.info("PERCENTAGE OF WORKING AGE IS " + statisticCalculator.workingAgePopulationPercentage())
            log.info("TOTAL IN WORK IS " + statisticCalculator.totalWorkingAgePopulation())
            log.info("PERCENTAGE IN EDUCATION IS " + statisticCalculator.educationPopulationPercentage())
            log.info("TOTAL EDUCATION IS " + statisticCalculator.totalEducationAgePopulation())
            log.info("PERCENTAGE IN RETIRED IS " + statisticCalculator.retiredPopulationPercentage())
            log.info("TOTAL RETIRED IS " + statisticCalculator.totalRetiredPopulation())
            log.info("UNEMPLOYMENT RAT IS " + statisticCalculator.unemploymentRate())
            log.info("TOTAL WORKING POP IS " + statisticCalculator.totalWorkingPopulation())
            log.info("YEAR IS " + futureModeller.retrieveYear())
            futureModeller.increaseYear(63)
            log.info("REMAINING POPULATION IS " + statisticCalculator.totalPopulation())
            log.info("HERE")
            log.info("YEAR IS " + futureModeller.retrieveYear())
            log.info("AVERAGE AGE IS " + statisticCalculator.averageAge())
            log.info("POPULATION IS " + statisticCalculator.totalPopulation())
            log.info("PERCENTAGE OF WORKING AGE IS " + statisticCalculator.workingAgePopulationPercentage())
            log.info("TOTAL IN WORK IS " + statisticCalculator.totalWorkingAgePopulation())
            log.info("PERCENTAGE IN EDUCATION IS " + statisticCalculator.educationPopulationPercentage())
            log.info("TOTAL EDUCATION IS " + statisticCalculator.totalEducationAgePopulation())
            log.info("PERCENTAGE IN RETIRED IS " + statisticCalculator.retiredPopulationPercentage())
            log.info("TOTAL RETIRED IS " + statisticCalculator.totalRetiredPopulation())
            log.info("UNEMPLOYMENT RAT IS " + statisticCalculator.unemploymentRate())
            log.info("TOTAL WORKING POP IS " + statisticCalculator.totalWorkingPopulation())
            log.info("YEAR IS " + futureModeller.retrieveYear())
            log.info("FOREIGN BORN POP IS " + statisticCalculator.foreignBornPopulation())
            log.info("BRITISH POP IS " + statisticCalculator.britishBornPopulation())
          }
        }
      }
}
