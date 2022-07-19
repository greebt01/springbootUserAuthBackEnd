package com.greene.userauth.Controller;

import com.greene.userauth.Model.People;
import com.greene.userauth.Service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/peoples")
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService){
        super();
        this.peopleService=peopleService;
    }
    @PostMapping()
    public ResponseEntity<People> savePeople(@RequestBody People people){
        return new ResponseEntity<People>(peopleService.savePeople(people), HttpStatus.CREATED);
    }
    @GetMapping
    public List<People> getAllPeople(){ return peopleService.getAllPeople();}

    @GetMapping("{user_Name}")
    public ResponseEntity<People> getPeopleById(@PathVariable("user_Name") String userName){
        return new ResponseEntity<People>(peopleService.getPeopleById(userName), HttpStatus.OK);
    }
    @PutMapping("{user_Name}")
    public ResponseEntity<People> updatePeople(@PathVariable("user_Name") String userName,
                                               @RequestBody People people){
        return new ResponseEntity<People>(peopleService.updatePeople(people, userName),
                HttpStatus.OK);
    }
    @DeleteMapping("{user_Name}")
    public ResponseEntity<String> deletePeople(@PathVariable("user_Name") String userName){
        peopleService.deletePeople(userName);
        return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
    }
}
