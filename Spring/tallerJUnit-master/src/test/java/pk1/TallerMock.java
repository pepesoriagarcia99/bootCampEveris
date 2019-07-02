package pk1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.BaseDeDatosService;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;

public class TallerMock {
	
	CarritoCompraService ser;
	BaseDeDatosService serMock;
	
	@Before
	public void init(){
		System.out.println("Inicializamos el servicio");
		ser = new CarritoCompraService();
		serMock = Mockito.mock(BaseDeDatosService.class);
		ser.setBbddService(serMock);
	}
	
	@Test
	public void findIdTest() {
		Mockito.when(serMock.findArticuloById(1)).thenReturn(new Articulo("abrigo", 50d));
		
		double num = ser.aplicarDescuento(1, 50d);
		System.out.println(num);
	}

}
