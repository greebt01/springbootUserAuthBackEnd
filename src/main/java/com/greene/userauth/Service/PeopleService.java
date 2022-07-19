package com.greene.userauth.Service;

import com.greene.userauth.Model.People;

import java.util.List;

public interface PeopleService {
    People savePeople(People people);
    List<People> getAllPeople();
    People getPeopleById(String userName);
    People updatePeople(People people, String userName);
    void deletePeople(String userName);
}
