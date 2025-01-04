package qrohan.eden.core.misc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Class providing some utils functions to read a JSON file
 */
public class JsonUtils {
    /**
     * Variable holding the directory of the current JSON file
     */
    String currentDirectory;

    /**
     * Default constructor
     */
    public JsonUtils() {
        this.currentDirectory = "";
    }

    /**
     * Read a JSON file and return the JSON object
     * @param file input file
     * @return JSON object
     * @throws IOException if the input file is invalid
     */
    public JSONObject read(String file) throws IOException {
        Path p;
        if (this.currentDirectory.isEmpty()) {
            p = Paths.get(file);
            this.currentDirectory = p.getParent().toString();
        } else {
            p = Paths.get(this.currentDirectory, file);
        }
        String jstring = new String(Files.readAllBytes(p));
        JSONObject context = new JSONObject(jstring);
        return (JSONObject) loopThroughJson(context);
    }

    /**
     * Loop on JSON file
     * @param object input object
     * @return the same object with inclusions
     * @throws JSONException if the object is invalid
     * @throws IOException if an error occurs during a reference read
     */
    private Object loopThroughJson(Object object) throws JSONException, IOException {
        if (object instanceof JSONObject jsonObject) {
            JSONObject res = new JSONObject();
            Iterator<?> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object value = jsonObject.get(key);
                if (value instanceof JSONArray || value instanceof JSONObject) {
                    res.put(key, loopThroughJson(value));
                } else {
                    res.put(key, value);
                }
            }
            return res;
        } else if (object instanceof JSONArray jsonArray) {
            JSONArray res = new JSONArray();
            for (int i = 0; i < jsonArray.length(); i++) {
                // all items must be either a JSON object (i.e. a field) or a string referencing a JSON object
                Object item = jsonArray.get(i);
                if (item instanceof JSONObject itemObject) {
                    res.put(loopThroughJson(item));
                } else if (item instanceof String itemString) {
                    assert itemString.startsWith("ref:");
                    res.put(read(itemString.substring(4)));
                } else {
                    throw new JSONException("ref value is not a string");
                }
            }
            return res;
        } else {
            return object;
        }
    }

    /**
     * Create JSON object from input file
     * @param file input file
     * @return JSON object
     * @throws IOException if error occurs during creation
     */
    public static JSONObject createJsonObject(String file) throws IOException {
        return new JsonUtils().read(file);
    }
}
