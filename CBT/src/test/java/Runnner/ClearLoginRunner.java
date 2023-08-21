package Runnner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"C:\\Users\\Swapnil_Bobade\\eclipse-workspace\\CBT\\src\\test\\resources\\Features\\Login.feature"},
glue= {"Steps"},
monochrome=true,
tags="@Regression")

public class ClearLoginRunner extends AbstractTestNGCucumberTests{

}
