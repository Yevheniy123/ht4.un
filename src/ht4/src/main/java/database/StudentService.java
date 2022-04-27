package database;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);
    boolean deleteStudent(int id);
    List<Student> getAll() throws SQLException;
    List<Student> getByName(String name) throws SQLException;
    List<Student> getByIds(List<Integer> ids);
}
