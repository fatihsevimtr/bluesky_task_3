package com.bluesky;

import com.bluesky.model.destination.Group;
import com.bluesky.model.destination.User;
import com.bluesky.model.source.Branches;
import com.bluesky.model.source.Customers;
import com.bluesky.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Blueskytask3Application implements CommandLineRunner {

    @Autowired
    private BranchesRepository branchesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private CustomersRepository customersRepository;


    public static void main(String[] args) {
        SpringApplication.run(Blueskytask3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(".........Inside run ...........");
        System.out.println("Branches List:");
        List<Branches> branches = branchesRepository.select();

        branches.forEach(System.out::println);
        System.out.println("Customers List:");
        List<Customers> customers = customersRepository.select();

        customers.forEach(System.out::println);


        groupRepository.insert(branches);
        userRepository.insert(customers);

        List<User> user = userRepository.select();
        List<Group> group = groupRepository.select();
        userGroupRepository.insert(user,group);
        System.out.println("Group record inserted successfully");


    }
}
