package project.domain

import scala.beans.BeanProperty

class Person(@BeanProperty var age : Int,
             @BeanProperty var bornInUk : Boolean) {

  def this(){
    this(0, true)
  }

  override def toString = s"Person($age)"
}
