package com.marqo404.javajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.marqo404.javajax.dao.GroupDAO;
import com.marqo404.javajax.model.Group;

@WebServlet("/GroupController")
public class GroupController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		switch (action) {
			case "getList":
				response.setContentType("application/json;charset=utf-8");
				try {
					out.println(getList());
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					out.close();
				}
				break;
		}
	}
	
	public String getList() throws ClassNotFoundException, SQLException {
		GroupDAO groupDAO = new GroupDAO();
		List<Group> groups = groupDAO.list();
		return new Gson().toJson(groups);
	}
}
