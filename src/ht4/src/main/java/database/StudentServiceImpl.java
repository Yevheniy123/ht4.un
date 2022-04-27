package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static database.SQLElements.*;

public class StudentServiceImpl implements StudentService {
    private final Connection CONNECTION;

    public StudentServiceImpl() throws SQLException {
        CONNECTION = DBConnection.getDBConnection();
    }

    @Override
    public boolean addStudent(Student student) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = CONNECTION.prepareStatement(SQL_INSERT + ";");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPatronymic());
            preparedStatement.setString(4, student.getGroup());
            preparedStatement.setInt(5, student.getAdmissionYear());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println("It is not possible to execute query and refresh the table!");
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = CONNECTION.prepareStatement(SQL_DELETE + ";");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println("It is not possible to execute query and refresh the table!");
        }
        return false;
    }

    @Override
    public List<Student> getAll() {
        Statement statement;
        ResultSet resultSet;
        List<Student> students = new ArrayList<>();

        try {
            statement = CONNECTION.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT + ";");

            while(resultSet.next()) {
                String studentName = resultSet.getString(STUDENT_NAME_FIELD);
                String studentSurname = resultSet.getString(STUDENT_SURNAME_FIELD);
                String studentPatronymic = resultSet.getString(STUDENT_PATRONYMIC_FIELD);
                String studentGroup = resultSet.getString(STUDENT_GROUP_FIELD);
                int studentAdmissionYear = resultSet.getInt(STUDENT_ADMISSION_YEAR_FIELD);
                students.add(new Student(studentName, studentSurname, studentPatronymic,
                        studentGroup, studentAdmissionYear));
            }

            statement.close();
            return students;
        } catch (SQLException e) {
            System.err.println("It is not possible to execute query and refresh the table!");
            return null;
        }
    }

    @Override
    public List<Student> getByName(String name) {
        Statement statement;
        ResultSet resultSet;
        List<Student> studentsByName = new ArrayList<>();

        try {
            statement = CONNECTION.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT + " WHERE " + STUDENT_NAME_FIELD +
                    " = \"" + name + "\";");

            while (resultSet.next()) {
                String studentName = resultSet.getString(STUDENT_NAME_FIELD);
                String studentSurname = resultSet.getString(STUDENT_SURNAME_FIELD);
                String studentPatronymic = resultSet.getString(STUDENT_PATRONYMIC_FIELD);
                String studentGroup = resultSet.getString(STUDENT_GROUP_FIELD);
                int studentAdmissionYear = resultSet.getInt(STUDENT_ADMISSION_YEAR_FIELD);

                studentsByName.add(new Student(studentName, studentSurname, studentPatronymic,
                        studentGroup, studentAdmissionYear));
            }

            statement.close();
            return studentsByName;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("It is not possible to execute query and refresh the table!");
            return null;
        }
    }

    @Override
    public List<Student> getByIds(List<Integer> ids) {
        Statement statement;
        ResultSet resultSet;
        List<Student> studentsByIds = new ArrayList<>();

        try {
            statement = CONNECTION.createStatement();
            for (Integer id : ids) {
                resultSet = statement.executeQuery(SQL_SELECT + " WHERE " + STUDENT_ID_FIELD + " = " + id);
                while (resultSet.next()) {
                    String studentName = resultSet.getString(STUDENT_NAME_FIELD);
                    String studentSurname = resultSet.getString(STUDENT_SURNAME_FIELD);
                    String studentPatronymic = resultSet.getString(STUDENT_PATRONYMIC_FIELD);
                    String studentGroup = resultSet.getString(STUDENT_GROUP_FIELD);
                    int studentAdmissionYear = resultSet.getInt(STUDENT_ADMISSION_YEAR_FIELD);

                    studentsByIds.add(new Student(studentName, studentSurname, studentPatronymic,
                            studentGroup, studentAdmissionYear));
                }
            }

            statement.close();
            return studentsByIds;
        } catch (SQLException e) {
            System.err.println("It is not possible to execute query and refresh the table!");
            return null;
        }
    }
}
