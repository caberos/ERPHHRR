package com.diplomado.springboot;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BackendApplication {
    private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BackendApplication.class);
        logApplicationStartup(springApplication.run(args).getEnvironment());
    }

    public static void logApplicationStartup(Environment env) {
        String protocol = Optional.ofNullable(env.getProperty("server.ssl.store"))
                .map(key -> "https")
                .orElse("http");
        String serverPort = env.getProperty("server.port");
        String path = Optional.ofNullable(env.getProperty("server.servlet.path"))
                .filter(StringUtils::isNotBlank)
                .orElse("/");
        String host = "localhost";

        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("Falling determined the hostname");
        }

        log.info(
                "\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                path,
                protocol,
                host,
                serverPort,
                path,
                env.getActiveProfiles()
        );
    }
}


