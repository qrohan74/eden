package qrohan.eden.core.stream.example;

import qrohan.eden.core.stream.*;

/**
 * Class SimpleContainer
 * This represents the container: simpleContainer
 * Description: Example of simple container
 */
public class SimpleContainer extends Container
{
    /**
     * Class Param1
     * This represents the parameter: param1
     * Description: this is param1
     */
    public static class Param1 extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 8;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Param1(String name, Container parent)
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
    
    } // END OF CLASS Param1

    /**
     * Class Param2
     * This represents the parameter: param2
     * Description: this is param2
     */
    public static class Param2 extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 16;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Param2(String name, Container parent)
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
    
    } // END OF CLASS Param2

    /**
     * Class Param3
     * This represents the parameter: param3
     * Description: this is param3
     */
    public static class Param3 extends Parameter
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
        public Param3(String name, Container parent)
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
    
    } // END OF CLASS Param3

    // --- BEGIN FIELDS ---

    /**
     * field param1
     * Description: this is param1
     */
    Param1 param1;

    /**
     * field param2
     * Description: this is param2
     */
    Param2 param2;

    /**
     * field param3
     * Description: this is param3
     */
    Param3 param3;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public SimpleContainer(String name, Container parent)
    {
        super(name, parent);
        this.param1 = new Param1("param1", this);
        this.param2 = new Param2("param2", this);
        this.param3 = new Param3("param3", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of parameter param1
     * @return value of parameter
     */
    public long get_param1()
    {
        return this.param1.get();
    }

    /**
     * Set value of parameter param1
     * @param value new value
     */
    public void set_param1(long value)
    {
        this.param1.set(value);
    }

    /**
     * Get value of parameter param2
     * @return value of parameter
     */
    public long get_param2()
    {
        return this.param2.get();
    }

    /**
     * Set value of parameter param2
     * @param value new value
     */
    public void set_param2(long value)
    {
        this.param2.set(value);
    }

    /**
     * Get value of parameter param3
     * @return value of parameter
     */
    public long get_param3()
    {
        return this.param3.get();
    }

    /**
     * Set value of parameter param3
     * @param value new value
     */
    public void set_param3(long value)
    {
        this.param3.set(value);
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS SimpleContainer

