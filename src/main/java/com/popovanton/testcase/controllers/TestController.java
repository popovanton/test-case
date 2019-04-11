package com.popovanton.testcase.controllers;

import com.popovanton.testcase.services.TestCaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    private TestCaseService testCaseService;

    public TestController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @RequestMapping({"", "/"})
    public String getIndex(Model model) {
        return "index";
    }

    @GetMapping("/task1")
    public String getTask1(Model model) {
        model.addAttribute("list", testCaseService.findUsersAndLastHourActivity());

        return "tasks/task1";
    }

    @RequestMapping("/task2")
    public String getTask2(Model model) {
        model.addAttribute("list", testCaseService.findNotFinishedUsers());

        return "tasks/task2";
    }

    @RequestMapping("/task3")
    public String getTask3(Model model) {
        model.addAttribute("list", testCaseService.findTopFiveForms());

        return "tasks/task3";
    }


}
