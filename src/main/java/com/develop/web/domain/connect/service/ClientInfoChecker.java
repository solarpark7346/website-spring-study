package com.develop.web.domain.connect.service;

import com.develop.web.domain.connect.ClientInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientInfoChecker {
    private final CheckClientBrowser checkClientBrowser;
    private final CheckClientOS checkClientOS;

    public ClientInfoDto clientInfo(String account, HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getHeader("X-Forwarded-For");
        String agent = httpServletRequest.getHeader("USER-AGENT");
        String os = checkClientOS.getClientOS(agent);
        String browser = checkClientBrowser.getClientBrowser(agent);

        if (ip == null || ip.length() == 0 ||
            ip.equalsIgnoreCase("unknown"))
            ip = httpServletRequest.getRemoteAddr();

        ClientInfoDto clientInfo = new ClientInfoDto(agent, os, browser, ip);

        log.info(
            "[+] Connect log" + "\n" +
            "account: " + account + "\n" +
            "ip: " + clientInfo.getIp() + "\n" +
            "header: " + clientInfo.getHeader() + "\n" +
            "os: " + clientInfo.getOs() + "\n" +
            "browser: " + clientInfo.getBrowser()
        );

        return clientInfo;
    }
}
