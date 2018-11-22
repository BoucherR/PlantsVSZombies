package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @name AllTests
 * @author Youssef Saghbini
 **/

/**
 * Running all tests combined
 */
@RunWith(Suite.class)
@SuiteClasses({BucketZombieTest.class, ConeheadZombieTest.class, ZombieTest.class,
                ControllerTest.class, CoordinateTest.class, GiantSunflowerTest.class,
                PeashooterTest.class, PieceTest.class, RepeaterTest.class,
                SquareTest.class, SunflowerTest.class, ThreepeaterTest.class,
                TwinSunflowerTest.class, ViewTest.class, WallnutTest.class})


public class TestAll {
}
