package com.github.maikoncanuto.resources.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1")
@OpenAPIDefinition(
        info = @Info(
                description = "Serviço para indicadores econômicos de situação de extrema pobreza",
                title = "World Bank API",
                version = "0.0.1",
                contact = @Contact(
                        name = "Maikon Canuto",
                        email = "maikoncanuto@gmail.com",
                        url = "http://github.com/Maikoncanuto"
                )
        )
)
public class ApplicationResource extends Application {
}
