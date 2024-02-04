package Retrivingalldata;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
@WebServlet("/showing")
public class Showingalldataindb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		ArrayList<Pojo2> objecs = new ArrayList<Pojo2>();
		out.print("<h1>THIS IS ALL THE DATA PRESENT IN DB</h1>");try {
		     Connection con;
			con=HelperClass.putConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from playground ;");
		    ResultSet rs = pstmt.executeQuery(); 
		while(rs.next()){    
			Pojo2 obj= new Pojo2();
		      obj.setEquip_id(rs.getInt(1));
		      obj.setType(rs.getString(2));
		      obj.setColor(rs.getString(3));
		      obj.setLocation(rs.getString(4));
		      obj.setInstall_date(rs.getDate(5));
		          objecs.add(obj);}}
		catch(Exception e) {
			e.printStackTrace();}
		String json = new Gson().toJson(objecs);  
		out.println("<a href=showing.html>SHOW ALL DATA IN DATABASE</a>");
		out.print(json);
		
 }}