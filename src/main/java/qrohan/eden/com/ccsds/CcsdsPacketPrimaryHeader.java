package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsPacketPrimaryHeader
 * This represents the container: CcsdsPacketPrimaryHeader
 * Description: Space Packet Protocol (CCSDS 133.0-B-2) - Packet Primary Header
 */
public class CcsdsPacketPrimaryHeader extends Container
{
    /**
     * Class PacketVersionNumber
     * This represents the parameter: packetVersionNumber
     * Description: Packet Version Number (3 bits, mandatory)
     */
    public static class PacketVersionNumber extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 3;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public PacketVersionNumber(String name, Container parent)
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
    
    } // END OF CLASS PacketVersionNumber

    /**
     * Class PacketIdentificationId
     * This represents the container: packetIdentificationId
     * Description: Packet Identification Field (13 bits, mandatory)
     */
    public static class PacketIdentificationId extends Container
    {
        /**
         * Class PacketType
         * This represents the parameter: packetType
         * Description: Packet Type (1 bit, mandatory)
         */
        public static class PacketType extends Parameter
        {
            /**
             * parameter length (in bits)
             */
            public static final int length = 1;
        
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public PacketType(String name, Container parent)
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
        
        } // END OF CLASS PacketType

        /**
         * Class SecondaryHeaderFlag
         * This represents the parameter: secondaryHeaderFlag
         * Description: Secondary Header Flag (1 bit, mandatory)
         */
        public static class SecondaryHeaderFlag extends Parameter
        {
            /**
             * parameter length (in bits)
             */
            public static final int length = 1;
        
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public SecondaryHeaderFlag(String name, Container parent)
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
        
        } // END OF CLASS SecondaryHeaderFlag

        /**
         * Class ApplicationProcessIdentifier
         * This represents the parameter: applicationProcessIdentifier
         * Description: APID (11 bits, mandatory)
         */
        public static class ApplicationProcessIdentifier extends Parameter
        {
            /**
             * parameter length (in bits)
             */
            public static final int length = 11;
        
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public ApplicationProcessIdentifier(String name, Container parent)
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
        
        } // END OF CLASS ApplicationProcessIdentifier

        // --- BEGIN FIELDS ---
    
        /**
         * field packetType
         * Description: Packet Type (1 bit, mandatory)
         */
        PacketType packetType;
    
        /**
         * field secondaryHeaderFlag
         * Description: Secondary Header Flag (1 bit, mandatory)
         */
        SecondaryHeaderFlag secondaryHeaderFlag;
    
        /**
         * field applicationProcessIdentifier
         * Description: APID (11 bits, mandatory)
         */
        ApplicationProcessIdentifier applicationProcessIdentifier;
    
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public PacketIdentificationId(String name, Container parent)
        {
            super(name, parent);
            this.packetType = new PacketType("packetType", this);
            this.secondaryHeaderFlag = new SecondaryHeaderFlag("secondaryHeaderFlag", this);
            this.applicationProcessIdentifier = new ApplicationProcessIdentifier("applicationProcessIdentifier", this);
    
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN FIELDS METHODS ---
    
        /**
         * Get value of parameter packetType
         * @return value of parameter
         */
        public long get_packetType()
        {
            return this.packetType.get();
        }
    
        /**
         * Set value of parameter packetType
         * @param value new value
         */
        public void set_packetType(long value)
        {
            this.packetType.set(value);
        }
    
        /**
         * Get value of parameter secondaryHeaderFlag
         * @return value of parameter
         */
        public long get_secondaryHeaderFlag()
        {
            return this.secondaryHeaderFlag.get();
        }
    
        /**
         * Set value of parameter secondaryHeaderFlag
         * @param value new value
         */
        public void set_secondaryHeaderFlag(long value)
        {
            this.secondaryHeaderFlag.set(value);
        }
    
        /**
         * Get value of parameter applicationProcessIdentifier
         * @return value of parameter
         */
        public long get_applicationProcessIdentifier()
        {
            return this.applicationProcessIdentifier.get();
        }
    
        /**
         * Set value of parameter applicationProcessIdentifier
         * @param value new value
         */
        public void set_applicationProcessIdentifier(long value)
        {
            this.applicationProcessIdentifier.set(value);
        }
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS PacketIdentificationId

    /**
     * Class PacketSequenceControl
     * This represents the container: packetSequenceControl
     * Description: Packet Sequence Control (2 octets)
     */
    public static class PacketSequenceControl extends Container
    {
        /**
         * Class SequenceFlags
         * This represents the parameter: sequenceFlags
         * Description: Sequence Flags (2 bits, mandatory)
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
         * Class PacketSequenceCount
         * This represents the parameter: packetSequenceCount
         * Description: Packet Sequence Count or Packet Name (14 bits, mandatory)
         */
        public static class PacketSequenceCount extends Parameter
        {
            /**
             * parameter length (in bits)
             */
            public static final int length = 14;
        
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public PacketSequenceCount(String name, Container parent)
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
        
        } // END OF CLASS PacketSequenceCount

        // --- BEGIN FIELDS ---
    
        /**
         * field sequenceFlags
         * Description: Sequence Flags (2 bits, mandatory)
         */
        SequenceFlags sequenceFlags;
    
        /**
         * field packetSequenceCount
         * Description: Packet Sequence Count or Packet Name (14 bits, mandatory)
         */
        PacketSequenceCount packetSequenceCount;
    
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public PacketSequenceControl(String name, Container parent)
        {
            super(name, parent);
            this.sequenceFlags = new SequenceFlags("sequenceFlags", this);
            this.packetSequenceCount = new PacketSequenceCount("packetSequenceCount", this);
    
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
         * Get value of parameter packetSequenceCount
         * @return value of parameter
         */
        public long get_packetSequenceCount()
        {
            return this.packetSequenceCount.get();
        }
    
        /**
         * Set value of parameter packetSequenceCount
         * @param value new value
         */
        public void set_packetSequenceCount(long value)
        {
            this.packetSequenceCount.set(value);
        }
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS PacketSequenceControl

    /**
     * Class PacketDataLength
     * This represents the parameter: packetDataLength
     * Description: Packet Data Length (2 octets, mandatory)
     */
    public static class PacketDataLength extends Parameter
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
        public PacketDataLength(String name, Container parent)
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
    
    } // END OF CLASS PacketDataLength

    // --- BEGIN FIELDS ---

    /**
     * field packetVersionNumber
     * Description: Packet Version Number (3 bits, mandatory)
     */
    PacketVersionNumber packetVersionNumber;

    /**
     * field packetIdentificationId
     * Description: Packet Identification Field (13 bits, mandatory)
     */
    PacketIdentificationId packetIdentificationId;

    /**
     * field packetSequenceControl
     * Description: Packet Sequence Control (2 octets)
     */
    PacketSequenceControl packetSequenceControl;

    /**
     * field packetDataLength
     * Description: Packet Data Length (2 octets, mandatory)
     */
    PacketDataLength packetDataLength;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsPacketPrimaryHeader(String name, Container parent)
    {
        super(name, parent);
        this.packetVersionNumber = new PacketVersionNumber("packetVersionNumber", this);
        this.packetIdentificationId = new PacketIdentificationId("packetIdentificationId", this);
        this.packetSequenceControl = new PacketSequenceControl("packetSequenceControl", this);
        this.packetDataLength = new PacketDataLength("packetDataLength", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of parameter packetVersionNumber
     * @return value of parameter
     */
    public long get_packetVersionNumber()
    {
        return this.packetVersionNumber.get();
    }

    /**
     * Set value of parameter packetVersionNumber
     * @param value new value
     */
    public void set_packetVersionNumber(long value)
    {
        this.packetVersionNumber.set(value);
    }

    /**
     * Get value of container packetIdentificationId
     * @return container
     */
    public PacketIdentificationId get_packetIdentificationId()
    {
        return this.packetIdentificationId;
    }

    /**
     * Get value of container packetSequenceControl
     * @return container
     */
    public PacketSequenceControl get_packetSequenceControl()
    {
        return this.packetSequenceControl;
    }

    /**
     * Get value of parameter packetDataLength
     * @return value of parameter
     */
    public long get_packetDataLength()
    {
        return this.packetDataLength.get();
    }

    /**
     * Set value of parameter packetDataLength
     * @param value new value
     */
    public void set_packetDataLength(long value)
    {
        this.packetDataLength.set(value);
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsPacketPrimaryHeader

