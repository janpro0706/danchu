package com.danchu.momuck.controller;

import com.danchu.momuck.domain.LoginResult;
import com.danchu.momuck.service.AccountService;
import com.danchu.momuck.view.ResultView;
import com.danchu.momuck.vo.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * AccountController
 *
 * @author genie
 */
@Controller
@RequestMapping(value = "/accounts")
public class AccountController {

    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResultView register(HttpServletRequest req, HttpServletResponse res, @Valid @RequestBody Account account, BindingResult bindingResult) throws JsonProcessingException {
        //validation 실패
        if (bindingResult.hasErrors()) {
            return new ResultView("500", "Register fail : " + bindingResult.getFieldError().getDefaultMessage(), null);
        }
        //duplicated key exception
        Account result = accountService.createAccount(account);
        if (result == null) {
            return new ResultView("500", "Duplicated email or name", null);
        }

        return new ResultView("200", "Register success", account);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResultView login(@RequestBody Account account) {

        LoginResult loginResult = accountService.login(account);

        if (loginResult.getCode() == LoginResult.SUCCESS.getCode()) {
            /**
             * @TODO AccessToken 발급
             */
        }
        return new ResultView(String.valueOf(loginResult.getCode()), loginResult.getMessage(), null);
    }

}
