package com.orange.ilbun.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthenticationController {
    @GetMapping("/api/isAuthenticated")
    @ResponseBody
    public Map<String, Boolean> isAuthenticated() {
        Map<String, Boolean> response = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        response.put("isAuthenticated", authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated());
        return response;
    }

}
