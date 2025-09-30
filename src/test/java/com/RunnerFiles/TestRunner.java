package com.RunnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = "src/test/resources/features/BookMyFlick.feature",
  glue = "stepdefinitions",
  plugin = {"pretty", "html:target/cucumber-reports.html"},
  monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {}

