package com.har.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.har.entity.Book;
import com.har.utility.HibernateUtil;


@WebServlet("/bookAction")
public class BookControllerServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void init() throws ServletException {
	}
	
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  String bookId = request.getParameter("bookId");
				System.out.println("bookId   :"+bookId);
			    String bookName =getBookName(Integer.parseInt(bookId));
			     System.out.println("bookName:"+bookName);
			     if(bookName!=null && !bookName.isEmpty()){
			    	 request.setAttribute("bookName", bookName);
	                RequestDispatcher rd= 		request.getRequestDispatcher("/show_result.jsp");
	                rd.forward(request, response);
			     }else{
			    	 request.setAttribute("bookName", "No Data");
			    	    RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
						rd.forward(request,response);
			     }
			
		}//try
		catch(HibernateException he) {
			RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
			rd.forward(request,response);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        doGet(req,res);
	}
	
	@Override
	public void destroy() {
	}


	/** These method is used to get bookName
	 * @param bookId
	 * @return
	 */
	private String getBookName(Integer bookId){
		    String bookName =null;
			
			try(Session session =HibernateUtil.getSession()){
				Book    book                      = null;
				book=session.get(Book.class, bookId);
				bookName=book.getBookName();
				System.out.println("BookName is "+bookName+" of given  Id is..."+bookId);
			}catch (Exception e) {
				 e.printStackTrace();
			}finally {
				  //Close SessionFactory
				  //HibernateUtil.closeSessionFactory();
			}
		return bookName;
	}
}
