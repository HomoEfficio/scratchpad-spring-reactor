package io.homo_efficio.scratchpad.spring.reactor.cache.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("items")
data class Item(
    @Id
    var id: String? = null,

    val name: String,
    val price: Int,
)
