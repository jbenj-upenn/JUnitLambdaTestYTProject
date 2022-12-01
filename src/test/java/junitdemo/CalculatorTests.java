package junitdemo;

import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) : runs all tests for the whole class
public class CalculatorTests {
    private final Calculator _calculator = new Calculator();

    @BeforeAll
    public static void setUpClass() {
        System.out.println("This is @BeforeAll annotation. It's a static method and executes once for all tests in the class.");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("This is @BeforeEach annotation. It's non-static and is executed before each.");
    }
    @Test
    public void testAddPositiveNumbers_Case1(){
        var actualResult= _calculator.add(7, 4);
        Assertions.assertEquals(11, actualResult);
    }
    @Test
    @DisplayName("Test Addition Different Numbers")
    @RepeatedTest(value = 10, name = "{displayName}_{currentRepetition}/{totalRepetitions}")
    public void testAddNegativeNumberLarger_Case2(){
        var actualResult= _calculator.add(-7, 4);

        Assertions.assertEquals(-3, actualResult);
    }
    @Test
    public void testAddNegativeNumberSmaller_Case3(){
        var actualResult = _calculator.add(7, -4);
        Assertions.assertEquals(3, actualResult);
    }
    @Test
    public void testAddTwoNegativeNumbers_Case4(){
        var actualResult = _calculator.add(-7, -4);
        Assertions.assertEquals(-11, actualResult);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("This is @AfterEach annotation; it's non-static and runs after each.");
    }
    @AfterAll
    public static void tearDownClass() {
        System.out.println("This is @AfterAll annotation; it is static and runs after all tests.");
    }
}
