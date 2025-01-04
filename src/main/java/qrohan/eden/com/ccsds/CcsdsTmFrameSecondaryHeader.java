package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsTmFrameSecondaryHeader
 * This represents the container: CcsdsTmFrameSecondaryHeader
 * Description: TM transfer frame (CCSDS 132.0-B-3) - Transfer Frame Secondary Header (up to 64 octets)
 */
public class CcsdsTmFrameSecondaryHeader extends Container
{
    /**
     * Class SecondaryHeaderId
     * This represents the container: secondaryHeaderId
     * Description: Transfer Frame Secondary Header ID (1 octet, mandatory)
     */
    public static class SecondaryHeaderId extends Container
    {
        /**
         * Class VersionNumber
         * This represents the parameter: versionNumber
         * Description: Transfer Frame Secondary Header Version Number (2 bits, mandatory)
         */
        public static class VersionNumber extends Parameter
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
            public VersionNumber(String name, Container parent)
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
        
        } // END OF CLASS VersionNumber

        /**
         * Class HeaderLength
         * This represents the parameter: headerLength
         * Description: Transfer Frame Secondary Header Length (6 bits, mandatory)
         */
        public static class HeaderLength extends Parameter
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
            public HeaderLength(String name, Container parent)
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
        
        } // END OF CLASS HeaderLength

        // --- BEGIN FIELDS ---
    
        /**
         * field versionNumber
         * Description: Transfer Frame Secondary Header Version Number (2 bits, mandatory)
         */
        VersionNumber versionNumber;
    
        /**
         * field headerLength
         * Description: Transfer Frame Secondary Header Length (6 bits, mandatory)
         */
        HeaderLength headerLength;
    
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public SecondaryHeaderId(String name, Container parent)
        {
            super(name, parent);
            this.versionNumber = new VersionNumber("versionNumber", this);
            this.headerLength = new HeaderLength("headerLength", this);
    
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN FIELDS METHODS ---
    
        /**
         * Get value of parameter versionNumber
         * @return value of parameter
         */
        public long get_versionNumber()
        {
            return this.versionNumber.get();
        }
    
        /**
         * Set value of parameter versionNumber
         * @param value new value
         */
        public void set_versionNumber(long value)
        {
            this.versionNumber.set(value);
        }
    
        /**
         * Get value of parameter headerLength
         * @return value of parameter
         */
        public long get_headerLength()
        {
            return this.headerLength.get();
        }
    
        /**
         * Set value of parameter headerLength
         * @param value new value
         */
        public void set_headerLength(long value)
        {
            this.headerLength.set(value);
        }
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS SecondaryHeaderId

    /**
     * Class SecondaryHeaderDataField
     * This represents the buffer: secondaryHeaderDataField
     * Description: Transfer Frame Secondary Header Data Field (up to 63 octets, optional)
     */
    public static class SecondaryHeaderDataField extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public SecondaryHeaderDataField(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS SecondaryHeaderDataField

    // --- BEGIN FIELDS ---

    /**
     * field secondaryHeaderId
     * Description: Transfer Frame Secondary Header ID (1 octet, mandatory)
     */
    SecondaryHeaderId secondaryHeaderId;

    /**
     * field secondaryHeaderDataField
     * Description: Transfer Frame Secondary Header Data Field (up to 63 octets, optional)
     */
    SecondaryHeaderDataField secondaryHeaderDataField;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsTmFrameSecondaryHeader(String name, Container parent)
    {
        super(name, parent);
        this.secondaryHeaderId = new SecondaryHeaderId("secondaryHeaderId", this);
        this.secondaryHeaderDataField = new SecondaryHeaderDataField("secondaryHeaderDataField", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of container secondaryHeaderId
     * @return container
     */
    public SecondaryHeaderId get_secondaryHeaderId()
    {
        return this.secondaryHeaderId;
    }

    /**
     * Get value of buffer secondaryHeaderDataField
     * @return buffer
     */
    public SecondaryHeaderDataField get_secondaryHeaderDataField()
    {
        return this.secondaryHeaderDataField;
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsTmFrameSecondaryHeader

