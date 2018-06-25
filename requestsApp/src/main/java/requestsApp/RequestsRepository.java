package requestsApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Request, Long> {
    List<Request> findByContactId(long contactId);
}
