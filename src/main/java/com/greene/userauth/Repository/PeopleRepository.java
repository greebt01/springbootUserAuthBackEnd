package com.greene.userauth.Repository;

import com.greene.userauth.Model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, String>{
}
