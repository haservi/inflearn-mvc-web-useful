package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HomeController {

    @GetMapping(value = "/hello-v1")
    public String helloV1(HttpServletRequest request) {
        // 문자 타입 조회
        String parameter = request.getParameter("data");
        Integer integerValue = Integer.valueOf(parameter);
        System.out.println("integerValue = " + integerValue);
        return "ok";
    }

    @GetMapping(value = "/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping(value = "/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        log.info("ipPort ip = {}", ipPort.getIp());
        log.info("ipPort port - {}", ipPort.getPort());
        return "ok";
    }
}
