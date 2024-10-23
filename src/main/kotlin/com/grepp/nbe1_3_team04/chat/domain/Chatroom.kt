package com.grepp.nbe1_3_team04.chat.domain

import com.grepp.nbe1_3_team04.global.domain.BaseEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.SQLDelete
import java.io.Serial
import java.io.Serializable

@Entity
@SQLDelete(sql = "UPDATE chatroom SET is_deleted = 'true' WHERE chatroom_id = ?")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
class Chatroom(
    name: String
) : BaseEntity(), Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var chatroomId: Long? = null
        protected set

    var name: @NotNull String = name
        protected set

    fun updateName(name: String) {
        this.name = name
    }

    companion object {
        @Serial
        private val serialVersionUID = -6846388362402032476L

        fun create(name: String): Chatroom {
            return Chatroom(name)
        }
    }
}
