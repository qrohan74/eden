package qrohan.eden.core.misc;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest
{
    @BeforeEach
    public void init()
    {
    }

    @AfterEach
    public void terminate()
    {
    }

    @Nested
    @Tag("Utils")
    @DisplayName("Utils test")
    class UtilsCheck {
        @Test
        @DisplayName("Check utils")
        void test_utils() {
            byte[] data = new byte[]{(byte) 0x85, (byte) 0x74};
            assertEquals("1000010101110100", Utils.byteArrayToBinStr(data));

            data = new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xEF, (byte) 0x98, (byte) 0x76};
            assertEquals("AB CD EF 98 76", Utils.byteArrayToHexStr(data));

            String binStr = "0001001001000011";
            data = Utils.binStrToByteArray(binStr);
            assertEquals(2, data.length);
            assertEquals(0x12, data[0]);
            assertEquals(0x43, data[1]);

            assertEquals("12 43", Utils.binStrToHexStr(binStr));

            int i=0xCAFEDECA;
            assertEquals("11001010111111101101111011001010", Utils.intToBinStr(i));
            assertEquals("001010", Utils.intToBinStr(i, 6));

            long li=0x9876543287654321L;
            assertEquals("1001100001110110010101000011001010000111011001010100001100100001", Utils.longToBinStr(li));
            assertEquals("1010000111011001010100001100100001", Utils.longToBinStr(li, 34));
        }
    }
}
