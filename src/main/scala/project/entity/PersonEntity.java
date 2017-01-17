package project.entity;

import scala.Char;

import javax.persistence.*;

@Entity
@Table(name = "personentity", indexes = {
        @Index(columnList = "id", name = "person_id_hidx"),
        @Index(columnList = "age", name = "age_id")})
public class PersonEntity
{
    public PersonEntity()
    {
    }

    public PersonEntity(Integer age, Boolean bornInTheUk)
    {
        this.age = age;
        this.bornInTheUk = bornInTheUk;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer age;

    @Column(name = "bornintheuk")
    private Boolean bornInTheUk;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Boolean getBornInTheUk()
    {
        return bornInTheUk;
    }

    public void setBornInTheUk(Boolean bornInTheUk)
    {
        this.bornInTheUk = bornInTheUk;
    }

    @Override
    public String toString()
    {
        return "PersonEntity{" +
                "id=" + id +
                ", age=" + age +
                ", bornInTheUk=" + bornInTheUk +
                '}';
    }
}

