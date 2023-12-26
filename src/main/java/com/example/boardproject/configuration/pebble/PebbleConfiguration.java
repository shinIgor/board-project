package com.example.boardproject.configuration.pebble;


import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.attributes.methodaccess.MethodAccessValidator;
import io.pebbletemplates.pebble.attributes.methodaccess.NoOpMethodAccessValidator;
import io.pebbletemplates.pebble.extension.Extension;
import io.pebbletemplates.pebble.loader.ClasspathLoader;
import io.pebbletemplates.pebble.loader.Loader;
import io.pebbletemplates.spring.servlet.PebbleViewResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import java.util.List;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "application.pebble", name = "enabled", havingValue = "true")
@EnableConfigurationProperties(value = {PebbleProperties.class})
public class PebbleConfiguration {
    private final PebbleProperties properties;

    @Autowired(required = false)
    private List<Extension> extensions;

    @Autowired(required = false)
    private MessageSource messageSource;

    @Autowired
    public PebbleConfiguration(PebbleProperties properties) {
        log.info("--> PebbleConfiguration start.");

        this.properties = properties;
    }

    @Bean
    public Loader<?> pebbleLoader() {
        ClasspathLoader loader = new ClasspathLoader();
        loader.setCharset(properties.getEncoding());
        loader.setPrefix(stripLeadingSlash(properties.getPrefix()));
        loader.setSuffix(properties.getSuffix());
        return loader;
    }

    @Bean
    public PebbleEngine pebbleEngine() {
        PebbleEngine.Builder builder = new PebbleEngine.Builder();
        builder.loader(pebbleLoader());

        if (extensions != null && !extensions.isEmpty()) {
            builder.extension(extensions.toArray(new Extension[extensions.size()]));
        }

        if (!properties.isCache()) {
            builder.cacheActive(false);
        }

        if (properties.getDefaultLocale() != null) {
            builder.defaultLocale(properties.getDefaultLocale());
        }

        builder.strictVariables(properties.isStrictVariables());
        return builder.build();
    }

    @Bean
    public MethodAccessValidator methodAccessValidator() {
        return new NoOpMethodAccessValidator();
    }

    @Bean
    public ViewResolver viewResolver() {
        String prefix = this.properties.getPrefix();
        if (pebbleEngine().getLoader() instanceof ClasspathLoader) {
            prefix = stripLeadingSlash(prefix);
        }

        PebbleViewResolver viewResolver = new PebbleViewResolver(pebbleEngine());

        viewResolver.setContentType(properties.getContentType());
        viewResolver.setCharacterEncoding(properties.getEncoding());
        viewResolver.setCache(properties.isCache());
        viewResolver.setAllowRequestOverride(properties.isAllowRequestOverride());
        viewResolver.setAllowSessionOverride(properties.isAllowSessionOverride());
        viewResolver.setExposeRequestAttributes(properties.isExposeRequestAttributes());
        viewResolver.setExposeSessionAttributes(properties.isExposeSessionAttributes());
        viewResolver.setExposeSpringMacroHelpers(properties.isExposeSpringMacroHelpers());
        viewResolver.setRequestContextAttribute(properties.getRequestContextAttribute());
        viewResolver.setPrefix(prefix);
        viewResolver.setSuffix(properties.getSuffix());

        return viewResolver;
    }

    private static String stripLeadingSlash(String value) {
        if (null == value) {
            return null;
        }

        if (value.startsWith("/")) {
            return value.substring(1);
        }

        return value;
    }
}
