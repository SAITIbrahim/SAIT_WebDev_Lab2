package sait.ca.calculators.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ibrahim
 */

@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculatorservlet.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Check if values are provided
        boolean hasData = (
            request.getParameter("user_first_input") != null &&
            request.getParameter("user_first_input").length() > 0 &&
            request.getParameter("user_second_input") != null &&
            request.getParameter("user_second_input").length() > 0
        );    
        
        if (!hasData) {
            request.setAttribute("message", "Data missing from input!");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculatorservlet.jsp").forward(request, response);
            return;
        }
        
        // Check if data are valid integers
        String input_one = request.getParameter("user_first_input");
        String input_two = request.getParameter("user_second_input");        
        
        int parsed_one = 0;
        int parsed_two = 0;
        
        boolean isInvalid = false;
        
        try {
            parsed_one = Integer.parseInt(input_one);
            parsed_two = Integer.parseInt(input_two);
        }catch(NumberFormatException err) {
            isInvalid = true;
        }
        
        // Report invalid data
        if (isInvalid) {
            request.setAttribute("message", "Invalid numbers provided!");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculatorservlet.jsp").forward(request, response);
            return;
        }
        
        // Process operator
        int chosenOperator = 0;
        final String operators[] = {"+", "-", "*", "%"};

        for (int x = 0; x < 4; x++) {
            if (operators[x].equals(request.getParameter("operator"))) {
                chosenOperator = x;
                break;
            }
        }
        
        // Execute operation
        double outputValue = 0;
        switch(chosenOperator) {
            case 0: // Addition
                outputValue = parsed_one + parsed_two;
                break;
            case 1: // Subtraction
                outputValue = parsed_one - parsed_two;
                break;
            case 2: // Multiplication
                outputValue = parsed_one * parsed_two;
                break;
            case 3: // Modulus
                outputValue = parsed_one % parsed_two;
                break;
        }
        
        // Apply output value and return to the user
        request.setAttribute("message", outputValue);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculatorservlet.jsp").forward(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
