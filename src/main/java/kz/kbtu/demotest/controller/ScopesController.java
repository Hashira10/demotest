package kz.kbtu.demotest.controller;


import jakarta.annotation.Resource;
import kz.kbtu.demotest.model.HelloMessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@Slf4j
public class ScopesController {
    public static final Logger LOG = LoggerFactory.getLogger(ScopesController.class);

    @Resource(name = "requestScopedBean")
    HelloMessageGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    HelloMessageGenerator sessionScopedBean;

    @Resource(name = "applicationScopedBean")
    HelloMessageGenerator applicationScopedBean;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
        model.addAttribute("previousMessage", requestScopedBean.getMessage());
        log.info(requestScopedBean.getMessage());
        requestScopedBean.setMessage("Request Scope Message!");
        model.addAttribute("currentMessage", requestScopedBean.getMessage());
        log.info(requestScopedBean.getMessage());
        return "scopesExample";
    }

    @RequestMapping("/scopes/session")
    public String getSessionScopeMessage(final Model model) {
        model.addAttribute("previousMessage", sessionScopedBean.getMessage());
        sessionScopedBean.setMessage("Session Scope Message!");
        model.addAttribute("currentMessage", sessionScopedBean.getMessage());
        return "scopesExample";
    }

    @RequestMapping("/scopes/application")
    public String getApplicationScopeMessage(final Model model) {
        model.addAttribute("previousMessage", applicationScopedBean.getMessage());
        applicationScopedBean.setMessage("Application Scope Message!");
        model.addAttribute("currentMessage", applicationScopedBean.getMessage());
        return "scopesExample";

    }


}
