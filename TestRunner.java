package com.juaracoding.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Login.feature"},glue = "com.juaracoding.cucumber.definition" )


public class TestRunner {

}
