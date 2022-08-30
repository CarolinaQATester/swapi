package com.testeapi.runners;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@IncludeTags("todos")
public class TodosTestsRunner {
}