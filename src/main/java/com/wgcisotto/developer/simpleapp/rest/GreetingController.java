package com.wgcisotto.developer.simpleapp.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greet(@AuthenticationPrincipal OidcUser user){
        return "Hello " + user.getEmail();
    }
}
