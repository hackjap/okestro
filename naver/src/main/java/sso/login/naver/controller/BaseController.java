package sso.login.naver.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
public class BaseController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    private static final String authorizationRequestBaseuri = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
    private final ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/login")
    public String getLoginPage(Model model) throws Exception {
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }
        assert clientRegistrations != null;
        clientRegistrations.forEach(clientRegistration ->
                oauth2AuthenticationUrls.put(clientRegistration.getClientName(),
                        authorizationRequestBaseuri + "/" + clientRegistration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);

        return "login";
    }
}
