import database.Student;
import database.StudentServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) throws SQLException {
        StudentServiceImpl ssi = new StudentServiceImpl();

        /* ADD STUDENT */

        System.out.println(ssi.addStudent(new Student("Steve", "Jackson", "Miller",
                "RT-201", 2020)) ? "Student was added successfully!" : "Failed.");
        System.out.println(ssi.addStudent(new Student("Linda", "McCortney", "Paul",
                "RT-215", 2021)) ? "Student was added successfully!" : "Failed.");
        System.out.println(ssi.addStudent(new Student("Tatiana", "Evans", "Cristina",
                "RT-214", 2021)) ? "Student was added successfully!" : "Failed.");

        /* DELETE STUDENT */

        /*ssi.deleteStudent(4);*/

        /* GET ALL */

        /*System.out.println(ssi.getAll());*/


        /* GET BY NAME */

        System.out.println(ssi.getByName("Linda"));

        /* GET BY IDS */
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(2);
        ids.add(3);
        System.out.println(ssi.getByIds(ids));
    }
}
