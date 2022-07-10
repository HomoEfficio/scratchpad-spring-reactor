package io.homo_efficio.scratchpad.spring.reactor.service

import io.homo_efficio.scratchpad.spring.reactor.domain.model.Item
import io.homo_efficio.scratchpad.spring.reactor.domain.repository.ItemRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.Duration

@Service
class ItemService(
    private val itemRepository: ItemRepository,
) {

    fun save(item: Item): Mono<Item> {
        return itemRepository.save(item)
    }

    fun getItem(id: String): Mono<Item> {
        return itemRepository.findById(id)
    }

    fun getItemReactorCache(id: String): Mono<Item> {
        return itemRepository.findById(id).cache()
    }

    @Cacheable("items")
    fun getItemCacheableCache(id: String): Mono<Item> {
        return itemRepository.findById(id)
    }

    @Cacheable("items")
    fun getItemCacheableReactorCache(id: String): Mono<Item> {
        return itemRepository.findById(id).cache()
    }

    @Cacheable("items")
    fun getItemCacheableReactorCacheWithTTL150ms(id: String): Mono<Item> {
        return itemRepository.findById(id).cache(Duration.ofMillis(150))
    }

    fun deleteAll(): Mono<Void> {
        return itemRepository.deleteAll()
    }
}