package sait.ca.calculators.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ibrahim
 */

@WebServlet(name = "AgeCalculatorServlet", urlPatterns = {"/age"})
public class AgeCalculatorServlet extends HttpServlet {


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
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        
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
        
        // Very that data is being forwarded.
        boolean hasData = (
            request.getParameter("age_inpt") != null &&
            request.getParameter("age_inpt").length() > 0
        );    
        
        if (!hasData)  {
            request.setAttribute("message", "You must give your current age");
        }else {
            
            String strAge = request.getParameter("age_inpt");
            System.out.println("Got following input: " + strAge);
            // Check for improper input (non-numerical)
            
            boolean invalidData = false;
            
            try{
                Integer.parseInt(strAge);
            }catch(NumberFormatException ex) {
                request.setAttribute("message", "Invalid age provided ");
                invalidData = true;
            }
            
            if (!invalidData) {
                int parsedAge = Integer.parseInt(strAge);

                String newAge = String.valueOf(parsedAge + 1);
                request.setAttribute("message", "Your age next birthday " + newAge);    
            }
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);

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
