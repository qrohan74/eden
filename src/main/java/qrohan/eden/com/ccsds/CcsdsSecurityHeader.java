package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsSecurityHeader
 * This represents the container: CcsdsSecurityHeader
 * Description: Space Data Link Security Protocol (CCSDS 355.0-B-2) - Security Header
 */
public class CcsdsSecurityHeader extends Container
{
    /**
     * Class SecurityParameterIndex
     * This represents the parameter: securityParameterIndex
     * Description: Security Parameter Index (i.e. SPI, 16 bits; mandatory)
     */
    public static class SecurityParameterIndex extends Parameter
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
        public SecurityParameterIndex(String name, Container parent)
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
    
    } // END OF CLASS SecurityParameterIndex

    /**
     * Class InitializationVector
     * This represents the buffer: initializationVector
     * Description: Initialization Vector (octet-aligned, fixed-length; optional)
     */
    public static class InitializationVector extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public InitializationVector(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS InitializationVector

    /**
     * Class SequenceNumber
     * This represents the buffer: sequenceNumber
     * Description: Sequence Number (octet-aligned, fixed-length; optional)
     */
    public static class SequenceNumber extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public SequenceNumber(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS SequenceNumber

    /**
     * Class PadLength
     * This represents the buffer: padLength
     * Description: Pad Length (octet-aligned, fixed-length; optional)
     */
    public static class PadLength extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public PadLength(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS PadLength

    // --- BEGIN FIELDS ---

    /**
     * field securityParameterIndex
     * Description: Security Parameter Index (i.e. SPI, 16 bits; mandatory)
     */
    SecurityParameterIndex securityParameterIndex;

    /**
     * field initializationVector
     * Description: Initialization Vector (octet-aligned, fixed-length; optional)
     */
    InitializationVector initializationVector;

    /**
     * field sequenceNumber
     * Description: Sequence Number (octet-aligned, fixed-length; optional)
     */
    SequenceNumber sequenceNumber;

    /**
     * field padLength
     * Description: Pad Length (octet-aligned, fixed-length; optional)
     */
    PadLength padLength;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsSecurityHeader(String name, Container parent)
    {
        super(name, parent);
        this.securityParameterIndex = new SecurityParameterIndex("securityParameterIndex", this);
        this.initializationVector = new InitializationVector("initializationVector", this);
        this.sequenceNumber = new SequenceNumber("sequenceNumber", this);
        this.padLength = new PadLength("padLength", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of parameter securityParameterIndex
     * @return value of parameter
     */
    public long get_securityParameterIndex()
    {
        return this.securityParameterIndex.get();
    }

    /**
     * Set value of parameter securityParameterIndex
     * @param value new value
     */
    public void set_securityParameterIndex(long value)
    {
        this.securityParameterIndex.set(value);
    }

    /**
     * Get value of buffer initializationVector
     * @return buffer
     */
    public InitializationVector get_initializationVector()
    {
        return this.initializationVector;
    }

    /**
     * Get value of buffer sequenceNumber
     * @return buffer
     */
    public SequenceNumber get_sequenceNumber()
    {
        return this.sequenceNumber;
    }

    /**
     * Get value of buffer padLength
     * @return buffer
     */
    public PadLength get_padLength()
    {
        return this.padLength;
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsSecurityHeader

