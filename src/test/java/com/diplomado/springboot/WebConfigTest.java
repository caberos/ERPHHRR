package com.diplomado.springboot;

import com.diplomado.springboot.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.mockito.Mockito.*;

@EnableWebMvc
public class WebConfigTest {

    @InjectMocks
    private WebConfig webConfig;

    @Test
    public void testCorsMappings() {
        MockitoAnnotations.initMocks(this);

        CorsRegistry corsRegistry = mock(CorsRegistry.class);

        webConfig.addCorsMappings(corsRegistry);

        verify(corsRegistry, times(1)).addMapping("/**")
                .allowedOrigins("*").allowedOrigins("*")
                .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS", "HEAD")
                .allowedHeaders("*")
                .maxAge(3600L);
        ;
    }
}
