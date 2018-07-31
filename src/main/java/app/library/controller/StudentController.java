package app.library.controller;

import app.library.model.Student;
import app.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getStudents(Model model) {
        List<Student> students = studentRepository.getStudens();
        model.addAttribute("students", students);
        return "listStudents";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String addStudent() {
        return "addStudent";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addStudent(@RequestParam("name") String name, @RequestParam("age") String age,
                             @RequestParam("admin") Boolean admin) {
        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setAdmin(admin);
        student.setCreateddate();
        studentRepository.addStudent(student);
        return "redirect:/student/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/del/{id}")
    public String delStudent(@PathVariable(value = "id") Integer id) {
        studentRepository.delStudent(id);
        return "redirect:/student/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String updateStudent(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("student", studentRepository.getStudentById(id));
        return "editStudent";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String updateStudent(@PathVariable(value = "id") Integer id, @RequestParam("name") String name,
                                @RequestParam("age") String age, @RequestParam("admin") Boolean admin) {
        Student student = studentRepository.getStudentById(id);
        student.setAdmin(admin);
        student.setAge(Integer.parseInt(age));
        student.setName(name);
        studentRepository.editStudent(student);
        return "redirect:/student/";
    }


}
