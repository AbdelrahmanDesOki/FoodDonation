package com.example.fooddonation.Data

import com.example.fooddonation.Model.Users
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MongoRepoImplem (val realm : Realm): MongoRepository {

 fun getData(): Flow<List<Users>>{
     return realm.query<Users>().asFlow().map { it.list }
}

    suspend fun insertUser(users: Users){
        realm.write { copyToRealm(users) }
    }

}