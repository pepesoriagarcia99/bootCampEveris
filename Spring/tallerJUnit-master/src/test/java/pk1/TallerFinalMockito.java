package pk1;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.BaseDeDatosService;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;

public class TallerFinalMockito {
	CarritoCompraService ser;
	BaseDeDatosService serMock;
	
	List<Articulo> articulos;
	Articulo a;
	
	@Before
	public void init(){
		System.out.println("Inicializamos el servicio");
		ser = new CarritoCompraService();
		serMock = Mockito.mock(BaseDeDatosService.class);
		ser.setBbddService(serMock);
	}
	
	@Test
	public void insertar() {

		verify(serMock.insertArticulo(a));
		
	}
}
