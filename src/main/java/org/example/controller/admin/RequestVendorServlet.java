package org.example.controller.admin;

/* *
 *
 * @author Java Programming with Aldrin
 */

import org.example.DB.AdminDAO;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Vendor;

@WebServlet("/admin/requestVendor")
public class RequestVendorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO =new AdminDAO();

    // add new vendor
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String password = mail;
        Vendor newVendor = new Vendor(mail, password);
        try {
            adminDAO.requestNewVendor(newVendor);
            System.out.println("Vendor requested: " + mail);
            response.sendRedirect("admin-display.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("request-vendor.jsp").forward(request, response);
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getServletPath();
//
//        try {
//            switch (action) {
//                case "/new":
//                    showNewForm(request, response);
//                    break;
//                case "/insert":
//                    insertUser(request, response);
//                    break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
//                default:
//                    listUser(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//    }
//
//    private void listUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<User> listUser = userDAO.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User existingUser = userDAO.selectUser(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        request.setAttribute("user", existingUser);
//        dispatcher.forward(request, response);
//    }
//
//    private void insertUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        User newUser = new User(name, email, country);
//        userDAO.insertUser(newUser);
//        response.sendRedirect("list");
//    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//
//        User book = new User(id, name, email, country);
//        userDAO.updateUser(book);
//        response.sendRedirect("list");
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        userDAO.deleteUser(id);
//        response.sendRedirect("list");
//    }
}