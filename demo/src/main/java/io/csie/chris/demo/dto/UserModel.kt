package io.csie.chris.demo.dto

import io.csie.chris.demo.entity.User

data class UserModel(
    var id: String? = null,
    var name: String? = null,
    var email: String? = null
) {
    companion object {
        fun fromEntity(user: User): UserModel {
            return UserModel(
                id = user.id?.toHexString(),
                name = user.name,
                email = user.email
            )
        }
    }
}