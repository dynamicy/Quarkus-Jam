package io.csie.chris.demo.service

import io.csie.chris.demo.dto.UserModel
import io.csie.chris.demo.entity.User
import io.csie.chris.demo.exception.UserNotFoundException
import io.csie.chris.demo.repository.UserRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.bson.Document
import org.bson.types.ObjectId

@ApplicationScoped
class UserService {

    @Inject
    lateinit var userRepository: UserRepository

    fun addUser(name: String, email: String): UserModel {
        val user = User().apply {
            this.name = name
            this.email = email
        }
        userRepository.addUser(user)
        return UserModel.fromEntity(user)
    }

    fun deleteUser(id: String) {
        val userId = ObjectId(id)
        val user = userRepository.getUserById(userId) ?: throw UserNotFoundException("User not found")
        userRepository.getCollection().deleteOne(Document("_id", userId))
    }

    fun getUserById(id: String): UserModel {
        val userId = ObjectId(id)
        val user = userRepository.getUserById(userId) ?: throw UserNotFoundException("User not found")
        return UserModel.fromEntity(user)
    }

    fun getAllUsers(): List<UserModel> {
        return userRepository.findAll()
            .map { UserModel.fromEntity(it) }
    }
}