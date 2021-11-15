package kanbangantt.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public ResponseEntity<String> Index(HttpServletResponse response) {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
