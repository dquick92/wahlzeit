package org.wahlzeit;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.model.persistence.GcsAdapterTest;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;
import org.wahlzeit.services.mailing.EmailServiceTest;
import org.wahlzeit.utils.StringUtilTest;
import org.wahlzeit.utils.VersionTest;

@RunWith(AllTests.class)
public final class AllTestSuite {


    public static TestSuite suite() {

        TestSuite suite = new TestSuite();

        suite.addTest(new JUnit4TestAdapter(AbstractAdapterTest.class));
        suite.addTest(new JUnit4TestAdapter(DatastoreAdapterTest.class));
        suite.addTest(new JUnit4TestAdapter(GcsAdapterTest.class));
        suite.addTest(new JUnit4TestAdapter(AccessRightsTest.class));
        suite.addTest(new JUnit4TestAdapter(CoordinateTest.class));
        suite.addTest(new JUnit4TestAdapter(FlagReasonTest.class));
        suite.addTest(new JUnit4TestAdapter(GenderTest.class));
        suite.addTest(new JUnit4TestAdapter(LocationTest.class));
        suite.addTest(new JUnit4TestAdapter(PhotoFilterTest.class));
        suite.addTest(new JUnit4TestAdapter(TagsTest.class));
        suite.addTest(new JUnit4TestAdapter(UserStatusTest.class));
        suite.addTest(new JUnit4TestAdapter(ValueTest.class));
        suite.addTest(new JUnit4TestAdapter(EmailServiceTest.class));
        suite.addTest(new JUnit4TestAdapter(EmailAddressTest.class));
        suite.addTest(new JUnit4TestAdapter(LogBuilderTest.class));
        suite.addTest(new JUnit4TestAdapter(StringUtilTest.class));
        suite.addTest(new JUnit4TestAdapter(VersionTest.class));
        suite.addTest(new JUnit4TestAdapter(AbstractCoordinateTest.class));

        return suite;
    }


}
