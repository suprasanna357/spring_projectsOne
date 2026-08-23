package studentregistration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

  
    public Student registerStudent(Student student) {

        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                throw new DuplicateStudentException(
                        "Student ID " + student.getStudentId() + " already exists");
            }
        }

        students.add(student);

        return student;
    }

   
    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {
                return student;
            }
        }

        throw new StudentNotFoundException(
                "Student with ID " + id + " not found");
    }

    public String deleteStudent(int id) {

        Student student = getStudentById(id);

        students.remove(student);

        return "Student registration deleted successfully";
    }
}
