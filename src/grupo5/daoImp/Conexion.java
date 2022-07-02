package grupo5.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class Conexion {

	private static SessionFactory sessionFactory;
	private static Session session;
	private static Configuration configuration;

	public Conexion() {
		// Este new configuration no se puede sacar a un bean po
		configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public Session abrirConexion() {

		configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		return session;
	}

	public void cerrarSession() {
		session.close();
		cerrarSessionFactory();
	}

	private void cerrarSessionFactory() {
		sessionFactory.close();
	}

}
