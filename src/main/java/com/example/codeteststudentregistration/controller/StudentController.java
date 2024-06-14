package com.example.codeteststudentregistration.controller;

import com.example.codeteststudentregistration.entity.Student;
import com.example.codeteststudentregistration.service.ReportService;
import com.example.codeteststudentregistration.service.StudentService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ReportService reportService;

    @GetMapping({"/", "viewStudentList"})
    public String viewAllStudent(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", studentService.getAllStudents());
        model.addAttribute("message", message);
        return "ViewStudentList";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());

        return "AddStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student, RedirectAttributes redirectAttributes) {
        if(studentService.saveOrUpdateStudent(student)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewStudentList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addStudent";
    }

    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));

        return "EditStudent";
    }

    @PostMapping("/editSaveStudent")
    public String editSaveToDoItem(Student student, RedirectAttributes redirectAttributes) {
        if(studentService.saveOrUpdateStudent(student)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewStudentList";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editStudent/" + student.getId();
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteToDoItem(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (studentService.deleteStudent(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/viewStudentList";
        }

        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/viewStudentList";
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }

}
