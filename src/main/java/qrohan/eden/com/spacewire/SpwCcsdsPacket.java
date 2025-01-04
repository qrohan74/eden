package qrohan.eden.com.spacewire;

import qrohan.eden.core.stream.*;

/**
 * Class SpwCcsdsPacket
 * This represents the container: SpwCcsdsPacket
 * Description: CCSDS packet transfer protocol (ECSS-E-ST-50-53C) - CCSDS Packet Transfer
 */
public class SpwCcsdsPacket extends Container
{
    /**
     * Class TargetSpacewireAddress
     * This represents the buffer: targetSpacewireAddress
     * Description: Target SpaceWire Address
     */
    public static class TargetSpacewireAddress extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public TargetSpacewireAddress(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS TargetSpacewireAddress

    /**
     * Class TargetLogicalAddress
     * This represents the parameter: targetLogicalAddress
     * Description: Target Logical Address (8 bits)
     */
    public static class TargetLogicalAddress extends Parameter
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
        public TargetLogicalAddress(String name, Container parent)
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
    
    } // END OF CLASS TargetLogicalAddress

    /**
     * Class ProtocolIdentifier
     * This represents the parameter: protocolIdentifier
     * Description: Protocol Identifier (8 bits)
     */
    public static class ProtocolIdentifier extends Parameter
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
        public ProtocolIdentifier(String name, Container parent)
        {
            super(name, parent);
    
            // set default value
            this.set(0x2);
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
    
    } // END OF CLASS ProtocolIdentifier

    /**
     * Class Reserved
     * This represents the parameter: reserved
     * Description: Reserved (8 bits)
     */
    public static class Reserved extends Parameter
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
        public Reserved(String name, Container parent)
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
    
    } // END OF CLASS Reserved

    /**
     * Class UserApplication
     * This represents the parameter: userApplication
     * Description: User Application (8 bits)
     */
    public static class UserApplication extends Parameter
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
        public UserApplication(String name, Container parent)
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
    
    } // END OF CLASS UserApplication

    /**
     * Class CcsdsPacket
     * This represents the buffer: ccsdsPacket
     * Description: CCSDS Packet
     */
    public static class CcsdsPacket extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public CcsdsPacket(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS CcsdsPacket

    // --- BEGIN FIELDS ---

    /**
     * field targetSpacewireAddress
     * Description: Target SpaceWire Address
     */
    TargetSpacewireAddress targetSpacewireAddress;

    /**
     * field targetLogicalAddress
     * Description: Target Logical Address (8 bits)
     */
    TargetLogicalAddress targetLogicalAddress;

    /**
     * field protocolIdentifier
     * Description: Protocol Identifier (8 bits)
     */
    ProtocolIdentifier protocolIdentifier;

    /**
     * field reserved
     * Description: Reserved (8 bits)
     */
    Reserved reserved;

    /**
     * field userApplication
     * Description: User Application (8 bits)
     */
    UserApplication userApplication;

    /**
     * field ccsdsPacket
     * Description: CCSDS Packet
     */
    CcsdsPacket ccsdsPacket;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public SpwCcsdsPacket(String name, Container parent)
    {
        super(name, parent);
        this.targetSpacewireAddress = new TargetSpacewireAddress("targetSpacewireAddress", this);
        this.targetLogicalAddress = new TargetLogicalAddress("targetLogicalAddress", this);
        this.protocolIdentifier = new ProtocolIdentifier("protocolIdentifier", this);
        this.reserved = new Reserved("reserved", this);
        this.userApplication = new UserApplication("userApplication", this);
        this.ccsdsPacket = new CcsdsPacket("ccsdsPacket", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of buffer targetSpacewireAddress
     * @return buffer
     */
    public TargetSpacewireAddress get_targetSpacewireAddress()
    {
        return this.targetSpacewireAddress;
    }

    /**
     * Get value of parameter targetLogicalAddress
     * @return value of parameter
     */
    public long get_targetLogicalAddress()
    {
        return this.targetLogicalAddress.get();
    }

    /**
     * Set value of parameter targetLogicalAddress
     * @param value new value
     */
    public void set_targetLogicalAddress(long value)
    {
        this.targetLogicalAddress.set(value);
    }

    /**
     * Get value of parameter protocolIdentifier
     * @return value of parameter
     */
    public long get_protocolIdentifier()
    {
        return this.protocolIdentifier.get();
    }

    /**
     * Set value of parameter protocolIdentifier
     * @param value new value
     */
    public void set_protocolIdentifier(long value)
    {
        this.protocolIdentifier.set(value);
    }

    /**
     * Get value of parameter reserved
     * @return value of parameter
     */
    public long get_reserved()
    {
        return this.reserved.get();
    }

    /**
     * Set value of parameter reserved
     * @param value new value
     */
    public void set_reserved(long value)
    {
        this.reserved.set(value);
    }

    /**
     * Get value of parameter userApplication
     * @return value of parameter
     */
    public long get_userApplication()
    {
        return this.userApplication.get();
    }

    /**
     * Set value of parameter userApplication
     * @param value new value
     */
    public void set_userApplication(long value)
    {
        this.userApplication.set(value);
    }

    /**
     * Get value of buffer ccsdsPacket
     * @return buffer
     */
    public CcsdsPacket get_ccsdsPacket()
    {
        return this.ccsdsPacket;
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS SpwCcsdsPacket

