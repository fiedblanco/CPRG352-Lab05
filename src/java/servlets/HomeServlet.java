/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 854276
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();

            String usernameSession = (String) session.getAttribute("sessionObject");

            if (usernameSession == null) {
                response.sendRedirect("login");

                // getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } else {

                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

            }

        } catch (Exception e) {
            throw new ServletException(e);
        }

        // if the user session object doesnt exist then redirect to login page
        // else if the object does exist then redirect to home page
        // getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
