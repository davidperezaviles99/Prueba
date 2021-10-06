package com.ejercicio1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import com.ejercicio1.persistence.Cliente;
import com.ejercicio1.services.ClienteServiceI;

@SpringBootApplication(scanBasePackages={"com.ejercicio1.persistence", "com.ejercicio1.services"})
public class Application implements CommandLineRunner{
	
	@Autowired
	private ClienteServiceI clientesService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente();
		cliente1.setClienteDNI("12345678A");
		cliente1.setNombre("David");
		cliente1.setApellido1("Perez");
		cliente1.setApellido2("Aviles");

		Cliente cliente2 = new Cliente();
		cliente2.setClienteDNI("87654321B");
		cliente2.setNombre("Natalia");
		cliente2.setApellido1("Aviles");
		cliente2.setApellido2("Rodriguez");
		
		clientesService.insertNewCliente(cliente1);
		clientesService.insertNewCliente(cliente2);

		cliente2.setClienteId(2L);
		clientesService.deleteCliente(cliente2);

		List<Cliente> clienteList = clientesService.searchAll();
			if (!CollectionUtils.isEmpty(clienteList)) {
				System.out.println("Total de clientes registrados: " + clienteList.size());
				for (Cliente cliente : clienteList) {
						System.out.println(cliente.toString() + "\n");
				}
			}

			final Long searchId = 1L;
			final Cliente buscarCliente = clientesService.searchById(searchId);

				if (buscarCliente != null) {
					System.out.println("Se ha localizado el cliente con ID " + searchId + ":");
					System.out.println(buscarCliente.toString());
				}

			final List<Cliente> clientebynombrecompleto = clientesService.searchByCliente("David", "Perez", "Aviles");

				if (!CollectionUtils.isEmpty(clientebynombrecompleto)) {
					System.out.println("Total de clientes registrados con el mismo nombre: " + clientebynombrecompleto.size());
					for (Cliente cliente : clientebynombrecompleto) {
						System.out.println(cliente.toString() + "\n");
					}
				}

}
}
