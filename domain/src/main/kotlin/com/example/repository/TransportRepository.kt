package com.example.repository

import com.example.model.transport.Transport
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransportRepository : JpaRepository<Transport, Long>
