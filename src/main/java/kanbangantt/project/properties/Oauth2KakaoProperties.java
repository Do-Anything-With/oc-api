package kanbangantt.project.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("oauth2.kakao")
public class Oauth2KakaoProperties {

    private String clientId;
    private String redirectUrl;
}
