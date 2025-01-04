package qrohan.eden.core.tools.factory;

import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class FactoryTest
{
	private Factory factory;

	@BeforeEach
	public void init()
	{
		factory = new Factory();
	}

	@AfterEach
	public void terminate()
	{
	}

	@Nested
	@Tag("Factory")
	@DisplayName("Factory run")
	class FactoryRun {
		@Test
		@DisplayName("Run factory")
		void test_run_factory()
		{
			// Generate files for unit tests
			String inputPath = System.getProperty("testResourcesDir") + "/stream/";
			String outputDirectory = System.getProperty("generationDir") + "/stream/";
			String outputPackage = "qrohan.eden.core.stream.example";

			test_unit_creation(inputPath + "simple_parameter.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "simple_container.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "simple_buffer.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "simple_container_with_parameter_list.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "simple_container_with_container_list.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "simple_container_with_buffer.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "simple_merge.json", outputDirectory, outputPackage);

			// Generate files for frames and packets
			inputPath = System.getProperty("resourcesDir") + "/data/ccsds/";
			outputDirectory = System.getProperty("generationDir") + "/ccsds/";
			outputPackage = "qrohan.eden.com.ccsds";

			test_unit_creation(inputPath + "CCSDS_TC_FRAME_PRIMARY_HEADER.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "CCSDS_TC_FRAME_SEGMENT_HEADER.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "CCSDS_TM_FRAME_PRIMARY_HEADER.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "CCSDS_TM_FRAME_SECONDARY_HEADER.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "CCSDS_FRAME_SECURITY_HEADER.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "CCSDS_FRAME_SECURITY_TRAILER.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "CCSDS_PACKET_PRIMARY_HEADER.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "CCSDS_PACKET_DATA_FIELD.json", outputDirectory, outputPackage);

			// Generate files for spacewire
			inputPath = System.getProperty("resourcesDir") + "/data/spacewire/";
			outputDirectory = System.getProperty("generationDir") + "/spacewire/";
			outputPackage = "qrohan.eden.com.spacewire";

			test_unit_creation(inputPath + "SPW_RMAP_WRITE_COMMAND.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "SPW_RMAP_WRITE_REPLY.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "SPW_RMAP_READ_COMMAND.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "SPW_RMAP_READ_REPLY.json", outputDirectory, outputPackage);
			test_unit_creation(inputPath + "SPW_CCSDS_PACKET.json", outputDirectory, outputPackage);
		}
	}

	protected void test_unit_creation(String inputFile, String outputDirectory, String outputPackage) {
		// Test generation
		boolean creationOk = true;
		try {
			factory.reset();
			factory.setLoggingLevel(Level.FINEST);
			factory.setGenerationDir(outputDirectory);
			factory.createFromJson(inputFile, outputPackage);
		} catch (IOException e) {
			//e.printStackTrace(); // uncomment for debug
			creationOk = false;
		}
		assertTrue(creationOk, "Creation status");
	}
}