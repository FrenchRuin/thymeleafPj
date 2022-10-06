package com.example.soloproject.service;

import com.example.soloproject.dto.LoginInfoDto;
import com.example.soloproject.dto.WebDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebService {

    public WebDto printIn(WebDto webDto) {

        log.info(webDto.getAddress());
        log.info(webDto.getAddress());

        return webDto;
    }

    public String printLogin(LoginInfoDto loginInfoDto) {

        log.info(loginInfoDto.getPassword());
        log.info(loginInfoDto.getId());

        if (!loginInfoDto.getId().equals("toxic023")) {
            log.info("아이디가 틀렸습니다.");
            return "redirect:/login";
        }
        return "redirect:/";
    }

}
