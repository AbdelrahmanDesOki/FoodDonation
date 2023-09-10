package com.example.fooddonation.DB

import com.example.fooddonation.Data.MongoRepoImplem
import com.example.fooddonation.Data.MongoRepository
import com.example.fooddonation.Model.Users
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration


object DBmodule {


    fun provideRealm(): Realm{
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Users::class
            )
        )
            .compactOnLaunch()
            .build()
        return Realm.open(config)
    }


    fun provideMongoRepo(realm: Realm): MongoRepository{
        return MongoRepoImplem(realm = realm)
    }
}