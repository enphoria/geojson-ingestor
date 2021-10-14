package com.enphoria.geojsoningestor.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * Microservice startup class that writes by console
 *
 * @author camilocardenas
 * @date 13/10/2021
 * @since 1.0
 */

@Slf4j
public class Init implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    /**
     * Method inherited from CommandLineRunner for writing to the console
     *
     * @param args
     * @throws Exception
     * @date 13/10/2021
     * @since 1.0
     */
    @Override
    public void run(String... args) throws Exception {
        Environment env = appContext.getEnvironment();
        String protocol = "http";
        if ("true".equals(env.getProperty("server.ssl.enabled"))) {
            protocol = "https";
        }
        log.info(
                "\n--------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t" + "Local: \t\t{}://localhost:{}\n\t"
                        + "External: \t{}://{}:{}\n\t"
                        + "Root Path: \t{}\n\t"
                        + "Profile(s): \t{}\n--------------------------------------------------------",
                env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"), protocol,
                InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"),
                env.getProperty("server.servlet.context-path"),
                env.getActiveProfiles());
    }
}
