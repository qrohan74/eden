package qrohan.eden.core.serdes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeserializatorTest
{
	private Deserializator deserializator;

	@BeforeEach
	public void init()
	{
		deserializator = new Deserializator();
	}

	@AfterEach
	public void terminate()
	{
		deserializator.reset();
	}

	@Nested
	@Tag("DeserializeBytes")
	@DisplayName("Deserialize bytes")
	class SerializeByteTest
	{
		@Test
		@DisplayName("Deserialize a simple series of full bytes")
		void test_read_byte_array()
		{
			deserializator.feed(new byte[] {(byte)0xA1, (byte)0xB2, (byte)0xC3, (byte)0xD4, (byte)0xE5, (byte)0xF6});

			long element;
			element = deserializator.read(8);
			assertEquals(0xA1, element);
			element = deserializator.read(8);
			assertEquals(0xB2, element);
			element = deserializator.read(8);
			assertEquals(0xC3, element);
			element = deserializator.read(8);
			assertEquals(0xD4, element);
			element = deserializator.read(8);
			assertEquals(0xE5, element);
			element = deserializator.read(8);
			assertEquals(0xF6, element);

			// no more data to read
			assertEquals("", deserializator.toString());
		}

		@Test
		@DisplayName("Deserialize a simple series of full bytes 2")
		void test_read_byte_array2()
		{
			deserializator.feed(new byte[] {(byte)0xA1, (byte)0xB2, (byte)0xC3});

			long element;
			element = deserializator.read(4);
			assertEquals(0xA, element);
			element = deserializator.read(4);
			assertEquals(0x1, element);
			element = deserializator.read(4);
			assertEquals(0xB, element);
			element = deserializator.read(4);
			assertEquals(0x2, element);

			// remaining data
			assertEquals("C3", deserializator.toString());
		}

		@Nested
		@Tag("DeserializeString")
		@DisplayName("Deserialize string")
		class SerializeStringTest
		{
			@Test
			@DisplayName("Deserialize a binary string")
			void test_read_binary_string()
			{
				deserializator.feed("10100001101100101100001111010100111001011111011001111000100100000001001000110100", 2); // A1B2C3D4E5F678901234

				long element;
				element = deserializator.read(8);
				assertEquals(0xA1, element);
				element = deserializator.read(8);
				assertEquals(0xB2, element);
				element = deserializator.read(8);
				assertEquals(0xC3, element);
				element = deserializator.read(8);
				assertEquals(0xD4, element);
				element = deserializator.read(8);
				assertEquals(0xE5, element);
				element = deserializator.read(8);
				assertEquals(0xF6, element);
				element = deserializator.read(8);
				assertEquals(0x78, element);
				element = deserializator.read(8);
				assertEquals(0x90, element);
				element = deserializator.read(8);
				assertEquals(0x12, element);
				element = deserializator.read(8);
				assertEquals(0x34, element);

				// no more data to read
				assertEquals("", deserializator.toString());
			}

			@Test
			@DisplayName("Deserialize a hex string")
			void test_read_hex_string()
			{
				deserializator.feed("A1B2C3D4E5F678901234", 16);

				long element;
				element = deserializator.read(8);
				assertEquals(0xA1, element);
				element = deserializator.read(4);
				assertEquals(0xB, element);
				element = deserializator.read(8);
				assertEquals(0x2C, element);
				element = deserializator.read(4);
				assertEquals(0x3, element);
				element = deserializator.read(8);
				assertEquals(0xD4, element);
				element = deserializator.read(4);
				assertEquals(0xE, element);
				element = deserializator.read(8);
				assertEquals(0x5F, element);
				element = deserializator.read(4);
				assertEquals(0x6, element);

				// remaining data
				assertEquals("78 90 12 34", deserializator.toString());
			}

			@Test
			@DisplayName("Invalid string")
			void test_invalid_string()
			{
				deserializator.feed("A1B2C3D4", 16);
				assertEquals("A1 B2 C3 D4", deserializator.toString());
				deserializator.feed("12H4", 16);
				assertEquals("A1 B2 C3 D4", deserializator.toString());
				deserializator.feed("0101101011100120101", 2);
				assertEquals("A1 B2 C3 D4", deserializator.toString());
			}
		}
	}
}

