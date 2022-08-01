package hello.typeconverter.model;

import hello.typeconverter.type.IpPort;
import lombok.Data;

@Data
public class Form {

    private IpPort ipPort;

    public Form(IpPort ipPort) {
        this.ipPort = ipPort;
    }
}
