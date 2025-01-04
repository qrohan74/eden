package qrohan.eden.com.spacewire;

import qrohan.eden.core.stream.*;

/**
 * Class SpwRmapWriteCommand
 * This represents the container: SpwRmapWriteCommand
 * Description: Remote memory access protocol (ECSS-E-ST-50-52C) - Write Command
 */
public class SpwRmapWriteCommand extends Container
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
            this.set(0x1);
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
     * Class Instruction
     * This represents the container: instruction
     * Description: Instruction (8 bits)
     */
    public static class Instruction extends Container
    {
        /**
         * Class PacketType
         * This represents the parameter: packetType
         * Description: Packet Type (2 bits)
         */
        public static class PacketType extends Parameter
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
            public PacketType(String name, Container parent)
            {
                super(name, parent);
        
                // set default value
                this.set(1);
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
         * Class Command
         * This represents the container: command
         * Description: Command type (4 bits)
         */
        public static class Command extends Container
        {
            /**
             * Class WriteRead
             * This represents the parameter: writeRead
             * Description: Write (1) / Read (0) (1 bit)
             */
            public static class WriteRead extends Parameter
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
                public WriteRead(String name, Container parent)
                {
                    super(name, parent);
            
                    // set default value
                    this.set(1);
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
            
            } // END OF CLASS WriteRead

            /**
             * Class Verify
             * This represents the parameter: verify
             * Description: Verify data, i.e. verify data before write (1) / Don’t Verify (0) (1 bit)
             */
            public static class Verify extends Parameter
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
                public Verify(String name, Container parent)
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
            
            } // END OF CLASS Verify

            /**
             * Class Reply
             * This represents the parameter: reply
             * Description: Reply (1) / No reply (0) (1 bit)
             */
            public static class Reply extends Parameter
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
                public Reply(String name, Container parent)
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
            
            } // END OF CLASS Reply

            /**
             * Class Increment
             * This represents the parameter: increment
             * Description: Increment address (1) / No inc (0) (1 bit)
             */
            public static class Increment extends Parameter
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
                public Increment(String name, Container parent)
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
            
            } // END OF CLASS Increment

            // --- BEGIN FIELDS ---
        
            /**
             * field writeRead
             * Description: Write (1) / Read (0) (1 bit)
             */
            WriteRead writeRead;
        
            /**
             * field verify
             * Description: Verify data, i.e. verify data before write (1) / Don’t Verify (0) (1 bit)
             */
            Verify verify;
        
            /**
             * field reply
             * Description: Reply (1) / No reply (0) (1 bit)
             */
            Reply reply;
        
            /**
             * field increment
             * Description: Increment address (1) / No inc (0) (1 bit)
             */
            Increment increment;
        
        
            // --- END FIELDS ---
        
            // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
        
            /**
             * Default constructor
             * @param name field name
             * @param parent parent container holding this field
             */
            public Command(String name, Container parent)
            {
                super(name, parent);
                this.writeRead = new WriteRead("writeRead", this);
                this.verify = new Verify("verify", this);
                this.reply = new Reply("reply", this);
                this.increment = new Increment("increment", this);
        
            }
        
            // --- END CONSTRUCTORS/DESTRUCTORS ---
        
            // --- BEGIN FIELDS METHODS ---
        
            /**
             * Get value of parameter writeRead
             * @return value of parameter
             */
            public long get_writeRead()
            {
                return this.writeRead.get();
            }
        
            /**
             * Set value of parameter writeRead
             * @param value new value
             */
            public void set_writeRead(long value)
            {
                this.writeRead.set(value);
            }
        
            /**
             * Get value of parameter verify
             * @return value of parameter
             */
            public long get_verify()
            {
                return this.verify.get();
            }
        
            /**
             * Set value of parameter verify
             * @param value new value
             */
            public void set_verify(long value)
            {
                this.verify.set(value);
            }
        
            /**
             * Get value of parameter reply
             * @return value of parameter
             */
            public long get_reply()
            {
                return this.reply.get();
            }
        
            /**
             * Set value of parameter reply
             * @param value new value
             */
            public void set_reply(long value)
            {
                this.reply.set(value);
            }
        
            /**
             * Get value of parameter increment
             * @return value of parameter
             */
            public long get_increment()
            {
                return this.increment.get();
            }
        
            /**
             * Set value of parameter increment
             * @param value new value
             */
            public void set_increment(long value)
            {
                this.increment.set(value);
            }
        
            // --- END FIELDS METHODS ---
        } // END OF CLASS Command

        /**
         * Class ReplyAddressLength
         * This represents the parameter: replyAddressLength
         * Description: Reply Address Length (0b00 = 0 byte, 0b01 = 4 bytes, 0b10 = 8 bytes, 0b11 = 12 bytes) (2 bits)
         */
        public static class ReplyAddressLength extends Parameter
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
            public ReplyAddressLength(String name, Container parent)
            {
                super(name, parent);
        
                // set default value
                this.set(1);
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
        
        } // END OF CLASS ReplyAddressLength

        // --- BEGIN FIELDS ---
    
        /**
         * field packetType
         * Description: Packet Type (2 bits)
         */
        PacketType packetType;
    
        /**
         * field command
         * Description: Command type (4 bits)
         */
        Command command;
    
        /**
         * field replyAddressLength
         * Description: Reply Address Length (0b00 = 0 byte, 0b01 = 4 bytes, 0b10 = 8 bytes, 0b11 = 12 bytes) (2 bits)
         */
        ReplyAddressLength replyAddressLength;
    
    
        // --- END FIELDS ---
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Instruction(String name, Container parent)
        {
            super(name, parent);
            this.packetType = new PacketType("packetType", this);
            this.command = new Command("command", this);
            this.replyAddressLength = new ReplyAddressLength("replyAddressLength", this);
    
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
         * Get value of container command
         * @return container
         */
        public Command get_command()
        {
            return this.command;
        }
    
        /**
         * Get value of parameter replyAddressLength
         * @return value of parameter
         */
        public long get_replyAddressLength()
        {
            return this.replyAddressLength.get();
        }
    
        /**
         * Set value of parameter replyAddressLength
         * @param value new value
         */
        public void set_replyAddressLength(long value)
        {
            this.replyAddressLength.set(value);
        }
    
        // --- END FIELDS METHODS ---
    } // END OF CLASS Instruction

    /**
     * Class Key
     * This represents the parameter: key
     * Description: Key (8 bits)
     */
    public static class Key extends Parameter
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
        public Key(String name, Container parent)
        {
            super(name, parent);
    
            // set default value
            this.set(0x1);
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
    
    } // END OF CLASS Key

    /**
     * Class ReplyAddress
     * This represents the buffer: replyAddress
     * Description: Reply Address (0, 4, 8 or 12‐bytes)
     */
    public static class ReplyAddress extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public ReplyAddress(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS ReplyAddress

    /**
     * Class InitiatorLogicalAddress
     * This represents the parameter: initiatorLogicalAddress
     * Description: Initiator Logical Address (8 bits)
     */
    public static class InitiatorLogicalAddress extends Parameter
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
        public InitiatorLogicalAddress(String name, Container parent)
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
    
    } // END OF CLASS InitiatorLogicalAddress

    /**
     * Class TransactionIdentifier
     * This represents the parameter: transactionIdentifier
     * Description: Transaction Identifier (MSB first) (16 bits)
     */
    public static class TransactionIdentifier extends Parameter
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
        public TransactionIdentifier(String name, Container parent)
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
    
    } // END OF CLASS TransactionIdentifier

    /**
     * Class ExtendedAddress
     * This represents the parameter: extendedAddress
     * Description: Extended Address (8 bits)
     */
    public static class ExtendedAddress extends Parameter
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
        public ExtendedAddress(String name, Container parent)
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
    
    } // END OF CLASS ExtendedAddress

    /**
     * Class Address
     * This represents the parameter: address
     * Description: Address (least‐significant 32‐bits of the memory address) (32 bits)
     */
    public static class Address extends Parameter
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
        public Address(String name, Container parent)
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
    
    } // END OF CLASS Address

    /**
     * Class DataLength
     * This represents the parameter: dataLength
     * Description: Data Length (length in bytes of the data field, MSB first) (24 bits)
     */
    public static class DataLength extends Parameter
    {
        /**
         * parameter length (in bits)
         */
        public static final int length = 24;
    
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public DataLength(String name, Container parent)
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
    
    } // END OF CLASS DataLength

    /**
     * Class HeaderCrc
     * This represents the parameter: headerCrc
     * Description: Header CRC (8 bits)
     */
    public static class HeaderCrc extends Parameter
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
        public HeaderCrc(String name, Container parent)
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
    
    } // END OF CLASS HeaderCrc

    /**
     * Class Data
     * This represents the buffer: data
     * Description: Data field
     */
    public static class Data extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public Data(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS Data

    /**
     * Class DataCrc
     * This represents the parameter: dataCrc
     * Description: Data CRC (8 bits)
     */
    public static class DataCrc extends Parameter
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
        public DataCrc(String name, Container parent)
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
    
    } // END OF CLASS DataCrc

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
     * field instruction
     * Description: Instruction (8 bits)
     */
    Instruction instruction;

    /**
     * field key
     * Description: Key (8 bits)
     */
    Key key;

    /**
     * field replyAddress
     * Description: Reply Address (0, 4, 8 or 12‐bytes)
     */
    ReplyAddress replyAddress;

    /**
     * field initiatorLogicalAddress
     * Description: Initiator Logical Address (8 bits)
     */
    InitiatorLogicalAddress initiatorLogicalAddress;

    /**
     * field transactionIdentifier
     * Description: Transaction Identifier (MSB first) (16 bits)
     */
    TransactionIdentifier transactionIdentifier;

    /**
     * field extendedAddress
     * Description: Extended Address (8 bits)
     */
    ExtendedAddress extendedAddress;

    /**
     * field address
     * Description: Address (least‐significant 32‐bits of the memory address) (32 bits)
     */
    Address address;

    /**
     * field dataLength
     * Description: Data Length (length in bytes of the data field, MSB first) (24 bits)
     */
    DataLength dataLength;

    /**
     * field headerCrc
     * Description: Header CRC (8 bits)
     */
    HeaderCrc headerCrc;

    /**
     * field data
     * Description: Data field
     */
    Data data;

    /**
     * field dataCrc
     * Description: Data CRC (8 bits)
     */
    DataCrc dataCrc;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public SpwRmapWriteCommand(String name, Container parent)
    {
        super(name, parent);
        this.targetSpacewireAddress = new TargetSpacewireAddress("targetSpacewireAddress", this);
        this.targetLogicalAddress = new TargetLogicalAddress("targetLogicalAddress", this);
        this.protocolIdentifier = new ProtocolIdentifier("protocolIdentifier", this);
        this.instruction = new Instruction("instruction", this);
        this.key = new Key("key", this);
        this.replyAddress = new ReplyAddress("replyAddress", this);
        this.initiatorLogicalAddress = new InitiatorLogicalAddress("initiatorLogicalAddress", this);
        this.transactionIdentifier = new TransactionIdentifier("transactionIdentifier", this);
        this.extendedAddress = new ExtendedAddress("extendedAddress", this);
        this.address = new Address("address", this);
        this.dataLength = new DataLength("dataLength", this);
        this.headerCrc = new HeaderCrc("headerCrc", this);
        this.data = new Data("data", this);
        this.dataCrc = new DataCrc("dataCrc", this);

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
     * Get value of container instruction
     * @return container
     */
    public Instruction get_instruction()
    {
        return this.instruction;
    }

    /**
     * Get value of parameter key
     * @return value of parameter
     */
    public long get_key()
    {
        return this.key.get();
    }

    /**
     * Set value of parameter key
     * @param value new value
     */
    public void set_key(long value)
    {
        this.key.set(value);
    }

    /**
     * Get value of buffer replyAddress
     * @return buffer
     */
    public ReplyAddress get_replyAddress()
    {
        return this.replyAddress;
    }

    /**
     * Get value of parameter initiatorLogicalAddress
     * @return value of parameter
     */
    public long get_initiatorLogicalAddress()
    {
        return this.initiatorLogicalAddress.get();
    }

    /**
     * Set value of parameter initiatorLogicalAddress
     * @param value new value
     */
    public void set_initiatorLogicalAddress(long value)
    {
        this.initiatorLogicalAddress.set(value);
    }

    /**
     * Get value of parameter transactionIdentifier
     * @return value of parameter
     */
    public long get_transactionIdentifier()
    {
        return this.transactionIdentifier.get();
    }

    /**
     * Set value of parameter transactionIdentifier
     * @param value new value
     */
    public void set_transactionIdentifier(long value)
    {
        this.transactionIdentifier.set(value);
    }

    /**
     * Get value of parameter extendedAddress
     * @return value of parameter
     */
    public long get_extendedAddress()
    {
        return this.extendedAddress.get();
    }

    /**
     * Set value of parameter extendedAddress
     * @param value new value
     */
    public void set_extendedAddress(long value)
    {
        this.extendedAddress.set(value);
    }

    /**
     * Get value of parameter address
     * @return value of parameter
     */
    public long get_address()
    {
        return this.address.get();
    }

    /**
     * Set value of parameter address
     * @param value new value
     */
    public void set_address(long value)
    {
        this.address.set(value);
    }

    /**
     * Get value of parameter dataLength
     * @return value of parameter
     */
    public long get_dataLength()
    {
        return this.dataLength.get();
    }

    /**
     * Set value of parameter dataLength
     * @param value new value
     */
    public void set_dataLength(long value)
    {
        this.dataLength.set(value);
    }

    /**
     * Get value of parameter headerCrc
     * @return value of parameter
     */
    public long get_headerCrc()
    {
        return this.headerCrc.get();
    }

    /**
     * Set value of parameter headerCrc
     * @param value new value
     */
    public void set_headerCrc(long value)
    {
        this.headerCrc.set(value);
    }

    /**
     * Get value of buffer data
     * @return buffer
     */
    public Data get_data()
    {
        return this.data;
    }

    /**
     * Get value of parameter dataCrc
     * @return value of parameter
     */
    public long get_dataCrc()
    {
        return this.dataCrc.get();
    }

    /**
     * Set value of parameter dataCrc
     * @param value new value
     */
    public void set_dataCrc(long value)
    {
        this.dataCrc.set(value);
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS SpwRmapWriteCommand

