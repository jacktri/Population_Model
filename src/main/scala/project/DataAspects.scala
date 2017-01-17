package project

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.{Aspect, Before}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import project.data.impl.PersonDataImpl

@Component
@Aspect
class DataAspects {
  @Autowired private val personDataInMemory: PersonDataImpl = null

  @Before("execution(* project.data.impl.PersonDataImpl.*(..))") def log(point: JoinPoint) {
    if (point.toShortString != "execution(PersonDataImpl.setList())"
      && point.toShortString != "execution(PersonDataImpl.save(..))"
      && point.toShortString != "execution(PersonDataImpl.deleteAll())") {
      personDataInMemory.setList()
    }
  }

}
