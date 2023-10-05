package pl.coderslab.shop;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\CodersLab\\EXAM-WORK2\\src\\Cucumber\\Features", plugin = {"pretty", "html:out.html"})

public class ShopTest {
}
