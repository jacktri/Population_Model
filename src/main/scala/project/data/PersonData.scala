package project.data

import project.domain.Person

trait PersonData {

  def findAll() : List[Person]
  def save(person : Person)
  def save(personList : scala.collection.mutable.Buffer[Person])
  def countBetweenAges(min : Int, max : Int) : Long
  def findAllAges : scala.collection.mutable.Buffer[Integer]
  def removeDead(deathAge : Int)
  def increasePopulationAge(years : Int)
  def increasePopulationAgeByOne()
  def giveBirth(britishParent : Boolean)
  def receiveImmigrants(age : Integer)
  def setList()
  def deleteAll()
  def getPopulation() : Int
}
