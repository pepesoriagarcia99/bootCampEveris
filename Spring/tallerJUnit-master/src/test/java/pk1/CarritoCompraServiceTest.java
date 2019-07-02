package pk1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class CarritoCompraServiceTest {

	private List<CarritoCompraService> articulos;
	private CarritoCompraService carrito;
	
	@Before
	public void antes() {
		articulos = new ArrayList<CarritoCompraService>();
		carrito = new CarritoCompraService();
	}
	
	@Test
	public void primerTest() {
		articulos.add(new CarritoCompraService());
		assertTrue(articulos.size()>0);		
	}
	
	@Test
	public void añadirCarrito() {
		Articulo a = new Articulo("pepe",1.0);
		assertFalse(a.getDescripcion().isEmpty());	
		
		carrito.setOneArticulos(a);
	}
	
	@Test(expected=IOException.class)
	public void lismpiarCesta() throws IOException {
		Articulo a = new Articulo("pepe",1.0);	
		carrito.setOneArticulos(a);
		
		carrito.limpiarCesta();

	
		assertTrue(carrito.getNumArticulo()==0);	
	}
	
	@Test
	public void price() {
		Articulo a = new Articulo("pepe",1.0);	
		Articulo b = new Articulo("pepee",2.0);	
		Articulo c = new Articulo("pepeee",3.0);	
		Articulo d = new Articulo("pepeeeee",4.0);
		List<Articulo> aR= new ArrayList<Articulo>();
		aR.add(a);
		a = null;
		aR.add(b);
		b = null;
		aR.add(c);
		c = null;
		aR.add(d);
		d = null;
		carrito.setArticulos(aR);
		assertTrue(carrito.totalPrice()!=0);
		aR.clear();
	}
	

}


