package project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import project.service.FutureModeller;
import project.service.PopulationModeller;
import project.service.StatisticCalculator;

@SpringBootApplication
public class Application implements CommandLineRunner{

    private Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private StatisticCalculator statisticCalculator;

    @Autowired
    private FutureModeller futureModeller;

    @Autowired
    private PopulationModeller populationModeller;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("START:");
        populationModeller.generatePopulation();
        log.info("## AVERAGE AGE IS " + statisticCalculator.averageAge());
        log.info("POPULATION IS " + statisticCalculator.totalPopulation());
        log.info("PERCENTAGE OF WORKING AGE IS " + statisticCalculator.workingAgePopulationPercentage());
        log.info("TOTAL IN WORK IS " + statisticCalculator.totalWorkingAgePopulation());
        log.info("PERCENTAGE IN EDUCATION IS " + statisticCalculator.educationPopulationPercentage());
        log.info("TOTAL EDUCATION IS " + statisticCalculator.totalEducationAgePopulation());
        log.info("PERCENTAGE IN RETIRED IS " + statisticCalculator.retiredPopulationPercentage());
        log.info("TOTAL RETIRED IS " + statisticCalculator.totalRetiredPopulation());
        log.info("UNEMPLOYMENT RAT IS " + statisticCalculator.unemploymentRate());
        log.info("TOTAL WORKING POP IS " + statisticCalculator.totalWorkingPopulation());
        log.info("YEAR IS " + futureModeller.retrieveYear());
        futureModeller.increaseYear(63);
        log.info("REMAINING POPULATION IS " + statisticCalculator.totalPopulation());
        log.info("HERE");
        log.info("YEAR IS " + futureModeller.retrieveYear());
        log.info("AVERAGE AGE IS " + statisticCalculator.averageAge());
        log.info("POPULATION IS " + statisticCalculator.totalPopulation());
        log.info("PERCENTAGE OF WORKING AGE IS " + statisticCalculator.workingAgePopulationPercentage());
        log.info("TOTAL IN WORK IS " + statisticCalculator.totalWorkingAgePopulation());
        log.info("PERCENTAGE IN EDUCATION IS " + statisticCalculator.educationPopulationPercentage());
        log.info("TOTAL EDUCATION IS " + statisticCalculator.totalEducationAgePopulation());
        log.info("PERCENTAGE IN RETIRED IS " + statisticCalculator.retiredPopulationPercentage());
        log.info("TOTAL RETIRED IS " + statisticCalculator.totalRetiredPopulation());
        log.info("UNEMPLOYMENT RAT IS " + statisticCalculator.unemploymentRate());
        log.info("TOTAL WORKING POP IS " + statisticCalculator.totalWorkingPopulation());
        log.info("YEAR IS " + futureModeller.retrieveYear());
        log.info("FOREIGN BORN POP IS " + statisticCalculator.foreignBornPopulation());
        log.info("BRITISH POP IS " + statisticCalculator.britishBornPopulation());
    }
}
