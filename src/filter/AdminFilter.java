package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

/**
 * Servlet Filter implementation class Admin
 */
//@WebFilter({"/admin/*","/login"})
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String loginURI = req.getContextPath() + "/login";
        String homeURI = req.getContextPath() + "/admin/userManager";
        User user = (User)session.getAttribute("user");

        if(((HttpServletRequest)request).getServletPath().equals("/login")) {
            if( ((HttpServletRequest)request).getParameter("logout") == null &&
                    user != null && user.getRole().equals("admin")) {
                System.out.printf("AdminFilter: %s est d�j� connect�, redirection vers %s%n", user.getEmail(), homeURI);
                res.sendRedirect(homeURI);
                return;
            } else {
                chain.doFilter(req, res);
            }
        }else if(user != null && user.getRole().equals("admin")) {
            chain.doFilter(req, res);
        }else {
            System.out.printf("AdminFilter: l'User n'a pas les droits, redirection vers %s%n", loginURI);
            res.sendRedirect(loginURI);
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
