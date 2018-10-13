package weinvest.modules;

import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ Invest.class, AddNewStock.class, })

public class RunAllStories {
	@BeforeClass
	public static void beforeStories() throws Exception {
		
	}

	@AfterClass
	public static void afterStories() throws Exception {
		
	}
}