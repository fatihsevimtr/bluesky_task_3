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
class Branches {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var name: String = ""
    var description: String = ""
    var city: String = ""
    var state: String = ""
    var postCode: Int = 0
    var country: String = ""
    var contact: String = ""
    var phone: String = ""
}