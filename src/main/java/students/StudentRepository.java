package students;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class StudentRepository {
    private final DataSource dataSource;

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void create(Student student) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            String sql = "insert into student (id, first_name, last_name, email) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }

    protected List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select id, first_name, last_name, email from student order by last_name";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString("id"),
                        firstName = resultSet.getString("first_name"),
                        lastName = resultSet.getString("last_name"),
                        email = resultSet.getString("email");
                Student student = Student.builder().id(id).firstName(firstName).lastName(lastName).email(email).build();
                students.add(student);
            }
        } finally {
            close(connection, statement, resultSet);
        }
        return students;
    }

    protected Student findById(String id) throws SQLException {
        Student student;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select id, first_name, last_name, email from student where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name"),
                        lastName = resultSet.getString("last_name"),
                        email = resultSet.getString("email");
                student = Student.builder().id(id).firstName(firstName).lastName(lastName).email(email).build();
            } else throw new SQLException("Student not found, id:" + id);
        } finally {
            close(connection, statement, resultSet);
        }
        return student;
    }

    public void update(Student student) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            String sql = "update student set first_name = ?, last_name = ?, email = ? where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getId());
            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }


    public void delete(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            String sql = "delete from student where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }
}