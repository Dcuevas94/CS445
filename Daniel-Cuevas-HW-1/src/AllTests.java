import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ AntTest.class, BatTest.class, FlyTest.class, ThingTest.class,
		TigerTest.class })
public class AllTests {

}
