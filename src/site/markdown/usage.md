Usage
=====

Create a class from a JSON file
-------------------------------

In order to create your class, use the method `createFromJson` of the `Factory` tool (available in the package `qrohan.eden.core.tools.factory`)

```java
package my.project.example;

import java.io.IOException;
import java.util.logging.Level;

public class Example {
    public static void main(String[] args) throws IOException {
        Factory factory = new Factory();
        factory.setLoggingLevel(Level.WARNING); // set factory verbosity (optional)
        factory.setGenerationDir(System.getProperty("user.dir"));

        /*
         * the method takes 2 arguments:
         * 1. the name or path of the JSON file
         * 2. the package of the generated class
         */
        factory.createFromJson("file.json", "my.class.package");
    }
}
```

Check the validity of a JSON file
---------------------------------

You may want to check the validity of your JSON file. To do so, use the `JsonChecker` tool (available in the package `qrohan.eden.core.tools.analyzer`)

```java
package my.poject.example;

import qrohan.eden.core.tools.analyzer.JsonChecker;

public class Example {
    public static void main(String[] args) {
        JsonChecker.check("file.json");
    }
}
```