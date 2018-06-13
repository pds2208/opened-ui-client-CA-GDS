package uk.gov.ons.oauthclientui.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Intercept the call to /login to pick up any error code.
 * If the code is 123 (cancel authentication), redirect back to the index otherwise it will go back to the
 * CA login page in a never-ending loop. Let all other codes thru for now.
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CAFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(CAFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String url = ((HttpServletRequest)request).getRequestURL().toString();
        if (!url.endsWith("login")) {
            chain.doFilter(request, response);
            return;
        }

        String err = request.getParameter("x-ca-err");

        if (err != null && err.equals("3001123")) {
            String redirectTo =  request.getServletContext().getContextPath() + "/";
            logger.debug("Login was cancelled by the user, redirecting to: " + redirectTo);
            ((HttpServletResponse)response).sendRedirect(redirectTo);
        } else {
            chain.doFilter(request, response);
        }
    }
}
