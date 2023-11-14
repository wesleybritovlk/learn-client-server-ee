package students;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private StudentRepository repository;
    @Resource(name = "jdbc/students")
    private DataSource dataSource;

    public StudentController() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            repository = new StudentRepository(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String command = req.getParameter("command");
            if (command == null) command = "";
            switch (command) {
                case "post" -> post(req, resp);
                case "get" -> getById(req, resp);
                case "put" -> put(req, resp);
                case "delete" -> delete(req, resp);
                default -> getAll(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    private void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String firstName = req.getParameter("firstName"), lastName = req.getParameter("lastName"), email = req.getParameter("email");
        Student student = Student.builder().id(UUID.randomUUID().toString()).firstName(firstName).lastName(lastName).email(email).build();
        repository.create(student);
        getAll(req, resp);
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Student> students = repository.findAll();
        req.setAttribute("students", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/students.jsp");
        dispatcher.forward(req, resp);
    }

    private void getById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Student student = repository.findById(id);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/put.jsp");
        dispatcher.forward(req, resp);
    }

    private void put(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id"), firstName = req.getParameter("firstName"), lastName = req.getParameter("lastName"), email = req.getParameter("email");
        Student student = Student.builder().id(id).firstName(firstName).lastName(lastName).email(email).build();
        repository.update(student);
        getAll(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        repository.delete(id);
        getAll(req, resp);
    }
}