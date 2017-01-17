package project.data.impl


import java.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import project.data.PersonData
import project.domain.Person
import project.entity.PersonEntity
import project.repository.PersonRepository
import java.util.List
import org.slf4j.{Logger, LoggerFactory}
import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

@Service
class PersonDataImpl extends PersonData {

  private val log: Logger = LoggerFactory.getLogger(classOf[PersonDataImpl])
  var population : Int = 0

  @Autowired
  private val personRepository: PersonRepository = null

  var personList: ListBuffer[Person] = null

  override def findAll(): scala.List[Person] = {
    personList.toList
  }
  override def getPopulation(): Int = {
    return population
  }

  override def setList(): Unit = {
    if (personList == null) {
      personList = personListEntityConvertor(personRepository.findAll()).asScala.to[ListBuffer]
    }
    population = personList.length
  }

  override def save(person: Person) = {
    personList += (person)
  }

  override def save(personList: scala.collection.mutable.Buffer[Person]) = {
    personRepository.save(personListConvertor(personList.asJava))
  }

  override def countBetweenAges(min: Int, max: Int): Long = {
    personList.filter(_.age >= min).filter(_.age <= max).length
  }

  override def findAllAges: scala.collection.mutable.Buffer[Integer] = {
    personRepository.findAllAge().asScala
  }

  override def removeDead(deathAge: Int) = {
    personList = personList.filter(_.age < deathAge)
  }

  override def increasePopulationAge(years: Int): Unit = {
    personRepository.increaseAges(years)
  }

  override def increasePopulationAgeByOne(): Unit = {
    personList.foreach({ p => p.setAge(p.age + 1) })
  }

  override def giveBirth(britishParent : Boolean): Unit = {
    addPerson(0, britishParent)
  }

  override def receiveImmigrants(age : Integer): Unit = {
    addPerson(age, false)
  }

  override def deleteAll(): Unit = {
    personList = null
    personRepository.deleteAll()
  }

  private def personListEntityConvertor(personEntityList: List[PersonEntity]): List[Person] = {
    val personlist: List[Person] = new util.ArrayList[Person]()
    personEntityList.asScala.foreach((p: PersonEntity) => personlist.add(personEntityConvertor(p)))
    personlist
  }

  private def addPerson(age: Int, bornInTheUK : Boolean): Unit = {
    this.synchronized {
      personList += (new Person(age, bornInTheUK))
    }
  }

  private def personEntityConvertor(personEntity: PersonEntity): Person = {
    return new Person(personEntity.getAge, personEntity.getBornInTheUk)
  }

  private def personConvertor(person: Person): PersonEntity = {
    return new PersonEntity(person.age, person.bornInUk)
  }

  private def personListConvertor(personList: List[Person]): List[PersonEntity] = {
    val personEntityList: List[PersonEntity] = new util.ArrayList[PersonEntity]()
    personList.asScala.foreach((p: Person) => personEntityList.add(personConvertor(p)))
    personEntityList
  }
}
