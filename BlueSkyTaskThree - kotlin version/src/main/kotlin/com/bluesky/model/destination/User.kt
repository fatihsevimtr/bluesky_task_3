package com.bluesky.model.destination

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var uid: String = ""
    var title: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var position: String = ""
    var address: String = ""
    var mobile: String = ""
    var phone: String = ""
    var email: String = ""
    var companyName: String = ""
}