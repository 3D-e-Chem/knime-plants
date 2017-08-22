package nl.esciencecenter.e3dchem.knime.plants.configure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import nl.esciencecenter.e3dchem.knime.plants.configure.ConfigureDialog;
import nl.esciencecenter.e3dchem.knime.plants.configure.ConfigureFactory;
import nl.esciencecenter.e3dchem.knime.plants.configure.ConfigureModel;

public class ConfigureFactoryTest {
	private ConfigureFactory factory;
	
	@Before
	public void setUp() {
		factory = new ConfigureFactory();		
	}
	
	@Test
	public void test_getNrNodeViews() {
		int result = factory.getNrNodeViews();
		assertEquals(0, result);
	}

	@Test
	public void test_hasDialog() {
		assertEquals(true, factory.hasDialog());
	}
	
	@Test
	public void test_createNodeModel() {
		assertEquals(ConfigureModel.class, factory.createNodeModel().getClass());
	}
	
	@Test
	public void test_createNodeDialogPane() {
		assertEquals(ConfigureDialog.class, factory.createNodeDialogPane().getClass());
	}
	
	@Test
	public void test_createNodeView() {
		assertEquals(null, factory.createNodeView(0, factory.createNodeModel()));
	}
}
