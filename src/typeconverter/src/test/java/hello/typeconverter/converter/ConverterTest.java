package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConverterTest {

    @Test
    @DisplayName("01_문자를 숫자로")
    void stringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        System.out.println("result = " + result);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("02_숫자를 문자로")
    void integerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        System.out.println("result = " + result);
        assertThat(result).isEqualTo("10");
    }

    @Test
    @DisplayName("03_문자를 특정 클래스 객체로")
    void stringToIpPort() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @Test
    @DisplayName("04_특정 클래스 객체를 문자로")
    void ipPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}