package qrohan.eden.core.serdes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SerializatorTest
{
    private Serializator serializator;

    @BeforeEach
    public void init()
    {
        serializator = new Serializator();
    }

    @AfterEach
    public void terminate()
    {
        serializator.reset();
    }

    @Nested
    @Tag("SerializeByte")
    @DisplayName("Serialize byte")
    class SerializeByteTest
    {
        @Test
        @DisplayName("Serialize a simple series of full bytes")
        void test_write_byte_simple()
        {
            for (int i = 0; i < 256; ++i){
                serializator.write((byte)i, 8);
            }

            byte[] res = serializator.toByteArray();
            assertEquals(256, res.length);
            for (int i = 0; i < 256; ++i) {
                assertEquals((byte)i, res[i]);
            }
        }

        @Test
        @DisplayName("Serialize some bytes with different lengths")
        void test_write_byte_offset()
        {
            for (int i = 0; i <= 8; ++i) {
                serializator.reset();
                serializator.write((byte)0xFF, 8);
                serializator.write((byte)0x00, i);

                byte[] res = serializator.toByteArray();

                if (i==0) {
                    assertEquals(1, res.length);
                    assertEquals((byte)(0xFF), res[0]);
                } else {
                    assertEquals(2, res.length);
                    assertEquals((byte)(0xFF >> (8-i)), res[0]);
                    assertEquals((byte)(0xFF << i), res[1]);
                }
            }
        }

        @Test
        @DisplayName("Serialize a more complex serialization of bytes")
        void test_write_byte_string()
        {
            serializator.write((byte)0x07, 2); // '11'
            serializator.write((byte)0x02, 3); // '010'
            serializator.write((byte)0x9C, 6); // '011100'
            serializator.write((byte)0x81, 8); // '10000001'
            serializator.write((byte)0x0A, 1); // '0'
            serializator.write((byte)0x76, 5); // '10110'

            assertEquals("1101001110010000001010110", serializator.getData()); // '11'+'010'+'011100'+'10000001'+'0'+'10110'
        }
    }

    @Nested
    @Tag("SerializeShort")
    @DisplayName("Serialize short")
    class SerializeShortTest
    {
        @Test
        @DisplayName("Serialize a simple series of full shorts")
        void test_write_short_simple() {
            for (int i = 0; i < 256; ++i) {
                serializator.write((short)(i*255), 16);
            }

            byte[] res = serializator.toByteArray();
            assertEquals(512, res.length);
            for (int i = 0; i < 256; ++i) {
                assertEquals((byte)(((i*255) >> 8) & 0xFF), res[2 * i]);
                assertEquals((byte)(((i * 255)) & 0xFF), res[2*i+1]);
            }
        }

        @Test
        @DisplayName("Serialize some shorts with different lengths")
        void test_write_short_offset()
        {
            /* test insertion '1111111111111111' */
            serializator.reset();
            serializator.write((short)0xFFFF, 16);
            serializator.write((short)0x0000, 0);

            byte[] res = serializator.toByteArray();

            assertEquals(2, res.length);
            assertEquals((byte)(0xFF), res[0]);
            assertEquals((byte)(0xFF), res[1]);

            /* test insertion '11111111111111110' */
            serializator.reset();
            serializator.write((short)0xFFFF, 16);
            serializator.write((short)0x0000, 1);

            res = serializator.toByteArray();

            assertEquals(3, res.length);
            assertEquals((byte)(0x01), res[0]);
            assertEquals((byte)(0xFF), res[1]);
            assertEquals((byte)(0xFE), res[2]);

            /* test insertion '1111111111111111000000' */
            serializator.reset();
            serializator.write((short)0xFFFF, 16);
            serializator.write((short)0x0000, 6);

            res = serializator.toByteArray();

            assertEquals(3, res.length);
            assertEquals((byte)(0x3F), res[0]);
            assertEquals((byte)(0xFF), res[1]);
            assertEquals((byte)(0xC0), res[2]);

            /* test insertion '1111111111111111000000000000000' */
            serializator.reset();
            serializator.write((short)0xFFFF, 16);
            serializator.write((short)0x0000, 15);

            res = serializator.toByteArray();

            assertEquals(4, res.length);
            assertEquals((byte)(0x7F), res[0]);
            assertEquals((byte)(0xFF), res[1]);
            assertEquals((byte)(0x80), res[2]);
            assertEquals((byte)(0x00), res[3]);

            /* test insertion '11111111111111110000000000000000' */
            serializator.reset();
            serializator.write((short)0xFFFF, 16);
            serializator.write((short)0x0000, 16);

            res = serializator.toByteArray();

            assertEquals(4, res.length);
            assertEquals((byte)(0xFF), res[0]);
            assertEquals((byte)(0xFF), res[1]);
            assertEquals((byte)(0x00), res[2]);
            assertEquals((byte)(0x00), res[3]);
        }

        @Test
        @DisplayName("Serialize a more complex serialization of shorts")
        void test_write_short_string()
        {
            serializator.write((short)0x1234, 10); // '1000110100'
            serializator.write((short)0xABCD, 3); // '101'
            serializator.write((short)0x8888, 6); // '001000'
            serializator.write((short)0x3C3C, 8); // '00111100'
            serializator.write((short)0xCAFE, 15); // '100101011111110'

            assertEquals("100011010010100100000111100100101011111110", serializator.getData()); // '1000110100'+'101'+'001000'+'00111100' + 100101011111110'
        }
    }

    @Nested
    @Tag("SerializeInt")
    @DisplayName("Serialize integer")
    class SerializeIntTest
    {
        @Test
        @DisplayName("Serialize a simple series of full integers")
        void test_write_int_simple() {
            serializator.write(0xCAFEDECAL, 32);
            serializator.write(0xFADAC0DEL, 32);

            byte[] res = serializator.toByteArray();
            assertEquals(8, res.length);

            assertEquals((byte)0xCA, res[0]);
            assertEquals((byte)0xFE, res[1]);
            assertEquals((byte)0xDE, res[2]);
            assertEquals((byte)0xCA, res[3]);
            assertEquals((byte)0xFA, res[4]);
            assertEquals((byte)0xDA, res[5]);
            assertEquals((byte)0xC0, res[6]);
            assertEquals((byte)0xDE, res[7]);
        }

        @Test
        @DisplayName("Serialize some integers with different lengths")
        void test_write_int_offset()
        {
            serializator.reset();
            serializator.write(0xFFFFFFFFL, 32);
            serializator.write(0x00000000L, 1);

            byte[] res = serializator.toByteArray();

            assertEquals(5, res.length);
            assertEquals((byte)0x01, res[0]);
            assertEquals((byte)0xFF, res[1]);
            assertEquals((byte)0xFF, res[2]);
            assertEquals((byte)0xFF, res[3]);
            assertEquals((byte)0xFE, res[4]);

            serializator.reset();
            serializator.write(0xFFFFFFFFL, 32);
            serializator.write(0x00000000L, 15);

            res = serializator.toByteArray();

            assertEquals(6, res.length);
            assertEquals((byte)0x7F, res[0]);
            assertEquals((byte)0xFF, res[1]);
            assertEquals((byte)0xFF, res[2]);
            assertEquals((byte)0xFF, res[3]);
            assertEquals((byte)0x80, res[4]);
            assertEquals((byte)0x00, res[5]);

            serializator.reset();
            serializator.write(0xFFFFFFFFL, 32);
            serializator.write(0x00000000L, 28);

            res = serializator.toByteArray();

            assertEquals(8, res.length);
            assertEquals((byte)0x0F, res[0]);
            assertEquals((byte)0xFF, res[1]);
            assertEquals((byte)0xFF, res[2]);
            assertEquals((byte)0xFF, res[3]);
            assertEquals((byte)0xF0, res[4]);
            assertEquals((byte)0x00, res[5]);
            assertEquals((byte)0x00, res[6]);
            assertEquals((byte)0x00, res[7]);
        }
    }
}
