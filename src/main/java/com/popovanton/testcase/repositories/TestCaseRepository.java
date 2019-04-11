package com.popovanton.testcase.repositories;

import com.popovanton.testcase.model.TestCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestCaseRepository extends CrudRepository<TestCase, Long> {


}
