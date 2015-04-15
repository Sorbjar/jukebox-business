import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClearDBData {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		EntityManagerFactory emf;
		EntityManager em;
		EntityTransaction tx;
		emf = Persistence.createEntityManagerFactory("jukebox-business");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		Query query = em
				.createNativeQuery("CALL `jukebox`.`SP_DropWholeJukebox`();");
		query.executeUpdate();
		tx.commit();
		em.close();
		emf.close();

	}
}
