package qrohan.eden.core.stream.example;

import qrohan.eden.core.stream.*;

/**
 * Class SimpleParameter
 * This represents the parameter: simpleParameter
 * Description: Example of simple parameter
 */
public class SimpleParameter extends Parameter
{
    /**
     * parameter length (in bits)
     */
    public static final int length = 32;

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public SimpleParameter(String name, Container parent)
    {
        super(name, parent);
    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN ABSTRACT FIELD METHODS ---

    /**
     * Get length
     * @return the length (in bits) of the parameter
     */
    public int getLength()
    {
        return length;
    }

    // --- END ABSTRACT FIELD METHODS ---

} // END OF CLASS SimpleParameter

