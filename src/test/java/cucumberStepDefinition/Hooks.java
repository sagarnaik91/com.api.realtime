package cucumberStepDefinition;

import io.cucumber.java.*;

public class Hooks {
    /*@BeforeAll
   @AfterAll
   @BeforeStep
   @AfterStep*/

    /*@Before(order = 0)
    public static void setup1() {
        System.out.println("Launching the browser1");
    }

    @Before(order = 1)
    public static void setup2() {
        System.out.println("Launching the browser2");
    }

    @After(order = 1)
    public static void tearDown1() {
        System.out.println("Quitting browser1");
    }

    @After(order = 0)
    public static void tearDown2() {
        System.out.println("Quitting browser2");
    }*/
    @Before("@test2")
    public static void setup1() {
        System.out.println("Launching the browser1");
    }
    @After("@test2")
    public static void tearDown1() {
        System.out.println("Quitting browser1");
    }

}
