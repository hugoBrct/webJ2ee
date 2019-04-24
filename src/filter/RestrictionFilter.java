package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RestrictionFilter implements Filter {

    public static final String ACCES_PUBLIC     = "/login";
    public static final String ATT_SESSION_USER = "user";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //Recup la session
        HttpSession session = request.getSession();

        //Check si session user existe
        if(session.getAttribute(ATT_SESSION_USER) == null){
            response.sendRedirect(request.getContextPath() + ACCES_PUBLIC);
        }else{
            //affiche la page restreinte
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
