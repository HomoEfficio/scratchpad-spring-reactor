package io.homo_efficio.scratchpad.spring.reactor

import io.homo_efficio.scratchpad.spring.reactor.domain.model.Item
import io.homo_efficio.scratchpad.spring.reactor.service.ItemService
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class ItemServiceTest {

    @Autowired
    private lateinit var itemService: ItemService


    @AfterEach
    fun afterEach() {
        println("=================")
        itemService.deleteAll().block()
    }

    @Test
    fun `without cache`() {
        val savedItem = initData()

        println("-----------------")
        val foundItem1 = itemService.getItem(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem2 = itemService.getItem(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem3 = itemService.getItem(savedItem!!.id!!).block()
    }


    @Test
    fun `with reactor cache`() {
        val savedItem = initData()

        println("-----------------")
        val foundItem1 = itemService.getItemReactorCache(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem2 = itemService.getItemReactorCache(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem3 = itemService.getItemReactorCache(savedItem!!.id!!).block()
    }

    @Test
    fun `with cacheable cache`() {
        val savedItem = initData()

        println("-----------------")
        val foundItem1 = itemService.getItemCacheableCache(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem2 = itemService.getItemCacheableCache(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem3 = itemService.getItemCacheableCache(savedItem!!.id!!).block()
    }

    @Test
    fun `with cacheable reactor cache`() {
        val savedItem = initData()

        println("-----------------")
        val foundItem1 = itemService.getItemCacheableReactorCache(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem2 = itemService.getItemCacheableReactorCache(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem3 = itemService.getItemCacheableReactorCache(savedItem!!.id!!).block()
    }

    @Test
    fun `with cacheable reactor cache with TTL`() {
        val savedItem = initData()

        println("-----------------")
        val foundItem1 = itemService.getItemCacheableReactorCacheWithTTL300ms(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem2 = itemService.getItemCacheableReactorCacheWithTTL300ms(savedItem!!.id!!).block()
        Thread.sleep(200)

        println("-----------------")
        val foundItem3 = itemService.getItemCacheableReactorCacheWithTTL300ms(savedItem!!.id!!).block()
    }
    private fun initData(): Item? {
        println("=================")
        val savedItem = itemService.save(
            Item(id = null, name = "name01", price = 1)
        ).block()
        Thread.sleep(200)
        return savedItem
    }
}