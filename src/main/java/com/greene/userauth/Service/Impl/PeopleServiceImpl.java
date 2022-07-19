package com.greene.userauth.Service.Impl;

import com.greene.userauth.Model.People;
import com.greene.userauth.Repository.PeopleRepository;
import com.greene.userauth.Service.PeopleService;
import com.greene.userauth.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    private PeopleRepository peopleRepository;
    public PeopleServiceImpl(PeopleRepository peopleRepository){
        super();
        this.peopleRepository=peopleRepository;
    }
    @Override
    public People savePeople(People people) {
        return peopleRepository.save(people);
    }

    @Override
    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    @Override
    public People getPeopleById(String userName) {
        return peopleRepository.findById(userName).orElseThrow(()->
                new ResourceNotFoundException("User", "userName", userName));
    }

    @Override
    public People updatePeople(People people, String userName) {
        People existingPeople=peopleRepository.findById(userName).orElseThrow(
                ()-> new ResourceNotFoundException("User", "userName", userName));
        existingPeople.setPword(people.getPword());
        return existingPeople;
    }

    @Override
    public void deletePeople(String userName) {
        peopleRepository.findById(userName).orElseThrow(()->
                new ResourceNotFoundException("user_Name", "pword", userName));
        peopleRepository.deleteById(userName);
    }
}
