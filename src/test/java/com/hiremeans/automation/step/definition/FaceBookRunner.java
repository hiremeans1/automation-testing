package com.hiremeans.automation.step.definition;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"resources/feature/facebook.feature"}, glue = "FaceBookStepdefs")
public class FaceBookRunner {
}
