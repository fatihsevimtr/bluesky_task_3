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
class Group {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var gid: String = ""
    var name: String = ""
    var description: String = ""
    var city: String = ""
    var state: String = ""
}