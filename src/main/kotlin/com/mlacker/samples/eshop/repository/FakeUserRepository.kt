package com.mlacker.samples.eshop.repository

import com.mlacker.samples.eshop.domain.user.User
import com.mlacker.samples.eshop.domain.user.UserRepository
import org.springframework.stereotype.Repository

@Repository
class FakeUserRepository : UserRepository {

    override fun find(id: Long): User? {
        return User(id, "user-$id")
    }

    override fun create(entity: User) {
        TODO("Not yet implemented")
    }

    override fun update(entity: User) {
        TODO("Not yet implemented")
    }
}