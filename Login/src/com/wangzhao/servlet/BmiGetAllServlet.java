package com.wangzhao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wangzhao.entity.AllUser;
import com.wangzhao.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class BmiGetAllServlet
 */
@WebServlet("/BmiGetAllServlet")
public class BmiGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmiGetAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		AllUser allUser = new AllUser();
		try {
			
			BusinessServiceImpl businessServiceImpl = new BusinessServiceImpl();
			allUser.setUsers(businessServiceImpl.getAllUser());
			allUser.setCode(AllUser.SUCCESS);
			
			Gson gson = new Gson();
			String result = gson.toJson(allUser,AllUser.class);
			response.getWriter().write(result);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			allUser.setCode(AllUser.FAIlED);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
