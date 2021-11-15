package kanbangantt.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    @PostMapping("/oauth2/code/kakao")
    public ResponseEntity<String> oAuthKakaoCallback(HttpServletRequest request) {
        log.info("request: {}", request);
        return new ResponseEntity<>("HERE", HttpStatus.OK);
    }
}
