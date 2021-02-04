package pl.home.dzw.ormzadanie.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class SaveAspect {


    @Around("@annotation(pl.home.dzw.ormzadanie.aop.TimeLog))")
    public void aroundSave(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Signature signature = joinPoint.getSignature();
        String nameOfMethod = signature.getName();
        joinPoint.proceed();
        Instant end = Instant.now();
        Instant minus = end.minusMillis(start.toEpochMilli());
        System.out.println(nameOfMethod + " Time: " + minus.toEpochMilli() + " milliseconds");
    }
}
