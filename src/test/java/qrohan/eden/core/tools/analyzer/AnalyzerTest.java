package qrohan.eden.core.tools.analyzer;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AnalyzerTest
{
	private final String path = "src/test/resources/stream/";
	private final String invalidPath = path+"/invalid/";

	@BeforeEach
	public void init()
	{
	}

	@AfterEach
	public void terminate()
	{
	}

	@Nested
	@Tag("AnalyzerCheck")
	@DisplayName("JSON check")
	class AnalyzerJsonChecker {
		@Test
		@DisplayName("Check JSON object")
		void test_valid()
		{
			assertTrue(JsonChecker.check(path + "simple_parameter.json"), "Check simple_parameter");
			assertTrue(JsonChecker.check(path + "simple_container.json"), "Check simple_container");
			assertTrue(JsonChecker.check(path + "simple_container_with_parameter_list.json"), "Check simple_container_with_parameter_list");
			assertTrue(JsonChecker.check(path + "simple_container_with_container_list.json"), "Check simple_container_with_container_list");
		}

		@Test
		@DisplayName("Check JSON invalid field")
		void test_invalid_field()
		{
			assertFalse(JsonChecker.check(invalidPath + "invalid_field0.json"), "Check invalid_field0");
			assertFalse(JsonChecker.check(invalidPath + "invalid_field1.json"), "Check invalid_field1");
			assertFalse(JsonChecker.check(invalidPath + "invalid_field2.json"), "Check invalid_field2");
		}

		@Test
		@DisplayName("Check JSON invalid parameter")
		void test_invalid_parameter()
		{
			assertFalse(JsonChecker.check(invalidPath + "invalid_parameter0.json"), "Check invalid_parameter0");
			assertFalse(JsonChecker.check(invalidPath + "invalid_parameter1.json"), "Check invalid_parameter1");
		}

		@Test
		@DisplayName("Check JSON invalid container")
		void test_invalid_container()
		{
			assertFalse(JsonChecker.check(invalidPath + "invalid_container0.json"), "Check invalid_container0");
			assertFalse(JsonChecker.check(invalidPath + "invalid_container1.json"), "Check invalid_container1");
		}

		@Test
		@DisplayName("Check JSON invalid parameter list")
		void test_invalid_parameter_list()
		{
			assertFalse(JsonChecker.check(invalidPath + "invalid_parameter_list0.json"), "Check invalid_parameter_list0");
			assertFalse(JsonChecker.check(invalidPath + "invalid_parameter_list1.json"), "Check invalid_parameter_list1");
			assertFalse(JsonChecker.check(invalidPath + "invalid_parameter_list2.json"), "Check invalid_parameter_list2");
		}
	}
}
