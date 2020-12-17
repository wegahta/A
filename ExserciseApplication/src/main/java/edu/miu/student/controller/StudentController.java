package edu.miu.student.controller;

import edu.miu.student.domain.Exceptions.UserNotFoundException;
import edu.miu.student.domain.Student;
import edu.miu.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller

public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/")
    public String homePage(){
        return "home";
    }



    @ModelAttribute("roles")
    private Map<String,String> getRole(){
        Map<String,String> rolesMap= new HashMap<>();
        rolesMap.put("ADM","ADM");
        rolesMap.put("User","User");
        return rolesMap;

    }

    @GetMapping("/addStudent")
    public String getStudenForm(@ModelAttribute("newStudent") Student student){
        return "started";
               // "addStudenForm";
    }

    @PostMapping ("/addStudents")
    public String addStudenForm(@Valid @ModelAttribute("newStudent") Student student, BindingResult result, RedirectAttributes redirectAttributes){
        System.out.println("i was in add controller ");
        if(result.hasErrors()){
            return "started";
        }
        studentService.save(student);
        redirectAttributes.addFlashAttribute("onestudents",student);



       // model.addAttribute("student",student);

        return "redirect:/oneStudent";
    }
    @GetMapping ("oneStudent")
    public String successfulPage(){

        return "successPage";
    }

    @GetMapping ("/getAllStudent")
    public String addStudenForm(Model model){
        List<Student> allStudent= studentService.findAllStudents();
        model.addAttribute("student",allStudent);

        return "success";
    }
    @GetMapping ("/get/{id}")
    public String getStudentById(@PathVariable("id") Long id, Model model)  {
      Optional<Student> student=  studentService.findStudentById(id);
      if(student.isPresent()){
        model.addAttribute("student",student.get());
        return "oneStudentPage";
      }
      else throw new UserNotFoundException("Student with this id is not Found");



    }
//    @GetMapping("edit/{userId}")
//    public String editUStudent(@PathVariable long stuId, Model model) {
//        Optional<Student> user = studentService.findUserById(stuId);
//        if (user.isPresent()) {
//            model.addAttribute("user", user.get());
//            return "/edit";
//        }
//        return "redirect:/getAllStudent";
//    }
//    @PatchMapping (value = { "/edit"})
//    public String updateUser(@Validated @ModelAttribute("student") Student student,
//                             BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("studentEdit", bindingResult.getAllErrors());
//            return "/editStudent";
//        }
//        studentService.save(student);
//        return "redirect:/getall";
//    }
    @PatchMapping(value = {"/delete/{id}"})
    public String deleteStudentById(@PathVariable(value="id")Long id){
     studentService.deleteStudent(id);
        return "redirect:/getAllStudent";

    }

    //this is for the hint how the rest is used

//    @PostMapping(value = "/api/addCategory", produces = "application/json")
//    public Category saveCategory(@Valid @RequestBody Category category) {
//        category.setDescription("This is default description...");
//        categoryService.save(category);
//        return category;
//    }

@PostMapping(value = "/student/addStudentForm", produces = "application/json")
public @ResponseBody Student saveStudent(@Valid @RequestBody Student student) {
    //student.setDescription("This is default description...");
    System.out.println("i am at the controller");
    System.out.println(student);
    studentService.save(student);
    return student;
}

    @GetMapping("/getAjax")
    public String getAjaxStudentForm(@ModelAttribute("newStudent") Student student){
        return "ajaxsStarter";

    }


//@PostMapping(value = "/api/addCategory", produces = "application/json")
//public @ResponseBody Category saveCategory(@Valid @RequestBody Category category) {
//    category.setDescription("This is default description...");
//    categoryService.save(category);
//    return category;
//}


}
