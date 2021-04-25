package com.bluesky

import com.bluesky.model.source.Branches
import com.bluesky.model.source.Customers
import com.bluesky.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.function.Consumer


@SpringBootApplication
class Blueskytask3Application : CommandLineRunner {
    @Autowired
    val branchesRepository: BranchesRepository = TODO()

    @Autowired
    val userRepository: UserRepository

    @Autowired
    val groupRepository: GroupRepository

    @Autowired
    val userGroupRepository: UserGroupRepository

    @Autowired
    val customersRepository: CustomersRepository

    override fun run(vararg args: String?) {



            println(".........Inside run ...........")
            println("Branches List:")
            val branches = branchesRepository.select()
            branches?.forEach(Consumer<Branches>({ System.out.println() }))
            println("Customers List:")
            val customers = customersRepository.select()
            customers?.forEach(Consumer<Customers>({ System.out.println() }))
            groupRepository.insert(branches)
            userRepository.insert(customers)
            val user = userRepository.select()
            val group = groupRepository.select()
            userGroupRepository.insert(user, group)
            println("Group record inserted successfully")

    }
}

fun main(args: Array<String>) {
    runApplication<Blueskytask3Application>(*args)

}