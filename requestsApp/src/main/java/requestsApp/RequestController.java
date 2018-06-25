package requestsApp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RequestController {
    final RequestsRepository requestsRepository;

    public RequestController(RequestsRepository requestsRepository){
        this.requestsRepository = requestsRepository;
    }

    @RequestMapping(method=GET)
    public Request request(@RequestParam(value="id", required=true) long contactId) {
        try {
            List<Request> requestsList = requestsRepository.findByContactId(contactId);
            Collections.sort(requestsList, (Request a, Request b) -> b.getDT_CREATED().compareTo(a.getDT_CREATED()));
            return requestsList.get(0);
        } catch(Exception ex){
            ex.printStackTrace();
            return  null;
        }
    }
}
