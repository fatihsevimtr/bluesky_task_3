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
class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id:String = ""
    private val uid:String = ""
    private val gid:String = ""
}