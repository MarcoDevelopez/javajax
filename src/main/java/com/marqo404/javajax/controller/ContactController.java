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
import com.marqo404.javajax.dao.ContactDAO;
import com.marqo404.javajax.model.Contact;

@WebServlet("/ContactController")
public class ContactController extends HttpServlet {

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
			case "getListByGroupId":
				response.setContentType("application/json;charset=utf-8");
				try {
					String groupId = request.getParameter("groupId");
					out.println(getListByGroupId(Integer.parseInt(groupId)));
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					out.close();
				}
				break;
		}
		
	}
	
	public String getList() throws ClassNotFoundException, SQLException {
		ContactDAO contactDAO = new ContactDAO();
		List<Contact> contacts = contactDAO.list();
		return new Gson().toJson(contacts);
	}
	
	public String getListByGroupId(Integer groupId) throws ClassNotFoundException, SQLException {
		ContactDAO contactDAO = new ContactDAO();
		List<Contact> contacts = contactDAO.getByGroupId(groupId);
		return new Gson().toJson(contacts);
	}
}
