package com.changli.aop.repository;

import com.changli.aop.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
    Coffee findCoffeeByName(String name);
}
