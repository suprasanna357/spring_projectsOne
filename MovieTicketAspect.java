package moviebooking;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MovieTicketAspect {

    @Pointcut("execution(* com.example.moviebooking.MovieTicketService.*(..))")
    public void ticketMethods() {
    }

    @Before("ticketMethods()")
    public void beforeMethod() {

        System.out.println("Before: Movie ticket service method is executing");
    }

    @Around("ticketMethods()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Around: Before method execution");

        Object result = joinPoint.proceed();

        System.out.println("Around: After method execution");

        return result;
    }

    @AfterReturning(
        pointcut = "execution(* com.example.moviebooking.MovieTicketService.addTicket(..))",
        returning = "result"
    )
    public void afterReturning(Object result) {

        System.out.println("AfterReturning: Ticket added successfully");
        System.out.println("Ticket: " + result);
    }

    @After("ticketMethods()")
    public void afterMethod() {

        System.out.println("After: Movie ticket service method completed");
    }
}
