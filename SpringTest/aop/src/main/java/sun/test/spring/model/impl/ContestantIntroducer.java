package sun.test.spring.model.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
import sun.test.spring.model.Contestant;

/**
 * Created by sun on 16/03/16.
 */

@Component
@Aspect
public class ContestantIntroducer
{
    @DeclareParents(value = "sun.test.spring.model.Performer+",
                    defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
