package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsPacketDataField
 * This represents the container: CcsdsPacketDataField
 * Description: Space Packet Protocol (CCSDS 133.0-B-2) - Packet Data Field
 */
public class CcsdsPacketDataField extends Container
{
    /**
     * Class PacketSecondaryHeader
     * This represents the container: packetSecondaryHeader
     * Description: Packet Secondary Header
     */
    public static class PacketSecondaryHeader extends Container
    {
        /**
         * Class TimeCodeField
         * This represents the buffer: timeCodeField
         * Description: Time Code Field (variable length)
         */
        public static class TimeCodeField extends Buffer
        {
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public TimeCodeField(String name, Container parent)
            {
                super(name, parent);
            }
        
            // --- END CONSTRUCTORS/DESTRUCTORS ---
        
            // --- BEGIN ABSTRACT FIELD METHODS ---
        
            // --- END ABSTRACT FIELD METHODS ---
        
        } // END OF CLASS TimeCodeField

        /**
         * Class AncillaryDataField
         * This represents the buffer: ancillaryDataField
         * Description: Ancillary Data Field (variable length)
         */
        public static class AncillaryDataField extends Buffer
        {
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public AncillaryDataField(String name, Container parent)
            {
                super(name, parent);
            }
        
            // --- END CONSTRUCTORS/DESTRUCTORS ---
        
            // --- BEGIN ABSTRACT FIELD METHODS ---
        
            // --- END ABSTRACT FIELD METHODS ---
        
        } // END OF CLASS AncillaryDataField

        // --- BEGIN FIELDS ---
    
        /**
         * field timeCodeField
         * Description: Time Code Field (variable length)
         */
        TimeCodeField timeCodeField;
    
        /**
         * field ancillaryDataField
         * Description: Ancillary Data Field (variable length)
         */
        AncillaryDataField ancillaryDataField;
    
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public PacketSecondaryHeader(String name, Container parent)
        {
            super(name, parent);
            this.timeCodeField = new TimeCodeField("timeCodeField", this);
            this.ancillaryDataField = new AncillaryDataField("ancillaryDataField", this);
    
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN FIELDS METHODS ---
    
        /**
         * Get value of buffer timeCodeField
         * @return buffer
         */
        public TimeCodeField get_timeCodeField()
        {
            return this.timeCodeField;
        }
    
        /**
         * Get value of buffer ancillaryDataField
         * @return buffer
         */
        public AncillaryDataField get_ancillaryDataField()
        {
            return this.ancillaryDataField;
        }
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS PacketSecondaryHeader

    /**
     * Class UserDataField
     * This represents the buffer: userDataField
     * Description: User Data Field
     */
    public static class UserDataField extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public UserDataField(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS UserDataField

    // --- BEGIN FIELDS ---

    /**
     * field packetSecondaryHeader
     * Description: Packet Secondary Header
     */
    PacketSecondaryHeader packetSecondaryHeader;

    /**
     * field userDataField
     * Description: User Data Field
     */
    UserDataField userDataField;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsPacketDataField(String name, Container parent)
    {
        super(name, parent);
        this.packetSecondaryHeader = new PacketSecondaryHeader("packetSecondaryHeader", this);
        this.userDataField = new UserDataField("userDataField", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of container packetSecondaryHeader
     * @return container
     */
    public PacketSecondaryHeader get_packetSecondaryHeader()
    {
        return this.packetSecondaryHeader;
    }

    /**
     * Get value of buffer userDataField
     * @return buffer
     */
    public UserDataField get_userDataField()
    {
        return this.userDataField;
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsPacketDataField

