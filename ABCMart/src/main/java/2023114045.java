//ADIB SYAHMI BIN AZMAN
//M3CDCS2664A

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.io.BufferedInputStream;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        

        // Declarations
        DecimalFormat df = new DecimalFormat("0.00");
        double subtotal = 0.00, total = 0.00 , fruitTotal = 0.00, vegetablesTotal = 0.00, householdTotal = 0.00, dairyTotal = 0.00;
        
        //retrieve input value parameter value (7 marks)
        String ICNo = request.getParameter("identification");
        String contactNo = request.getParameter("contact");
        String discVoucher = request.getParameter("voucher");
        int fruitQuantity = Integer.parseInt(request.getParameter("fruitQuantity"));
        int vegetableQuantity = Integer.parseInt(request.getParameter("vegetablesQuantity"));
        int householdQuantity = Integer.parseInt(request.getParameter("householdQuantity"));
        int dairyQuantity = Integer.parseInt(request.getParameter("dairyQuantity"));
        
        //calculate total for each category 
        fruitTotal = fruitQuantity*5.00;
        vegetablesTotal = vegetableQuantity *3.00;
        householdTotal = householdQuantity *7.00;
        dairyTotal = dairyQuantity *15.00;
        
        //calculate subtotal 
        subtotal = fruitTotal + vegetablesTotal + householdTotal + dairyTotal;
        
        //total after discount
        if (discVoucher.equals("GROCERY10")) {
            total = subtotal * 0.9;
        }
        
        //display output in html
        out.println("<!DOCTYPE html><html><body>");
        out.println("<html>");
        out.println("<head><title>ABC Mart Order Summary</title></head>");
        out.println("<body>");
        out.println("<h1>ABC Mart</h1>");
        out.println("<h2>Order Summary</h2>");
        out.println("I/C No: " + ICNo + "");
        out.println("<p>Contact No: " + contactNo + "</p>");
        out.println("<p>Fruits:" + df.format(5.00) + " x " + fruitQuantity + " = " + df.format(fruitTotal) + "</p>");
        out.println("<p>Vegetables:" + df.format(3.00) + " x " + vegetableQuantity + " = " + df.format(vegetablesTotal) + "</p>");
        out.println("<p>Household:" + df.format(7.00) + " x " + householdQuantity + " = " + df.format(householdTotal) + "</p>");
        out.println("<tr><td>Dairy:" + df.format(15.00) + " x " + dairyQuantity + " = " + df.format(dairyTotal) + "</p>");
        out.println("<p>Subtotal: RM " + df.format(subtotal) + "</p>");
        out.println("<p>Total: RM " + df.format(total) + "</p>");
        out.println("<p>------------------------------</p>");
        out.println("<p>-- Thank You! --</p>");
        out.println("</body>");
        out.println("</html>");
	}

}
