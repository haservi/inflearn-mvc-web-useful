package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Spring 내부의 ConversionService 외에 정의한 Converter 우선순위가 이쪽이 더 높음
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIpPortConverter());

        // 위의 숫자를 문자로 바꿔주는 컨버터와 겹침 우선순위는 컨버터가 포멧터보다 높음
        registry.addFormatter(new MyNumberFormatter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIntegerConverter());
    }
}
