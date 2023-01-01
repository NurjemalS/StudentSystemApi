package com.nurjemal.Student.Controller;

import com.nurjemal.Student.Entity.AdvisorEntity;
import com.nurjemal.Student.Service.AdvisorService;
import com.nurjemal.Student.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class AdvisorController {

    @Autowired
    private AdvisorService advisorService;
    @Autowired
    private DepartmentService departmentService;


    // Insert an advisor for specific department
    @PostMapping("/departments/{departmentId}/advisors")
    public ResponseEntity<AdvisorEntity> createAdvisorForSpecificDepartment(@PathVariable(value = "departmentId") Long departmentId, @RequestBody AdvisorEntity advisorRequest) {

        return advisorService.createAdvisorForSpecificDepartment(departmentId, advisorRequest);
    }

    // get all advisors
    @GetMapping("/advisors")
    public List<AdvisorEntity> fetchAdvisors(){
        return advisorService.fetchAdvisors();
    }

    // Get all advisors for a specific department
    @GetMapping("/departments/{departmentId}/advisors")
    public ResponseEntity<List<AdvisorEntity>> findAdvisorEntityByDepartment_DepartmentId(@PathVariable(value = "departmentId") Long departmentId) {
        if (!departmentService.existsById(departmentId)) {
            System.out.println("Not found Department with id = " + departmentId);
        }

        List<AdvisorEntity> advisorEntities = advisorService.findByDepartmentId(departmentId);
        return new ResponseEntity<>(advisorEntities, HttpStatus.OK);
    }

    //get an advisor by id
    @GetMapping("/advisors/{advisor_id}")
    public ResponseEntity<AdvisorEntity> findAdvisorEntityById(@PathVariable("advisor_id") Long advisorId){
        AdvisorEntity advisorEntity = advisorService.findAdvisorEntityById(advisorId);
        return new ResponseEntity<>(advisorEntity, HttpStatus.OK);
    }

    // update advisor by id
    @PutMapping("/advisors/{advisor_id}")
    public AdvisorEntity updateAdisorEntityById(@PathVariable("advisor_id") Long advisorId, @RequestBody AdvisorEntity advisorEntityRequest){
        AdvisorEntity advisorEntity = advisorService.findAdvisorEntityById(advisorId);
        advisorEntity.setAdvisorName(advisorEntityRequest.getAdvisorName());
        advisorEntity.setEmail(advisorEntityRequest.getEmail());
        return advisorService.save(advisorEntity);
    }

    /*
    // delete advisor by id
    @DeleteMapping("/advisors/{advisor_id}")
    public ResponseEntity<HttpStatus> deleteAdvisorById(@PathVariable("advisor_id") Long advisorId) {
        advisorService.deleteAdvisorById(advisorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

}
