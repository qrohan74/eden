package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsTcFramePrimaryHeader
 * This represents the container: CcsdsTcFramePrimaryHeader
 * Description: TC transfer frame (CCSDS 232.0-B-4) - Transfer Frame Header (5 octets, mandatory)
 */
public class CcsdsTcFramePrimaryHeader extends Container
{
    /**
     * Class FrameVersionNumber
     * This represents the parameter: frameVersionNumber
     * Description: Transfer, Frame Version Number (2 bits, mandatory)
     */
    public static class FrameVersionNumber extends Parameter
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
        public FrameVersionNumber(String name, Container parent)
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
    
    } // END OF CLASS FrameVersionNumber

    /**
     * Class BypassFlag
     * This represents the parameter: bypassFlag
     * Description: Bypass Flag (1 bit, mandatory)
     */
    public static class BypassFlag extends Parameter
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
        public BypassFlag(String name, Container parent)
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
    
    } // END OF CLASS BypassFlag

    /**
     * Class ControlCommandFlag
     * This represents the parameter: controlCommandFlag
     * Description: Control Command Flag (1 bit, mandatory)
     */
    public static class ControlCommandFlag extends Parameter
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
        public ControlCommandFlag(String name, Container parent)
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
    
    } // END OF CLASS ControlCommandFlag

    /**
     * Class Spare
     * This represents the parameter: spare
     * Description: Reserved Spare (2 bits, mandatory)
     */
    public static class Spare extends Parameter
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
        public Spare(String name, Container parent)
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
    
    } // END OF CLASS Spare

    /**
     * Class SpacecraftId
     * This represents the parameter: spacecraftId
     * Description: Spacecraft Identifier (10 bits, mandatory)
     */
    public static class SpacecraftId extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 10;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public SpacecraftId(String name, Container parent)
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
    
    } // END OF CLASS SpacecraftId

    /**
     * Class VirtualChannelId
     * This represents the parameter: virtualChannelId
     * Description: Virtual Channel Identifier (6 bits, mandatory)
     */
    public static class VirtualChannelId extends Parameter
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
        public VirtualChannelId(String name, Container parent)
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
    
    } // END OF CLASS VirtualChannelId

    /**
     * Class FrameLength
     * This represents the parameter: frameLength
     * Description: Frame Length (10 bits, mandatory)
     */
    public static class FrameLength extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 10;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public FrameLength(String name, Container parent)
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
    
    } // END OF CLASS FrameLength

    /**
     * Class FrameSequenceNumber
     * This represents the parameter: frameSequenceNumber
     * Description: Frame Sequence Number (8 bits, mandatory)
     */
    public static class FrameSequenceNumber extends Parameter
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
        public FrameSequenceNumber(String name, Container parent)
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
    
    } // END OF CLASS FrameSequenceNumber

    // --- BEGIN FIELDS ---

    /**
     * field frameVersionNumber
     * Description: Transfer, Frame Version Number (2 bits, mandatory)
     */
    FrameVersionNumber frameVersionNumber;

    /**
     * field bypassFlag
     * Description: Bypass Flag (1 bit, mandatory)
     */
    BypassFlag bypassFlag;

    /**
     * field controlCommandFlag
     * Description: Control Command Flag (1 bit, mandatory)
     */
    ControlCommandFlag controlCommandFlag;

    /**
     * field spare
     * Description: Reserved Spare (2 bits, mandatory)
     */
    Spare spare;

    /**
     * field spacecraftId
     * Description: Spacecraft Identifier (10 bits, mandatory)
     */
    SpacecraftId spacecraftId;

    /**
     * field virtualChannelId
     * Description: Virtual Channel Identifier (6 bits, mandatory)
     */
    VirtualChannelId virtualChannelId;

    /**
     * field frameLength
     * Description: Frame Length (10 bits, mandatory)
     */
    FrameLength frameLength;

    /**
     * field frameSequenceNumber
     * Description: Frame Sequence Number (8 bits, mandatory)
     */
    FrameSequenceNumber frameSequenceNumber;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsTcFramePrimaryHeader(String name, Container parent)
    {
        super(name, parent);
        this.frameVersionNumber = new FrameVersionNumber("frameVersionNumber", this);
        this.bypassFlag = new BypassFlag("bypassFlag", this);
        this.controlCommandFlag = new ControlCommandFlag("controlCommandFlag", this);
        this.spare = new Spare("spare", this);
        this.spacecraftId = new SpacecraftId("spacecraftId", this);
        this.virtualChannelId = new VirtualChannelId("virtualChannelId", this);
        this.frameLength = new FrameLength("frameLength", this);
        this.frameSequenceNumber = new FrameSequenceNumber("frameSequenceNumber", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of parameter frameVersionNumber
     * @return value of parameter
     */
    public long get_frameVersionNumber()
    {
        return this.frameVersionNumber.get();
    }

    /**
     * Set value of parameter frameVersionNumber
     * @param value new value
     */
    public void set_frameVersionNumber(long value)
    {
        this.frameVersionNumber.set(value);
    }

    /**
     * Get value of parameter bypassFlag
     * @return value of parameter
     */
    public long get_bypassFlag()
    {
        return this.bypassFlag.get();
    }

    /**
     * Set value of parameter bypassFlag
     * @param value new value
     */
    public void set_bypassFlag(long value)
    {
        this.bypassFlag.set(value);
    }

    /**
     * Get value of parameter controlCommandFlag
     * @return value of parameter
     */
    public long get_controlCommandFlag()
    {
        return this.controlCommandFlag.get();
    }

    /**
     * Set value of parameter controlCommandFlag
     * @param value new value
     */
    public void set_controlCommandFlag(long value)
    {
        this.controlCommandFlag.set(value);
    }

    /**
     * Get value of parameter spare
     * @return value of parameter
     */
    public long get_spare()
    {
        return this.spare.get();
    }

    /**
     * Set value of parameter spare
     * @param value new value
     */
    public void set_spare(long value)
    {
        this.spare.set(value);
    }

    /**
     * Get value of parameter spacecraftId
     * @return value of parameter
     */
    public long get_spacecraftId()
    {
        return this.spacecraftId.get();
    }

    /**
     * Set value of parameter spacecraftId
     * @param value new value
     */
    public void set_spacecraftId(long value)
    {
        this.spacecraftId.set(value);
    }

    /**
     * Get value of parameter virtualChannelId
     * @return value of parameter
     */
    public long get_virtualChannelId()
    {
        return this.virtualChannelId.get();
    }

    /**
     * Set value of parameter virtualChannelId
     * @param value new value
     */
    public void set_virtualChannelId(long value)
    {
        this.virtualChannelId.set(value);
    }

    /**
     * Get value of parameter frameLength
     * @return value of parameter
     */
    public long get_frameLength()
    {
        return this.frameLength.get();
    }

    /**
     * Set value of parameter frameLength
     * @param value new value
     */
    public void set_frameLength(long value)
    {
        this.frameLength.set(value);
    }

    /**
     * Get value of parameter frameSequenceNumber
     * @return value of parameter
     */
    public long get_frameSequenceNumber()
    {
        return this.frameSequenceNumber.get();
    }

    /**
     * Set value of parameter frameSequenceNumber
     * @param value new value
     */
    public void set_frameSequenceNumber(long value)
    {
        this.frameSequenceNumber.set(value);
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsTcFramePrimaryHeader

