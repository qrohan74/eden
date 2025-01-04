package qrohan.eden.core.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qrohan.eden.core.stream.example.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamTest {
	@BeforeEach
	public void init() {
		// nothing to do
	}

	@AfterEach
	public void terminate() {
		// nothing to do
	}

	@Test
	@DisplayName("Test example simple parameter")
	void test_simple_parameter() {
		// test instantiation
		SimpleParameter param = new SimpleParameter("example", null);

		assertEquals(32, param.getLength());

		// check encoding
		param.set(0x12345678);

		byte[] data = param.encode();
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x56, data[2]);
		assertEquals((byte) 0x78, data[3]);

		assertEquals("12 34 56 78", param.hex());

		// check decoding
		data = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xDE, (byte) 0xCA};

		param.decode(data);
		assertEquals(0xCAFEDECAL, param.get());

		assertEquals("CA FE DE CA", param.hex());
	}

	@Test
	@DisplayName("Test example simple container")
	void test_simple_container() {
		// test instantiation
		SimpleContainer container = new SimpleContainer("example", null);

		assertEquals(56, container.getLength());

		// check encoding
		container.set_param1(0x12);
		container.set_param2(0x3456);
		container.set_param3(0x7890ABCD);

		byte[] data = container.encode();
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x56, data[2]);
		assertEquals((byte) 0x78, data[3]);
		assertEquals((byte) 0x90, data[4]);
		assertEquals((byte) 0xAB, data[5]);
		assertEquals((byte) 0xCD, data[6]);

		assertEquals("12 34 56 78 90 AB CD", container.hex());

		// check decoding
		data = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xDE, (byte) 0xCA, (byte) 0xFA, (byte) 0xDA, (byte) 0xC0};

		container.decode(data);
		assertEquals(0xCAL, container.get_param1());
		assertEquals(0xFEDEL, container.get_param2());
		assertEquals(0xCAFADAC0L, container.get_param3());

		assertEquals("CA FE DE CA FA DA C0", container.hex());
	}

	@Test
	@DisplayName("Test example simple buffer")
	void test_simple_buffer() {
		// test instantiation
		SimpleBuffer buffer = new SimpleBuffer("example", null);

		// check empty buffer encode
		assertEquals(0, buffer.getLength());
		byte[] data = buffer.encode();
		assertEquals(0, data.length);
		assertEquals("", buffer.hex());

		// check empty buffer decode
		buffer.decode(new byte[]{});
		assertEquals(0, buffer.getLength());
		assertEquals("", buffer.hex());

		// check non-empty buffer encode
		int length = 5;
		buffer.setLength(length);
		assertEquals(8*length, buffer.getLength());
		data = buffer.encode();
		for (int i=0; i<length; ++i) {
			assertEquals(0x00, data[0]);
		}
		assertEquals("00 00 00 00 00", buffer.hex());

		// check non-empty buffer decode
		byte[] decData = new byte[length];
		for (int i=1; i<=length; ++i) {
			decData[i-1] = (byte)(i+(i<<4)); // 0x11, 0x22, 0x33, etc.
		}
		buffer.decode(decData);
		assertEquals(8*length, buffer.getLength());
		assertEquals("11 22 33 44 55", buffer.hex());

		// check get
		byte[] read = buffer.get();
		for (int i=1; i<=length; ++i) {
			assertEquals((byte)(i+(i<<4)), read[i-1]);
			assertEquals((byte)(i+(i<<4)), buffer.getAt(i-1));
		}

		// check set
		buffer.set(new byte[]{0x12, 0x34, 0x56, 0x78, 0x74});
		buffer.setAt(1, (byte)0x42);
		buffer.setAt(4, (byte)0x95);
		buffer.setAt(5, (byte)0x80); // invalid index
		assertEquals("12 42 56 78 95", buffer.hex());


		// check non-empty buffer with valid size
		buffer.set(new byte[]{0x12, 0x34, 0x56, 0x78, 0x74}); // valid size
		read = buffer.get();
		assertEquals(length, read.length);
		assertEquals("12 34 56 78 74", buffer.hex());

		// change length
		buffer.setLength(10);
		assertEquals(80, buffer.getLength());
		assertEquals("12 34 56 78 74 00 00 00 00 00", buffer.hex());

		buffer.setLength(3);
		assertEquals(24, buffer.getLength());
		assertEquals("12 34 56", buffer.hex());

		// check invalid set
		buffer.set(new byte[]{0x12, 0x34, 0x56, 0x78, 0x74}); // invalid size
		assertEquals(24, buffer.getLength());
		assertEquals("12 34 56", buffer.hex()); // unchanged

		// check restore to null length
		buffer.setLength(0);
		assertEquals(0, buffer.getLength());
		assertEquals("", buffer.hex()); // unchanged
	}

	@Test
	@DisplayName("Test example simple container with list of parameters")
	void test_simple_container_with_parameter_list() {
		// test instantiation
		SimpleContainerWithParameterList cont = new SimpleContainerWithParameterList("example", null);

		// initial value
		byte[] data = cont.encode();
		assertEquals(64, cont.getLength());
		assertEquals((byte) 0x00, data[0]);
		assertEquals((byte) 0x00, data[1]);
		assertEquals((byte) 0x00, data[2]);
		assertEquals((byte) 0x00, data[3]);
		assertEquals((byte) 0x00, data[4]);
		assertEquals((byte) 0x00, data[5]);
		assertEquals((byte) 0x00, data[6]);
		assertEquals((byte) 0x00, data[7]);

		// check param1
		cont.set_param1(0x1234);
		data = cont.encode();
		assertEquals(64, cont.getLength());
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x00, data[2]);
		assertEquals((byte) 0x00, data[3]);
		assertEquals((byte) 0x00, data[4]);
		assertEquals((byte) 0x00, data[5]);
		assertEquals((byte) 0x00, data[6]);
		assertEquals((byte) 0x00, data[7]);

		// check param2
		cont.set_param2(0x5678);
		data = cont.encode();
		assertEquals(64, cont.getLength());
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x56, data[2]);
		assertEquals((byte) 0x78, data[3]);
		assertEquals((byte) 0x00, data[4]);
		assertEquals((byte) 0x00, data[5]);
		assertEquals((byte) 0x00, data[6]);
		assertEquals((byte) 0x00, data[7]);

		// check param3 (multiplies param4)
		cont.set_param3(1);
		data = cont.encode();
		assertEquals(64 + 8, cont.getLength());
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x56, data[2]);
		assertEquals((byte) 0x78, data[3]);
		assertEquals((byte) 0x00, data[4]);
		assertEquals((byte) 0x00, data[5]);
		assertEquals((byte) 0x00, data[6]);
		assertEquals((byte) 0x01, data[7]);
		assertEquals((byte) 0x00, data[8]);

		cont.set_param3(10);
		data = cont.encode();
		assertEquals(64 + 10 * 8, cont.getLength());
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x56, data[2]);
		assertEquals((byte) 0x78, data[3]);
		assertEquals((byte) 0x00, data[4]);
		assertEquals((byte) 0x00, data[5]);
		assertEquals((byte) 0x00, data[6]);
		assertEquals((byte) 0x0A, data[7]);
		assertEquals((byte) 0x00, data[8]);
		assertEquals((byte) 0x00, data[9]);
		assertEquals((byte) 0x00, data[10]);
		assertEquals((byte) 0x00, data[11]);
		assertEquals((byte) 0x00, data[12]);
		assertEquals((byte) 0x00, data[13]);
		assertEquals((byte) 0x00, data[14]);
		assertEquals((byte) 0x00, data[15]);
		assertEquals((byte) 0x00, data[16]);
		assertEquals((byte) 0x00, data[17]);

		cont.set_param3(2);
		data = cont.encode();
		assertEquals(64 + 2 * 8, cont.getLength());
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x56, data[2]);
		assertEquals((byte) 0x78, data[3]);
		assertEquals((byte) 0x00, data[4]);
		assertEquals((byte) 0x00, data[5]);
		assertEquals((byte) 0x00, data[6]);
		assertEquals((byte) 0x02, data[7]);
		assertEquals((byte) 0x00, data[8]);
		assertEquals((byte) 0x00, data[9]);

		// check param4
		cont.set_param4(0, 0xAA);
		cont.set_param4(1, 0xBB);

		data = cont.encode();
		assertEquals(64 + 2 * 8, cont.getLength());
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0x56, data[2]);
		assertEquals((byte) 0x78, data[3]);
		assertEquals((byte) 0x00, data[4]);
		assertEquals((byte) 0x00, data[5]);
		assertEquals((byte) 0x00, data[6]);
		assertEquals((byte) 0x02, data[7]);
		assertEquals((byte) 0xAA, data[8]);
		assertEquals((byte) 0xBB, data[9]);

		assertEquals("12 34 56 78 00 00 00 02 AA BB", cont.hex());

		// check decoding
		data = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xDE, (byte) 0xCA, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};

		cont.decode(data);
		assertEquals(64, cont.getLength());
		assertEquals(0xCAFE, cont.get_param1());
		assertEquals(0xDECA, cont.get_param2());
		assertEquals(0, cont.get_param3());

		assertEquals("CA FE DE CA 00 00 00 00", cont.hex());

		// check another decoding
		data = new byte[]{(byte) 0xFA, (byte) 0xDA, (byte) 0xC0, (byte) 0xDE, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x04, (byte) 0xDD, (byte) 0xCC, (byte) 0xBB, (byte) 0xAA};

		cont.decode(data);
		assertEquals(64 + 4 * 8, cont.getLength());
		assertEquals(0xFADA, cont.get_param1());
		assertEquals(0xC0DE, cont.get_param2());
		assertEquals(4, cont.get_param3());
		assertEquals(0xDD, cont.get_param4(0));
		assertEquals(0xCC, cont.get_param4(1));
		assertEquals(0xBB, cont.get_param4(2));
		assertEquals(0xAA, cont.get_param4(3));

		assertEquals("FA DA C0 DE 00 00 00 04 DD CC BB AA", cont.hex());
	}

	@Test
	@DisplayName("Test example simple container with list of containers")
	void test_simple_container_with_container_list() {
		// test instantiation
		SimpleContainerWithContainerList cont = new SimpleContainerWithContainerList("example", null);

		// initial value
		byte[] data = cont.encode();
		assertEquals(80, cont.getLength());
		for (int i=0; i<10; ++i) {
			assertEquals((byte)0x00, data[i]);
		}

		// check param1 ad param6
		cont.set_param1(0x12345678L);
		cont.set_param6(0x98765432L);

		data = cont.encode();
		assertEquals(80, cont.getLength());
		assertEquals((byte)0x12, data[0]);
		assertEquals((byte)0x34, data[1]);
		assertEquals((byte)0x56, data[2]);
		assertEquals((byte)0x78, data[3]);
		assertEquals((byte)0x98, data[6]);
		assertEquals((byte)0x76, data[7]);
		assertEquals((byte)0x54, data[8]);
		assertEquals((byte)0x32, data[9]);

		assertEquals("12 34 56 78 00 00 98 76 54 32", cont.toString());

		// check param2 (multiplies cont1)
		cont.set_param2(1);
		assertEquals(8*(10+4), cont.getLength());

		cont.set_param2(10);
		assertEquals(8*(10+10*4), cont.getLength());

		cont.set_param2(2);
		assertEquals(8*(10+2*4), cont.getLength());

		assertEquals("12 34 56 78 00 02 00 00 00 00 00 00 00 00 98 76 54 32", cont.toString());

		// check param3
		cont.get_cont1(0).set_param3(0xCAFE);
		cont.get_cont1(1).set_param3(0xDECA);

		assertEquals(8*(10+2*4), cont.getLength());
		assertEquals("12 34 56 78 00 02 CA FE 00 00 DE CA 00 00 98 76 54 32", cont.toString());

		// check param4
		cont.get_cont1(0).set_param4(1);
		cont.get_cont1(1).set_param4(4);

		assertEquals(8*(10+2*4+1+4), cont.getLength());
		assertEquals("12 34 56 78 00 02 CA FE 00 01 00 DE CA 00 04 00 00 00 00 98 76 54 32", cont.toString());

		// check param5
		cont.get_cont1(0).set_param5(0, 0x77);
		cont.get_cont1(1).set_param5(0, 0xFA);
		cont.get_cont1(1).set_param5(1, 0xDA);
		cont.get_cont1(1).set_param5(2, 0xC0);
		cont.get_cont1(1).set_param5(3, 0xDE);

		assertEquals(8*(10+2*4+1+4), cont.getLength());
		assertEquals("12 34 56 78 00 02 CA FE 00 01 77 DE CA 00 04 FA DA C0 DE 98 76 54 32", cont.toString());
	}

	@Test
	@DisplayName("Test example simple container with buffer")
	void test_simple_container_with_buffer() {
		// test instantiation
		SimpleContainerWithBuffer container = new SimpleContainerWithBuffer("example", null);

		assertEquals(48, container.getLength());

		// check encoding
		container.set_param1(0x1122);
		container.set_param2(0x33445566);

		byte[] data = container.encode();
		assertEquals((byte) 0x11, data[0]);
		assertEquals((byte) 0x22, data[1]);
		assertEquals((byte) 0x33, data[2]);
		assertEquals((byte) 0x44, data[3]);
		assertEquals((byte) 0x55, data[4]);
		assertEquals((byte) 0x66, data[5]);

		assertEquals("11 22 33 44 55 66", container.hex());
		assertEquals(0, container.get_buffer1().getLength());
		assertEquals(0, container.get_buffer2().getLength());

		// check decoding
		data = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xDE, (byte) 0xCA, (byte) 0xFA, (byte) 0xDA};

		container.decode(data);
		assertEquals(0xCAFEL, container.get_param1());
		assertEquals(0xDECAFADAL, container.get_param2());

		assertEquals("CA FE DE CA FA DA", container.hex());

		// check encoding with buffers
		container.get_buffer1().setLength(2);
		container.get_buffer1().set(new byte[] {(byte)0xAA, (byte)0xBB});
		container.get_buffer2().setLength(3);
		container.get_buffer2().set(new byte[] {(byte)0xEE, (byte)0xDD, (byte)0xCC});
		assertEquals(88, container.getLength());

		data = container.encode();
		assertEquals((byte) 0xCA, data[0]);
		assertEquals((byte) 0xFE, data[1]);
		assertEquals((byte) 0xAA, data[2]);
		assertEquals((byte) 0xBB, data[3]);
		assertEquals((byte) 0xEE, data[4]);
		assertEquals((byte) 0xDD, data[5]);
		assertEquals((byte) 0xCC, data[6]);
		assertEquals((byte) 0xDE, data[7]);
		assertEquals((byte) 0xCA, data[8]);
		assertEquals((byte) 0xFA, data[9]);
		assertEquals((byte) 0xDA, data[10]);
		assertEquals("CA FE AA BB EE DD CC DE CA FA DA", container.hex());

		// check decoding with buffers
		data = new byte[]{(byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78, (byte) 0x98, (byte) 0x76, (byte) 0x54, (byte) 0x32, (byte) 0x10, (byte) 0x01, (byte) 0x23};

		container.decode(data);
		assertEquals(0x1234L, container.get_param1());
		assertEquals(0x56L, container.get_buffer1().getAt(0));
		assertEquals(0x78L, container.get_buffer1().getAt(1));
		assertEquals(0x98L, container.get_buffer2().getAt(0));
		assertEquals(0x76L, container.get_buffer2().getAt(1));
		assertEquals(0x54L, container.get_buffer2().getAt(2));
		assertEquals(0x32100123L, container.get_param2());
		assertEquals("12 34 56 78 98 76 54 32 10 01 23", container.hex());

		// change length
		container.get_buffer2().setLength(0);
		assertEquals("12 34 56 78 32 10 01 23", container.hex());
	}

	@Test
	@DisplayName("Test example simple merge")
	void test_simple_merge() {
		// test instantiation
		SimpleMerge container = new SimpleMerge("example", null);

		assertEquals(72, container.getLength());

		// check encoding
		container.set_param1(0x1234);
		container.set_param2(0xAABBCCDDL);
		container.get_cont2().set_param3(0x74);
		container.get_cont2().set_param4(0x7372);

		byte[] data = container.encode();
		assertEquals((byte) 0x12, data[0]);
		assertEquals((byte) 0x34, data[1]);
		assertEquals((byte) 0xAA, data[2]);
		assertEquals((byte) 0xBB, data[3]);
		assertEquals((byte) 0xCC, data[4]);
		assertEquals((byte) 0xDD, data[5]);
		assertEquals((byte) 0x74, data[6]);
		assertEquals((byte) 0x73, data[7]);
		assertEquals((byte) 0x72, data[8]);

		assertEquals("12 34 AA BB CC DD 74 73 72", container.hex());
	}
}
