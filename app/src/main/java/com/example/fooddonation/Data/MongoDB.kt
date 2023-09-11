package com.example.fooddonation.Data

import com.example.fooddonation.constants.constant.APP_ID
import io.realm.kotlin.Realm

object MongoDB: MongoRepository {

    private val app = io.realm.kotlin.mongodb.App.Companion.create(APP_ID)
    private val user = app.currentUser
    private lateinit var realm: Realm


    init {
//        configureTheRealm()
    }


//    override fun configureTheRealm(){
//
//        if (user != null) {
//            val config  = syncConfiguration.Builder
//        }
//    }
}