package database;

public class SQLElements {
    protected static final String SQL_DELETE = "DELETE FROM students WHERE student_id = ?";
    protected static final String SQL_INSERT = "INSERT INTO students (student_name, student_surname, student_patronymic, " +
            "student_group, student_admission_year) VALUES (?, ?, ?, ?, ?)";
    protected static final String SQL_SELECT = "SELECT * FROM students";

    protected static final String STUDENT_ID_FIELD = "student_id";
    protected static final String STUDENT_NAME_FIELD = "student_name";
    protected static final String STUDENT_SURNAME_FIELD = "student_surname";
    protected static final String STUDENT_PATRONYMIC_FIELD = "student_patronymic";
    protected static final String STUDENT_GROUP_FIELD = "student_group";
    protected static final String STUDENT_ADMISSION_YEAR_FIELD = "student_admission_year";
}
