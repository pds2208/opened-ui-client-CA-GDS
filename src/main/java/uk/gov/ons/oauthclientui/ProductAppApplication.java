package uk.gov.ons.oauthclientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
public class ProductAppApplication {

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

    public ProductAppApplication() {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) ->
                hostname.equals("localhost"));
    }

}

