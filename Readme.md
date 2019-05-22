# AOP - Aspect Oriented Programming
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#aop

In OOP, the unit of modularity is the object or class, but it doesn't resolve some issues of tightly coupled code that is only tangentially related to your business logic:
- Logging
- Exception Handling
- Configurations
- Security/Validation
- Transactions
- Tests

In other words: cross-cutting concerns.

In AOP, the unit of modularity is the aspect, otherwise known as a cross-cutting concern. These are code snippets or statements that can be injected into an application which is decoupled from the business logic.

# Spring AOP
With Spring we can define aspects as a class that has several methods which will act as interceptors to other methods in our application. These interceptors are known as advices which will take certain types of actions.
 - **Advice**: Action to be taken at Join Point
 - **Join Point**: Method where code will be injected
 - **Pointcut**: expression which specifies join points where advices will be applied

## Advice
Action that occurs at the joinpoint which has several types:
- Before: preceeds join point, can't interfere with the joinpoint unless exception is thrown
- After - proceeds join point (After-Finally)
    - After-returning: proceeds normal execution of joinpoint
    - After-throwing proceeds if exeption is thrown
- Around - the most powerful advice, acts both before and after, and requires that the developer calls JoinPoint.proceed() to continue join point execution.

## Pointcut
Each advice will have an expression next to their Advice annotation which determines what to listen for in the stack.
- Target: object or method being advised
- AOP Proxy from Spring AOP framework will intercept calls to target and delegate appropriate advice

```java
@Aspect
@Component
public class AnimalAdvisor {
    @Before
    public void beforeGetter(execution(* get*(..)) {
        System.out.println("This prints before every getter is run");
    }
}
```

Examples
- Execution of any public method
> execution(public * *(..))
- Execution of any method starting with 'set'
> execution(* set*(..))
- Execution of any method defined within AnimalService interface
> execution(* com.revature.service.AnimalService.*(..))
- Execution of any method defined within com.revature.demo package
``` execution(* com.revature.demo.*.*(..))```
- Now in subpackage
``` execution(* com.revature.demo..*(..))```
- Within a package
> within(com.revature.demo.*)