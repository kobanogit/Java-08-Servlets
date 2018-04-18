package org.wcs.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SimpleHelloServlet2", urlPatterns = {"/custom-hello.html", "/hello-form.html"})
public class SimpleHelloServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Par défaut url de redirection vers la page du formulaire si erreur
        String urlForward = "/hello-form.jsp";

        // Prepare messages.
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);

        // Get and validate first name.
        String fname = request.getParameter("fname");
        if (fname == null || fname.trim().isEmpty()) {
            messages.put("fname", "Please enter first name");
        } else if (!fname.matches("\\p{Alnum}+")) {
            messages.put("fname", "Please enter alphanumeric characters only");
        }
//
//        // Get and validate last name.
        String lname = request.getParameter("lname");
        if (lname == null || lname.trim().isEmpty()) {
            messages.put("lname", "Please enter last name");
        } else if (!lname.matches("\\p{Alnum}+")) {
            messages.put("lname", "Please enter alphanumeric characters only");
        }

        String setHour = request.getParameter("hour");
        setHour = (setHour.split(":"))[0];
        String salute = (Integer.parseInt(setHour) < 12) ?
                "Good morning" : (Integer.parseInt(setHour) > 20) ? "Good night" : "Good afternoon";
//
//        // No validation errors? Do the business job!
        if (messages.isEmpty()) {
            urlForward = "/custom-hello.jsp";
            messages.put("success", String
                    .format("%s !<br />Your first name is %s and your last name is %s!", salute, fname, lname));
        }

        request.getRequestDispatcher(urlForward)
                .forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/hello-form.jsp").forward(request, response);
    }
}
