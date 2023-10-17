package spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
public class TravelAspect {

    @Pointcut("execution(public * spring.impl..*(..))")
    void allInImpl(){}

    @Before("allInImpl()")
    void logEnteringMethod(JoinPoint jp){
        System.out.println("[ENTERING]" + jp.toLongString() + " on " + jp.getTarget().getClass().getSimpleName());
    }

    @After("allInImpl()")
    void logExitingMethod(JoinPoint jp){
        System.out.println("[EXITING]" + jp.toLongString() + " on " + jp.getTarget().getClass().getSimpleName());
    }

    @Around("@annotation(spring.config.ExecutionTime) || allInImpl()")
    Object logExecutionTime(ProceedingJoinPoint jp) throws Throwable{

        Instant start = Instant.now();
        Object result = jp.proceed(jp.getArgs());
        Instant end = Instant.now();
        System.out.println("[EXECUTION] took " + Duration.between(start, end).toNanos() + "ns");

        return result;
    }

}
