package com.bluesky.model.source

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
class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var firstName: String = ""
    var lastName: String = ""
    var address1: String = ""
    var address2: String = ""
    var city: String = ""
    var state: String = ""
    var postCode: Int = 0
    var country: String = ""
    var contact: String = ""
    var phone1: String = ""
    var phone2: String = ""
    var fax: String = ""
    var email: String = ""
    var website: String = ""
    var company: String = ""
    var branchId: Int = 0
}