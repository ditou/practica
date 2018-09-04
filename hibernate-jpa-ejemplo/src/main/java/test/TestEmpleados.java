package test;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Direccion;
import modelo.Empleado;

public class TestEmpleados {
	
	
	// una forma de	@PersistenceContext(unitName = "Persistencia")
		private static EntityManager manager;
		
		
		private static EntityManagerFactory emf;

		@SuppressWarnings({ "unchecked", "unused" })

	public static void main(String[] args) {
		
			//crear el gestor de persistencia (EM)
			emf = Persistence.createEntityManagerFactory("Persistencia");
			manager = emf.createEntityManager();
			
			
			Empleado e = new Empleado(10L, "Perez", "Pepito", new GregorianCalendar(1988, 10, 11).getTime());
			
			e.SetDireccion(new Direccion(15L, "Calle falsa, 123", "Springfield","Springfieldß" ,"EEUU"));
			
			
			manager.getTransaction().begin();
			manager.persist(e);
			manager.getTransaction().commit();
			
			imprimirTodo();
			
			

	}

		@SuppressWarnings("unchecked")
		private static void imprimirTodo() {
			
			List<Empleado> emps = manager.createQuery("FROM Empleado").getResultList();
			System.out.println("En esta base de datos hay " + emps.size() + " Empleados");
			for (Empleado emp : emps) {
				System.out.println(emp.toString());
				
			}
			
		}
		
}
