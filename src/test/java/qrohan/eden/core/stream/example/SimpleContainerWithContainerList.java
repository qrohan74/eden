package qrohan.eden.core.stream.example;

import qrohan.eden.core.stream.*;

/**
 * Class SimpleContainerWithContainerList
 * This represents the container: simpleContainerWithContainerList
 * Description: Example of simple container with a list of containers
 */
public class SimpleContainerWithContainerList extends Container
{
    /**
     * Class Param1
     * This represents the parameter: param1
     * Description: this is parameter 1
     */
    public static class Param1 extends Parameter
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
     * Description: this is parameter 2
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
     * Class Cont1
     * This represents the container: cont1
     * Description: this is container 1
     */
    public static class Cont1 extends Container
    {
        /**
         * Class Param3
         * This represents the parameter: param3
         * Description: this is parameter 3
         */
        public static class Param3 extends Parameter
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
         * Description: this is parameter 4
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

        /**
         * Class Param5
         * This represents the parameter: param5
         * Description: this is parameter 5
         */
        public static class Param5 extends Parameter
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
            public Param5(String name, Container parent)
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
        
        } // END OF CLASS Param5

        /**
         * Class Param5List
         * This represents a list of parameters: param5
         * Description: this is parameter 5
         */
        public static class Param5List extends ParameterList<Param5>
        {
            // --- BEGIN FIELDS ---
        
            // --- END FIELDS ---
        
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public Param5List(String name, Container parent)
            {
                super(name, parent, Param5.class);
            }
        
            // --- END CONSTRUCTORS/DESTRUCTORS ---
        
            // --- BEGIN FIELDS METHODS ---
        
            // --- END FIELDS METHODS ---
        } // END OF CLASS Param5List

        // --- BEGIN FIELDS ---
    
        /**
         * field param3
         * Description: this is parameter 3
         */
        Param3 param3;
    
        /**
         * field param4
         * Description: this is parameter 4
         */
        Param4 param4;
    
        /**
         * field param5
         * Description: this is parameter 5
         */
        Param5List param5;
    
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Cont1(String name, Container parent)
        {
            super(name, parent);
            this.param3 = new Param3("param3", this);
            this.param4 = new Param4("param4", this);
            this.param5 = new Param5List("param5", this);
    
            // param4 multiplies param5
            this.param4.setFactor(this.param5);
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
    
        /**
         * Get value of parameter param5 at index
         * @param index list index
         * @return value of parameter
         */
        public long get_param5(int index)
        {
            return this.param5.getAt(index);
        }
    
        /**
         * Set value of parameter param5 at index
         * @param index list index
         * @param value new value
         */
        public void set_param5(int index, long value)
        {
            this.param5.setAt(index, value);
        }
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS Cont1

    /**
     * Class Cont1List
     * This represents a list of containers: cont1
     * Description: this is container 1
     */
    public static class Cont1List extends ContainerList<Cont1>
    {
        // --- BEGIN FIELDS ---
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Cont1List(String name, Container parent)
        {
            super(name, parent, Cont1.class);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN FIELDS METHODS ---
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS Cont1List

    /**
     * Class Param6
     * This represents the parameter: param6
     * Description: this is parameter 6
     */
    public static class Param6 extends Parameter
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
        public Param6(String name, Container parent)
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
    
    } // END OF CLASS Param6

    // --- BEGIN FIELDS ---

    /**
     * field param1
     * Description: this is parameter 1
     */
    Param1 param1;

    /**
     * field param2
     * Description: this is parameter 2
     */
    Param2 param2;

    /**
     * field cont1
     * Description: this is container 1
     */
    Cont1List cont1;

    /**
     * field param6
     * Description: this is parameter 6
     */
    Param6 param6;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public SimpleContainerWithContainerList(String name, Container parent)
    {
        super(name, parent);
        this.param1 = new Param1("param1", this);
        this.param2 = new Param2("param2", this);
        this.cont1 = new Cont1List("cont1", this);
        this.param6 = new Param6("param6", this);

        // param2 multiplies cont1
        this.param2.setFactor(this.cont1);
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
     * Get value of container cont1 at index
     * @param index list index
     * @return container
     */
    public Cont1 get_cont1(int index)
    {
        return this.cont1.getAt(index);
    }

    /**
     * Get value of parameter param6
     * @return value of parameter
     */
    public long get_param6()
    {
        return this.param6.get();
    }

    /**
     * Set value of parameter param6
     * @param value new value
     */
    public void set_param6(long value)
    {
        this.param6.set(value);
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS SimpleContainerWithContainerList

