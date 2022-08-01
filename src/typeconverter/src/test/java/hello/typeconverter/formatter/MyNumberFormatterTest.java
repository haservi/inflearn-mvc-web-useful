package hello.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * 스프링 포맷 관련: https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#format
 */
class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        Number result = formatter.parse("1,000", Locale.KOREA);
        System.out.println("result = " + result);
        Assertions.assertThat(result).isEqualTo(1000L);
    }

    @Test
    void print() {
        String result = formatter.print(1000, Locale.KOREA);
        System.out.println("result = " + result);
        Assertions.assertThat(result).isEqualTo("1,000");
    }

    @Test
    void locale_parse() {
        Locale korea = Locale.KOREA;
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(korea);
        double value = 1000000;
        String kr = currencyInstance.format(value);
        System.out.println("kr = " + kr);

        Locale english = Locale.US;
        NumberFormat currencyInstance1 = NumberFormat.getCurrencyInstance(english);
        double v = 1000000;
        String en = currencyInstance1.format(v);
        System.out.println("en = " + en);
    }

}