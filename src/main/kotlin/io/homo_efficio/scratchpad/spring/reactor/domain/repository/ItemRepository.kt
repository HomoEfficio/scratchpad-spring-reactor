package io.homo_efficio.scratchpad.spring.reactor.domain.repository

import io.homo_efficio.scratchpad.spring.reactor.domain.model.Item
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ItemRepository: ReactiveMongoRepository<Item, String> {
}