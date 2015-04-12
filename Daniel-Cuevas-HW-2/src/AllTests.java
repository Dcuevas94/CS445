import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ ATest.class, BTest.class, CTest.class, DTest.class,
		ETest.class, FTest.class })
public class AllTests {

}
