package requestsApp;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class RequestsController {
    final private RequestsRepository requestsRepository;

    public RequestsController(RequestsRepository requestsRepository){
        this.requestsRepository = requestsRepository;
    }

    @Transactional
    @GetMapping(value = "/id/{contactId}")
    public Optional<Request> request(@PathVariable long contactId) {
        Pageable pageRequest = PageRequest.of(0, 1, Sort.Direction.DESC, "dtCreated");
        List<Request> requestsList = requestsRepository.findByContactId(contactId, pageRequest);
        return Optional.ofNullable(requestsList.get(0));
    }
}
