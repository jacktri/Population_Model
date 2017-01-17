package project.entity

import javax.persistence._

import scala.beans.BeanProperty

@Table(name = "dataentity")
@Entity
class DataEntity(@Column(name = "deathage") @BeanProperty var deathAge: Int,
                 @Column(name = "startworkage") @BeanProperty var startWorkAge: Int,
                 @Column(name = "retirementage") @BeanProperty var retirementAge: Int,
                 @Column(name = "unemploymentrate") @BeanProperty var unemploymentRate: Float,
                 @Column(name = "netmigration") @BeanProperty var netMigration: Long,
                 @Column(name = "havechildrenage") @BeanProperty var haveChildrenAge: Int,
                 @Column (name = "numberofchildren")@BeanProperty var numberOfChildren: Int) {

  def this () {
  this (0, 0, 0, 0, 0, 0, 0)
}

  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @SequenceGenerator(name="data_id_seq", sequenceName="data_id_seq", allocationSize=1)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _


  override def toString = s"DataEntity($id, $deathAge, $startWorkAge, $retirementAge, $unemploymentRate, $netMigration, $haveChildrenAge, $numberOfChildren)"
}
