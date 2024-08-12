package io.csie.chris.demo.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import io.csie.chris.demo.serializer.ObjectIdSerializer
import io.quarkus.mongodb.panache.PanacheMongoEntityBase

data class User(
    @BsonId
    @JsonSerialize(using = ObjectIdSerializer::class)
    var id: ObjectId? = ObjectId.get(),
    var name: String? = null,
    var email: String? = null
) : PanacheMongoEntityBase()