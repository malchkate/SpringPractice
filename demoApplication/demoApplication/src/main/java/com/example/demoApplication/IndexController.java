package com.example.demoApplication;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/visit")
public class IndexController {

    final VisitsRepository visitsRepository;

    @GetMapping("/")
    public ModelAndView indexNoName() {
        saveToDB("anonymous user");
        return new ModelAndView("indexNoName");
    }

    @Transactional
    @GetMapping("/{name}")
    public ModelAndView index(@PathVariable String  name){
        Map<String, Object> model = new HashMap<>();
        model.put("name", name);

        saveToDB(name);

        Pageable pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "name");
        List<Visit> visitList = visitsRepository.findByName(name, pageRequest);
        model.put("visits", visitList);

        return new ModelAndView("index", model);
    }

    private void saveToDB(String name){
        Visit visit = new Visit(name, String.format("Visited at %s", LocalDateTime.now()));
        visitsRepository.save(visit);
    }
}
