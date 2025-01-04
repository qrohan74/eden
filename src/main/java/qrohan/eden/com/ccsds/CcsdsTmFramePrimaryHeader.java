package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsTmFramePrimaryHeader
 * This represents the container: CcsdsTmFramePrimaryHeader
 * Description: TM transfer frame (CCSDS 132.0-B-3) - Transfer Frame Primary Header (6 octets)
 */
public class CcsdsTmFramePrimaryHeader extends Container
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
        public static final int length = 3;
    
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
     * Class OperationalControlFieldFlag
     * This represents the parameter: operationalControlFieldFlag
     * Description: Operational Control Field Flag (1 bit, mandatory)
     */
    public static class OperationalControlFieldFlag extends Parameter
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
        public OperationalControlFieldFlag(String name, Container parent)
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
    
    } // END OF CLASS OperationalControlFieldFlag

    /**
     * Class MasterChannelFrameCount
     * This represents the parameter: masterChannelFrameCount
     * Description: Master Channel Frame Count (1 octet, mandatory)
     */
    public static class MasterChannelFrameCount extends Parameter
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
        public MasterChannelFrameCount(String name, Container parent)
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
    
    } // END OF CLASS MasterChannelFrameCount

    /**
     * Class VirtualChannelFrameCount
     * This represents the parameter: virtualChannelFrameCount
     * Description: Virtual Channel Frame Count (1 octet, mandatory)
     */
    public static class VirtualChannelFrameCount extends Parameter
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
        public VirtualChannelFrameCount(String name, Container parent)
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
    
    } // END OF CLASS VirtualChannelFrameCount

    /**
     * Class TransferFrameDataFieldStatus
     * This represents the parameter: transferFrameDataFieldStatus
     * Description: Transfer Frame Data Field Status (2 octets, mandatory)
     */
    public static class TransferFrameDataFieldStatus extends Parameter
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
        public TransferFrameDataFieldStatus(String name, Container parent)
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
    
    } // END OF CLASS TransferFrameDataFieldStatus

    // --- BEGIN FIELDS ---

    /**
     * field frameVersionNumber
     * Description: Transfer, Frame Version Number (2 bits, mandatory)
     */
    FrameVersionNumber frameVersionNumber;

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
     * field operationalControlFieldFlag
     * Description: Operational Control Field Flag (1 bit, mandatory)
     */
    OperationalControlFieldFlag operationalControlFieldFlag;

    /**
     * field masterChannelFrameCount
     * Description: Master Channel Frame Count (1 octet, mandatory)
     */
    MasterChannelFrameCount masterChannelFrameCount;

    /**
     * field virtualChannelFrameCount
     * Description: Virtual Channel Frame Count (1 octet, mandatory)
     */
    VirtualChannelFrameCount virtualChannelFrameCount;

    /**
     * field transferFrameDataFieldStatus
     * Description: Transfer Frame Data Field Status (2 octets, mandatory)
     */
    TransferFrameDataFieldStatus transferFrameDataFieldStatus;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsTmFramePrimaryHeader(String name, Container parent)
    {
        super(name, parent);
        this.frameVersionNumber = new FrameVersionNumber("frameVersionNumber", this);
        this.spacecraftId = new SpacecraftId("spacecraftId", this);
        this.virtualChannelId = new VirtualChannelId("virtualChannelId", this);
        this.operationalControlFieldFlag = new OperationalControlFieldFlag("operationalControlFieldFlag", this);
        this.masterChannelFrameCount = new MasterChannelFrameCount("masterChannelFrameCount", this);
        this.virtualChannelFrameCount = new VirtualChannelFrameCount("virtualChannelFrameCount", this);
        this.transferFrameDataFieldStatus = new TransferFrameDataFieldStatus("transferFrameDataFieldStatus", this);

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
     * Get value of parameter operationalControlFieldFlag
     * @return value of parameter
     */
    public long get_operationalControlFieldFlag()
    {
        return this.operationalControlFieldFlag.get();
    }

    /**
     * Set value of parameter operationalControlFieldFlag
     * @param value new value
     */
    public void set_operationalControlFieldFlag(long value)
    {
        this.operationalControlFieldFlag.set(value);
    }

    /**
     * Get value of parameter masterChannelFrameCount
     * @return value of parameter
     */
    public long get_masterChannelFrameCount()
    {
        return this.masterChannelFrameCount.get();
    }

    /**
     * Set value of parameter masterChannelFrameCount
     * @param value new value
     */
    public void set_masterChannelFrameCount(long value)
    {
        this.masterChannelFrameCount.set(value);
    }

    /**
     * Get value of parameter virtualChannelFrameCount
     * @return value of parameter
     */
    public long get_virtualChannelFrameCount()
    {
        return this.virtualChannelFrameCount.get();
    }

    /**
     * Set value of parameter virtualChannelFrameCount
     * @param value new value
     */
    public void set_virtualChannelFrameCount(long value)
    {
        this.virtualChannelFrameCount.set(value);
    }

    /**
     * Get value of parameter transferFrameDataFieldStatus
     * @return value of parameter
     */
    public long get_transferFrameDataFieldStatus()
    {
        return this.transferFrameDataFieldStatus.get();
    }

    /**
     * Set value of parameter transferFrameDataFieldStatus
     * @param value new value
     */
    public void set_transferFrameDataFieldStatus(long value)
    {
        this.transferFrameDataFieldStatus.set(value);
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsTmFramePrimaryHeader

