package com.popovanton.testcase.services;

import com.popovanton.testcase.model.Formid;
import com.popovanton.testcase.model.NotFinishedUsers;
import com.popovanton.testcase.model.OneHourActivityUser;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface TestCaseService {

    List<OneHourActivityUser> findUsersAndLastHourActivity();

    List<NotFinishedUsers> findNotFinishedUsers();

    List<Formid> findTopFiveForms();

}
