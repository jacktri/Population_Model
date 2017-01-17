package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.DataEntity;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Long>
{
}
