package ru.androsov.feignclientstarter.dotachess;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServiceClient;

import java.util.logging.Logger;

@Slf4j
@Configuration
public class FeignClientConfiguration {
    @Configuration
    @ConditionalOnProperty({"feign.dotachess-auth.url", "feign.dotachess-auth.login", "feign.dotachess-auth.password"})
    public static class AuthServiceConfiguration {
        @Bean
        public AuthServiceClient authServiceClient(
                @Value("${feign.dotachess-auth.url}") String url,
                @Value("${feign.dotachess-auth.login}") String login,
                @Value("${feign.dotachess-auth.password}") String password,
                ObjectFactory<HttpMessageConverters> messageConverters
        ) {
            log.info("Configuring AuthServiceClient...");

            return Feign.builder()
                    .contract(new SpringMvcContract())
                    .encoder(new SpringEncoder(messageConverters))
                    .decoder(new SpringDecoder(messageConverters))
                    .requestInterceptor(new BasicAuthRequestInterceptor(login, password))
                    .target(AuthServiceClient.class, url);
        }
    }
}

