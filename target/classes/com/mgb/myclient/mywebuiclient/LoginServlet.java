package com.mgb.myclient.mywebuiclient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.glassfish.osgicdi.OSGiService;
import org.osgi.framework.ServiceException;

import com.mgb.myclient.common1.UserAuthService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject @OSGiService(dynamic=true)
	private UserAuthService uas;
	

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Login Response..");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		try{
			
			if(uas.login(name, password)){
				
				out.println("welcome" + name );
				
			}else {
				
				out.println("incorrect Username password.." );
			}
		
		} catch(ServiceException ex){
			
			out.println("Service is not yet available.." );
		}
		
		
		
		
		
	}

}
