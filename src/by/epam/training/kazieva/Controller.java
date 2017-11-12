package by.epam.training.kazieva;

import by.epam.training.kazieva.DAO.DAO;
import by.epam.training.kazieva.entity.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller extends javax.servlet.http.HttpServlet {
    public Controller(){
        super();
    }
    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        List<Person> personList = new ArrayList<Person>();
        personList = null;
        try {
            personList = DAO.searchByNameAndSurname(name, surname);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("personList", personList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/person.jsp");
        dispatcher.forward(request, response);
    }
}
