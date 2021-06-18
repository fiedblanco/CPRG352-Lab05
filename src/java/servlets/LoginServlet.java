/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domains.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author 854276
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //this will display the requested JSP as a view
 String logout = request.getParameter("logout");
        HttpSession session = request.getSession();
        
        
        String usernameSession = (String) session.getAttribute("sessionObject");
        
        if(usernameSession != null && logout == null )
        {
        
          getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);        
        }

       

        if (logout != null) {

            session.invalidate();
            request.setAttribute("slogoutmessage", "You have Sucessfully logged out");
            session = request.getSession();

        }
        
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

         User user = new User(username, password);
         request.setAttribute("user", user);
        
        HttpSession session = request.getSession();
        if (username == null || username.equals("") || password == null || password.equals("")) {

            request.setAttribute("logoutmessage", "Invalid login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else {

            AccountService account = new AccountService();
            System.out.println("do post is working");
        
           
            if (account.login(username, password) != null) {
                response.sendRedirect("home");
                session.setAttribute("sessionObject", username);

            } else {
                request.setAttribute("logoutmessage", "Invalid login");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

            }
        }
    }
}
