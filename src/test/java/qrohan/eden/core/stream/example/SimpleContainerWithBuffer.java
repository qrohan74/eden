package qrohan.eden.core.stream.example;

import qrohan.eden.core.stream.*;

/**
 * Class SimpleContainerWithBuffer
 * This represents the container: simpleContainerWithBuffer
 * Description: Example of simple container with some buffers
 */
public class SimpleContainerWithBuffer extends Container
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
     * Class Buffer1
     * This represents the buffer: buffer1
     * Description: this is buffer1
     */
    public static class Buffer1 extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Buffer1(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS Buffer1

    /**
     * Class Buffer2
     * This represents the buffer: buffer2
     * Description: this is buffer2
     */
    public static class Buffer2 extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Buffer2(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS Buffer2

    /**
     * Class Param2
     * This represents the parameter: param2
     * Description: this is param3
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

    // --- BEGIN FIELDS ---

    /**
     * field param1
     * Description: this is param1
     */
    Param1 param1;

    /**
     * field buffer1
     * Description: this is buffer1
     */
    Buffer1 buffer1;

    /**
     * field buffer2
     * Description: this is buffer2
     */
    Buffer2 buffer2;

    /**
     * field param2
     * Description: this is param3
     */
    Param2 param2;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public SimpleContainerWithBuffer(String name, Container parent)
    {
        super(name, parent);
        this.param1 = new Param1("param1", this);
        this.buffer1 = new Buffer1("buffer1", this);
        this.buffer2 = new Buffer2("buffer2", this);
        this.param2 = new Param2("param2", this);

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
     * Get value of buffer buffer1
     * @return buffer
     */
    public Buffer1 get_buffer1()
    {
        return this.buffer1;
    }

    /**
     * Get value of buffer buffer2
     * @return buffer
     */
    public Buffer2 get_buffer2()
    {
        return this.buffer2;
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

    // --- END FIELDS METHODS ---
} // END OF CLASS SimpleContainerWithBuffer

