package project.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.entity.PersonEntity;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long>
{

    List<PersonEntity> findByAge(int age);

    @Query("SELECT p FROM PersonEntity p WHERE p.age >= :min and p.age <= :max")
    List<PersonEntity> findBetweenAges(@Param("min") int min, @Param("max") int max);

    @Query("SELECT count(*) FROM PersonEntity p WHERE p.age >= :min and p.age <= :max")
    Long countBetweenAges(@Param("min") int min, @Param("max") int max);

    @Query("SELECT count(*) FROM PersonEntity p WHERE p.age = :age")
    Integer countNumberOfAge(@Param("age") int age);

    @Query("SELECT p.age FROM PersonEntity p")
    List<Integer> findAllAge();

    @Modifying
    @Transactional
    @Query("DELETE FROM PersonEntity p WHERE p.age >= :deathage")
    void calculateDeaths(@Param("deathage") int deathAge);

    @Modifying
    @Transactional
    @Query("UPDATE PersonEntity p SET p.age = p.age + :years")
    void increaseAges(@Param("years") int years);

    @Modifying
    @Transactional
    @Query("UPDATE PersonEntity p SET p.age = p.age + 1")
    void increaseAgesByOne();

    @Modifying
    @Transactional
    @Query("DELETE FROM PersonEntity p")
    void deleteAll();
}
