package qrohan.eden.core.tools.analyzer;

import qrohan.eden.core.misc.JsonUtils;
import qrohan.eden.core.stream.AbstractObject;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for JSON file checker
 */
public class JsonChecker extends AbstractObject {
	/**
	 * Default constructor
	 */
	public JsonChecker()
	{
		// empty
	}

	/**
	 * Check the validity of the map representing a JSON object
	 * @param map data map to be checked
	 * @return true if valid, false otherwise
	 */
	public boolean check(Map<String, Object> map)
	{
		if (map.isEmpty()) {
			error("the map is empty");
			return false;
		}
        return checkField(map);
	}

	/**
	 * Check the validity of the map representing any abstract field (see {@link qrohan.eden.core.stream.AbstractField}
	 * @param field map representing the field
	 * @return true if valid, false otherwise
	 */
	public boolean checkField(Map<String, Object> field)
	{
		if (field.isEmpty()) {
			error("the field is empty");
			return false;
		}

		// check required keys
		String[] requiredKeys = new String[] {"name", "description", "type"};
		for (String key: requiredKeys) {
			Object object = field.get(key);
			if (object == null) {
				error("the field must declare a " + key);
				return false;
			}
			if (!(object instanceof String)) {
				error("the field " + key + " must be a string");
				return false;
			}
			if (object.toString().isBlank()) {
				error("the field " + key + " must not be blank");
				return false;
			}
		}

		// check name
		String fieldName = field.get("name").toString();
		if (fieldName.matches(".*\\s.*")) {
			error("the field '" + fieldName + "' should not contain any whitespace");
			return false;
		}

		// check type
		String fieldType = field.get("type").toString();
		if (!fieldType.equals("parameter") && !fieldType.equals("container")
				&& !fieldType.equals("TM") && !fieldType.equals("TC")) {
			error("the field '" + fieldName + "' has invalid type");
			return false;
		}

		// specific check
		if (fieldType.equals("parameter")) {
			return checkParameter(field);
		} else {
			return checkContainer(field);
		}
	}

	/**
	 * Check the validity of the map representing a parameter (see {@link qrohan.eden.core.stream.Parameter}
	 * @param parameter map representing the parameter
	 * @return true if valid, false otherwise
	 */
	public boolean checkParameter(Map<String, Object> parameter)
	{
		String name = parameter.get("name").toString();

		// check parameter required length
		Object object = parameter.get("length");
		if (object == null) {
			error("the parameter '" + name + "' must declare a length");
			return false;
		}
		if (!(object instanceof Integer)) {
			error("the parameter '" + name + "' length must declare an integer");
			return false;
		}
		int length = (int)object;
		if (length <= 0) {
			error("the parameter '" + name + "' length must be positive");
			return false;
		}

		// check parameter validity
		for (String key: parameter.keySet()) {
			if (key.equals("name") || key.equals("description") || key.equals("type")
					|| key.equals("length") || key.equals("unit")) {
				continue;
			} else if (key.equals("multiplierOf") || key.equals("multipliedBy")) {
				Object parameterObject = parameter.get(key);
				if (!(parameterObject instanceof String)) {
					error("the container '" + name + "' value of " + key + " must be a string");
					return false;
				}
				continue;
            }
			error("the parameter '" + name + "' has invalid field '" + key + "'");
			return false;
		}

		// parameter ok
		return true;
	}

	/**
	 * Check the validity of the map representing a container (see {@link qrohan.eden.core.stream.Container}
	 * @param container map representing the container
	 * @return true if valid, false otherwise
	 */
	@SuppressWarnings("unchecked")
	public boolean checkContainer(Map<String, Object> container)
	{
		String name = container.get("name").toString();

		// check container required fields
		Object object = container.get("fields");
		if (object == null) {
			error("the container '" + name + "' must declare fields");
			return false;
		}
		if (!(object instanceof List)) {
			error("the container '" + name + "' fields must be an array");
			return false;
		}
		if (((List<Object>) object).isEmpty()) {
			error("the container '" + name + "' fields is empty");
			return false;
		}

		// check container validity
		for (String key: container.keySet()) {
			if (key.equals("name") || key.equals("description") || key.equals("type")  || key.equals("fields")) {
				continue;
            } else if (key.equals("multipliedBy")) {
				Object multipliedBy = container.get(key);
				if (!(multipliedBy instanceof String)) {
					error("the container '" + name + "' value of " + key + " must be a string");
					return false;
				}
				continue;
            }
			error("the container '" + name + "' has invalid field '" + key + "'");
			return false;
		}

		// check container fields
		for (Object field: (List<Object>) object) {
			assert field instanceof Map;
			if (!checkField((Map<String, Object>) field)) {
				return false;
			}
		}

		// check consistency between factors and multiplied fields
		Map<String, String> factors = new HashMap<>();
		Map<String, String> multiplied = new HashMap<>();
		for (Object field: (List<Object>) object) {
			assert field instanceof Map;
			Map<String, Object> realField = (Map<String, Object>) field;
			String fieldName = realField.get("name").toString();

			// multiplierOf
			Object multiplierOf = realField.get("multiplierOf");
			if (multiplierOf instanceof String) {
				String fieldMultiplierOf = multiplierOf.toString();
				if (fieldMultiplierOf.equals(fieldName)) {
					error("the container '" + name + "' field '" + fieldName + "' cannot multiply itself");
					return false;
				}
				factors.put(fieldName, fieldMultiplierOf);
			}

			// multipliedBy
			Object multipliedBy = realField.get("multipliedBy");
			if (multipliedBy instanceof String) {
				String fieldMultipliedBy = multipliedBy.toString();
				if (fieldMultipliedBy.equals(fieldName)) {
					error("the container '" + name + "' field '" + fieldName + "' cannot be multiplied by itself");
					return false;
				}
				multiplied.put(fieldName, fieldMultipliedBy);
			}
		}
		for (Map.Entry<String, String> entry : factors.entrySet()) {
			String factor = multiplied.get(entry.getValue());
			if (factor == null || !factor.equals(entry.getKey())) {
				error("the container '" + name + "' field '" + entry.getKey() + "' is inconsistent (factor)");
				return false;
			}
		}
		for (Map.Entry<String, String> entry : multiplied.entrySet()) {
			String factored = factors.get(entry.getValue());
			if (factored == null || !factored.equals(entry.getKey())) {
				error("the container '" + name + "' field '" + entry.getKey() + "' is inconsistent (factored)");
				return false;
			}
		}

		// container ok
		return true;
	}

	/**
	 * Check the validity of a JSON file
	 * @param fileName file path of the JSON file
	 * @return true if valid, false otherwise
	 */
	public static boolean check(String fileName)
	{
		try {
			JSONObject jsonObject = JsonUtils.createJsonObject(fileName);
			return new JsonChecker().check(jsonObject.toMap());
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
