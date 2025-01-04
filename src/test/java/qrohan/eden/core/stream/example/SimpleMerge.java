package qrohan.eden.core.stream.example;

import qrohan.eden.core.stream.*;

/**
 * Class SimpleMerge
 * This represents the container: simpleMerge
 * Description: Example of simple container
 */
public class SimpleMerge extends Container
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
        public static final int length = 16;
    
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
        public static final int length = 32;
    
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
     * Class Cont2
     * This represents the container: cont2
     * Description: Example of simple container
     */
    public static class Cont2 extends Container
    {
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
            public static final int length = 8;
        
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

        /**
         * Class Param4
         * This represents the parameter: param4
         * Description: this is param4
         */
        public static class Param4 extends Parameter
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
            public Param4(String name, Container parent)
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
        
        } // END OF CLASS Param4

        // --- BEGIN FIELDS ---
    
        /**
         * field param3
         * Description: this is param3
         */
        Param3 param3;
    
        /**
         * field param4
         * Description: this is param4
         */
        Param4 param4;
    
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Cont2(String name, Container parent)
        {
            super(name, parent);
            this.param3 = new Param3("param3", this);
            this.param4 = new Param4("param4", this);
    
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN FIELDS METHODS ---
    
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
    
        /**
         * Get value of parameter param4
         * @return value of parameter
         */
        public long get_param4()
        {
            return this.param4.get();
        }
    
        /**
         * Set value of parameter param4
         * @param value new value
         */
        public void set_param4(long value)
        {
            this.param4.set(value);
        }
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS Cont2

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
     * field cont2
     * Description: Example of simple container
     */
    Cont2 cont2;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public SimpleMerge(String name, Container parent)
    {
        super(name, parent);
        this.param1 = new Param1("param1", this);
        this.param2 = new Param2("param2", this);
        this.cont2 = new Cont2("cont2", this);

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
     * Get value of container cont2
     * @return container
     */
    public Cont2 get_cont2()
    {
        return this.cont2;
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS SimpleMerge

