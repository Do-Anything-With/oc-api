package kanbangantt.project.attribute;

import kanbangantt.project.constant.Role;
import kanbangantt.project.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name,
                           String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        switch (registrationId) {
            case "kakao":
                return ofKakao(userNameAttributeName, attributes);
            case "google":
                return ofGoogle(userNameAttributeName, attributes);
            default:
                throw new RuntimeException("NOT SUPPORTED OAUTH VENDOR");
        }
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                              .name((String) attributes.get("name"))
                              .email((String) attributes.get("email"))
                              .picture((String) attributes.get("picture"))
                              .attributes(attributes)
                              .nameAttributeKey(userNameAttributeName)
                              .build();
    }

    @SuppressWarnings({"unchecked"})
    private static OAuthAttributes ofKakao(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        Map<String, String> kakaoPropertiesMap = (Map<String, String>) attributes.getOrDefault("properties",
                Collections.emptyMap());
        Map<String, String> kakaoAccountMap = (Map<String, String>) attributes.getOrDefault("kakao_account",
                Collections.emptyMap());
        return OAuthAttributes.builder()
                              .name((String) kakaoPropertiesMap.get("nickname"))
                              .email((String) kakaoAccountMap.get("email"))
                              .picture((String) kakaoPropertiesMap.get("profile_image"))
                              .attributes(attributes)
                              .nameAttributeKey(userNameAttributeName)
                              .build();
    }

    public User toEntity() {
        return User.builder()
                   .name(name)
                   .email(email)
                   .picture(picture)
                   .role(Role.GUEST)
                   .build();
    }
}
