package com.micro.system.zuul.service;

import com.micro.system.zuul.model.form.LoginForm;

public interface LoginService {
    Boolean login(LoginForm loginForm);
}
