package DynamicTest;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.ArrayList;
import java.util.List;

public class DynamicTestNGConfig implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        String testClasses = System.getProperty("testClasses", "");
        String[] classArray = testClasses.split(",");

        XmlSuite suite = new XmlSuite();
        suite.setName("Car Rental Test Suite");
        XmlTest test = new XmlTest(suite);
        test.setName("Car Rental Tests");

        List<XmlClass> classes = new ArrayList<>();
        for (String className : classArray) {
            classes.add(new XmlClass(className.trim()));
        }
        test.setXmlClasses(classes);

        suites.clear();
        suites.add(suite);
    }
}
