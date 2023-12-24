package com.example.repository

interface EntityCrudRepository<T, ID> {

    fun create(entity: T)

    fun find(id: ID): T?

    fun update(id: ID, entity: T)

    fun delete(entity: T)

}
