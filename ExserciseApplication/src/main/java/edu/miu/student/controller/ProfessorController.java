package edu.miu.student.controller;

import edu.miu.student.domain.Phone;
import edu.miu.student.domain.Professor;
import edu.miu.student.service.PhoneService;
import edu.miu.student.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProfessorController {
    @Autowired
    private ProService proService;
    @Autowired
    private PhoneService phoneService;


    @GetMapping("/pro")
    public String getpro(){
        return "forward:/enterform";
    }
    @GetMapping("/enterform")
    public String proform(@ModelAttribute("pro") Professor professor,Model model )
    {
//        model.addAttribute("pro",new Professor());
        List<Phone> phoneslist=phoneService.findAll();
        model.addAttribute("phones",phoneslist);
        //return "prohome";
        return "urlforedit";

    }
    @PostMapping(value = "/sav")
    public String prodata(@Valid @ModelAttribute("pro") Professor professor, BindingResult re) {
        // professor.setAge();
        System.out.println("===============here  i am");
        System.out.println(professor.toString());
        if (re.hasErrors()) {
            return "prohome";
        }
        System.out.println("==============am also here");
        proService.save(professor);
        System.out.println("==============");
        System.out.println(professor);

        return "congrats";

    }
    @GetMapping("/list")
    public String getAll(Model model) {
        List<Professor> professors = proService.findAll();
        model.addAttribute("pros", professors);
        System.out.println(professors);
        return "prolist";
    }

    @GetMapping("/proedit/{proid}")
    public String editdata(@PathVariable Long proid,Model model){
        Professor professor=proService.findById(proid);
        if(professor.equals(null)){
            return null;
        }
        model.addAttribute("proobject",professor);
        return "editForm";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Professor professor){
        proService.save(professor);
        return "congrats";
    }
}
