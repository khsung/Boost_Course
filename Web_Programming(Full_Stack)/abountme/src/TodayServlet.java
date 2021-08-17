

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodayServlet
 */
@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		LocalDateTime currDate= LocalDateTime.now();
		int currYear=currDate.getYear();
		int currMonth=currDate.getMonthValue();
		int currDay=currDate.getDayOfMonth();
		int currHour=currDate.getHour();
		int currMinute=currDate.getMinute();
		Formatter form = new Formatter();
		form.format("현재시간 : %d/%d/%d %d:%d", currYear,currMonth,currDay,currHour,currMinute);
		
		out.print("<html><body>");
		out.print("<a href='index.html'>메인화면</a><br><br><br><br><br>");
		out.print("<h1>"+form+"</h1>");
		out.print("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
