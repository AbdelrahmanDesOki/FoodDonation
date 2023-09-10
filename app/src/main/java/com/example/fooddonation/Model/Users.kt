package com.example.fooddonation.Model

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.Index
import io.realm.kotlin.types.annotations.PrimaryKey


//collection in our db
class Users : RealmObject {

    @PrimaryKey
    var email: String = ""
    //index used to speed up annotating this field
    @Index
    var password: String = ""

    @Ignore
    var timestamp: RealmInstant = RealmInstant.now()

    //generating auto id
//    var id: ObjectId = ObjectId.invoke()








}