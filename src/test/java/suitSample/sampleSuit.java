package suitSample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.HomePageTest;
import tests.visualTest;

public class sampleSuit {

    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            HomePageTest.class,
            visualTest.class
    })

    public class SampleSuit {
    }
}
