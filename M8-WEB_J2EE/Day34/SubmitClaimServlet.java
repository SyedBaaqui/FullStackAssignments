package com.ClaimInsurance;
//task-1(2)
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitClaim")
public class SubmitClaimServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String policyNumber = request.getParameter("policyNumber");
        String claimAmount = request.getParameter("claimAmount");
        String description = request.getParameter("description");

        ClaimBean claim = new ClaimBean();
        claim.setPolicyNumber(policyNumber);
        claim.setClaimAmount(claimAmount);
        claim.setDescription(description);

        request.setAttribute("claim", claim);
        request.getRequestDispatcher("/confirmClaim.jsp").forward(request, response);
    }
}

