package database;

public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private String group;
    private int admissionYear;

    public Student(String name, String surname, String patronymic, String group, int admissionYear) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.group = group;
        this.admissionYear = admissionYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    @Override
    public String toString() {
        return "Student {\n" +
                "\tname='" + name + "',\n" +
                "\tsurname='" + surname + "',\n" +
                "\tpatronymic='" + patronymic + "',\n" +
                "\tgroup='" + group + "',\n" +
                "\tadmissionYear=" + admissionYear + "\n" +
                '}';
    }
}
