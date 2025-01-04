package qrohan.eden.com.ccsds;

import qrohan.eden.core.stream.*;

/**
 * Class CcsdsSecurityTrailer
 * This represents the container: CcsdsSecurityTrailer
 * Description: Space Data Link Security Protocol (CCSDS 355.0-B-2) - Security Trailer
 */
public class CcsdsSecurityTrailer extends Container
{
    /**
     * Class MessageAuthenticationCode
     * This represents the buffer: messageAuthenticationCode
     * Description: Message Authentication Code (i.e. MAC; Optional)
     */
    public static class MessageAuthenticationCode extends Buffer
    {
        // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---
    
        /**
         * Default constructor
         * @param name field name
         * @param parent parent container holding this field
         */
        public MessageAuthenticationCode(String name, Container parent)
        {
            super(name, parent);
        }
    
        // --- END CONSTRUCTORS/DESTRUCTORS ---
    
        // --- BEGIN ABSTRACT FIELD METHODS ---
    
        // --- END ABSTRACT FIELD METHODS ---
    
    } // END OF CLASS MessageAuthenticationCode

    // --- BEGIN FIELDS ---

    /**
     * field messageAuthenticationCode
     * Description: Message Authentication Code (i.e. MAC; Optional)
     */
    MessageAuthenticationCode messageAuthenticationCode;


    // --- END FIELDS ---

    // --- BEGIN CONSTRUCTORS/DESTRUCTORS ---

    /**
     * Default constructor
     * @param name field name
     * @param parent parent container holding this field
     */
    public CcsdsSecurityTrailer(String name, Container parent)
    {
        super(name, parent);
        this.messageAuthenticationCode = new MessageAuthenticationCode("messageAuthenticationCode", this);

    }

    // --- END CONSTRUCTORS/DESTRUCTORS ---

    // --- BEGIN FIELDS METHODS ---

    /**
     * Get value of buffer messageAuthenticationCode
     * @return buffer
     */
    public MessageAuthenticationCode get_messageAuthenticationCode()
    {
        return this.messageAuthenticationCode;
    }

    // --- END FIELDS METHODS ---
} // END OF CLASS CcsdsSecurityTrailer

