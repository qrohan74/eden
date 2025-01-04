package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsTcSegmentHeader
 * This represents the container: CcsdsTcSegmentHeader
 * Description: TC transfer frame (CCSDS 232.0-B-4) - Segment Header (1 octet, optional)
 */
public class CcsdsTcSegmentHeader extends Container
{
    /**
     * Class SequenceFlags
     * This represents the parameter: sequenceFlags
     * Description: Sequence Flags
     */
    public static class SequenceFlags extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 2;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public SequenceFlags(String name, Container parent)
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
    
    } // END OF CLASS SequenceFlags

    /**
     * Class MultiplexerAccessPointId
     * This represents the parameter: multiplexerAccessPointId
     * Description: Multiplexer Access Point ID
     */
    public static class MultiplexerAccessPointId extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 6;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public MultiplexerAccessPointId(String name, Container parent)
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
    
    } // END OF CLASS MultiplexerAccessPointId

    // --- BEGIN FIELDS ---

    /**
     * field sequenceFlags
     * Description: Sequence Flags
     */
    SequenceFlags sequenceFlags;

    /**
     * field multiplexerAccessPointId
     * Description: Multiplexer Access Point ID
     */
    MultiplexerAccessPointId multiplexerAccessPointId;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsTcSegmentHeader(String name, Container parent)
    {
        super(name, parent);
        this.sequenceFlags = new SequenceFlags("sequenceFlags", this);
        this.multiplexerAccessPointId = new MultiplexerAccessPointId("multiplexerAccessPointId", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of parameter sequenceFlags
     * @return value of parameter
     */
    public long get_sequenceFlags()
    {
        return this.sequenceFlags.get();
    }

    /**
     * Set value of parameter sequenceFlags
     * @param value new value
     */
    public void set_sequenceFlags(long value)
    {
        this.sequenceFlags.set(value);
    }

    /**
     * Get value of parameter multiplexerAccessPointId
     * @return value of parameter
     */
    public long get_multiplexerAccessPointId()
    {
        return this.multiplexerAccessPointId.get();
    }

    /**
     * Set value of parameter multiplexerAccessPointId
     * @param value new value
     */
    public void set_multiplexerAccessPointId(long value)
    {
        this.multiplexerAccessPointId.set(value);
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsTcSegmentHeader

