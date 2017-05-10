package suitSample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.homePageTest;
import tests.visualTest;


    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            homePageTest.class,
            visualTest.class
    })

    public class SampleSuit {
    }

