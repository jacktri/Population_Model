package project.service.impl

import java.util.concurrent._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import project.data.PersonData
import project.service.FutureModeller
@Service
class FutureModellerImpl extends FutureModeller{

  @Autowired
  private val personData : PersonData = null
  private var netMigration : Int = 300
  private val fertilityRate : Float = 1.8F
  private var lifeExpectancy : Float = 81.2F
  private var year : Int = 2014

  override def retrieveYear(): Int ={
    year
  }

  override def increaseYear(increase: Int): Unit ={
    for(x <- 1 to increase){
      personData.increasePopulationAgeByOne()
      giveBirth(30)
      removeDead()
      receiveImmigrants()
    }
    year += increase
  }

  private def removeDead(): Unit ={
    if(lifeExpectancy < 87){
      lifeExpectancy += 0.1F
    }
    personData.removeDead(lifeExpectancy.toInt)
  }
  private def giveBirth(birthAge : Integer): Unit ={
    var numberOfAge: Integer = personData.findAll().filter(_.age == birthAge).length
    numberOfAge = ((numberOfAge / 2) * fertilityRate).toInt
    for (x <- 1 to numberOfAge) {
      personData.giveBirth(true)
    }
  }

  private def receiveImmigrants(): Unit ={
    val latch : CountDownLatch = new CountDownLatch(7)
    val pool : ExecutorService = Executors.newWorkStealingPool(4)
    val r = scala.util.Random
    // 65 to 75
    pool.execute(new ProcessImmigration(netMigration/100, r.nextInt(10) + 65, latch))
    // 0 to 15
    pool.execute(new ProcessImmigration((netMigration/27.27272727272727).toInt, r.nextInt(15), latch))
    // 15 to 19
    pool.execute(new ProcessImmigration(netMigration/6, r.nextInt(4) + 15, latch))
    //20 to 24
    pool.execute(new ProcessImmigration((netMigration/2.586206896551724).toInt, r.nextInt(4) + 20, latch))
    // 25 to 29
    pool.execute(new ProcessImmigration((netMigration/5.172413793103448).toInt, r.nextInt(4) + 25, latch))
    // 30 to 34
    pool.execute(new ProcessImmigration(netMigration/10, r.nextInt(4) + 30, latch))
    //35 to 44
    pool.execute(new ProcessImmigration((netMigration/15.78947368421053).toInt, r.nextInt(9) + 35, latch))
    //45 to 65
    processImmigration((netMigration/23.07692307692308).toInt, r.nextInt(20) + 45)
    latch.await()
  }

    private def processImmigration(amount : Int, age : Int): Unit ={
      for(x <- 1 to amount){
        personData.receiveImmigrants(age)
      }
    }

  class ProcessImmigration(amount : Int, age : Int, latch : CountDownLatch) extends Runnable{
    override def run(): Unit = {
      for(x <- 1 to amount){
        personData.receiveImmigrants(age)
      }
      latch.countDown()
    }
  }
}
