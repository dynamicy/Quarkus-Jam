package io.csie.chris.demo.repository

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import io.csie.chris.demo.entity.User
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.bson.Document
import org.bson.types.ObjectId

@ApplicationScoped
class UserRepository {

    @Inject
    lateinit var mongoClient: MongoClient

    fun getCollection(): MongoCollection<Document> {
        return mongoClient.getDatabase("myDatabase").getCollection("users")
    }

    fun findAll(): List<User> {
        return getCollection().find().map {
            User(
                id = it.getObjectId("_id"),
                name = it.getString("name"),
                email = it.getString("email")
            )
        }.toList()
    }

    fun addUser(user: User) {
        val document = Document("name", user.name)
            .append("email", user.email)
        getCollection().insertOne(document)
    }

    fun getUserById(id: ObjectId): User? {
        val document = getCollection().find(Document("_id", id)).firstOrNull()
        return document?.let {
            User(it.getObjectId("_id"), it.getString("name"), it.getString("email"))
        }
    }
}