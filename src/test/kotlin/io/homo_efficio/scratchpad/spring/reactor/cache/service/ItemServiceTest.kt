package io.homo_efficio.scratchpad.spring.reactor.cache.service

import io.homo_efficio.scratchpad.spring.reactor.cache.domain.model.Item
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName::class)
internal class ItemServiceTest {

    @Autowired
    private lateinit var itemService: ItemService


    @Test
    fun `00 dummy just for embedded mongo db init`() {
        val savedItem = initData()
    }

    @Test
    fun `01 without cache multiple invocation multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItem(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItem(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItem(savedItem!!.id!!).subscribe { log.info(it.toString()) }
    }

    @Test
    fun `011 without cache multiple invocation without subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItem(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItem(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItem(savedItem!!.id!!)
    }

    @Test
    fun `012 without cache single invocation with multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        val foundMono = itemService.getItem(savedItem!!.id!!)
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
    }

    @Test
    fun `02 with reactor cache multiple invocation multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemReactorCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemReactorCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemReactorCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
    }

    @Test
    fun `021 with reactor cache multiple invocation without subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemReactorCache(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemReactorCache(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemReactorCache(savedItem!!.id!!)
    }

    @Test
    fun `022 with reactor cache single invocation with multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        val foundMono = itemService.getItemReactorCache(savedItem!!.id!!)
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
    }

    @Test
    fun `03 with cacheable cache multiple invocation multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemCacheableCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
    }

    @Test
    fun `031 with cacheable cache multiple invocation without subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemCacheableCache(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableCache(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableCache(savedItem!!.id!!)
    }

    @Test
    fun `032 with cacheable cache single invocation with multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        val foundMono = itemService.getItemCacheableCache(savedItem!!.id!!)
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
    }

    @Test
    fun `04 with cacheable reactor cache multiple invocation multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemCacheableReactorCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCache(savedItem!!.id!!).subscribe { log.info(it.toString()) }
    }

    @Test
    fun `041 with cacheable reactor cache multiple invocation without subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemCacheableReactorCache(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCache(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCache(savedItem!!.id!!)
    }

    @Test
    fun `042 with cacheable reactor cache single invocation with multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        val foundMono = itemService.getItemCacheableReactorCache(savedItem!!.id!!)
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
    }

    @Test
    fun `05 with cacheable reactor cache with TTL multiple invocation multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemCacheableReactorCacheWithTTL150ms(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCacheWithTTL150ms(savedItem!!.id!!).subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCacheWithTTL150ms(savedItem!!.id!!).subscribe { log.info(it.toString()) }
    }

    @Test
    fun `051 with cacheable reactor cache with TTL multiple invocation without subscribe`() {
        val savedItem = initData()

        println("-----------------")
        itemService.getItemCacheableReactorCacheWithTTL150ms(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCacheWithTTL150ms(savedItem!!.id!!)
        Thread.sleep(100)

        println("-----------------")
        itemService.getItemCacheableReactorCacheWithTTL150ms(savedItem!!.id!!)
    }

    @Test
    fun `052 with cacheable reactor cache with TTL single invocation with multiple subscribe`() {
        val savedItem = initData()

        println("-----------------")
        val foundMono = itemService.getItemCacheableReactorCacheWithTTL150ms(savedItem!!.id!!)
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
        Thread.sleep(100)

        println("-----------------")
        foundMono.subscribe { log.info(it.toString()) }
    }

    private fun initData(): Item? {
        println("=================")
        val savedItem = itemService.save(
            Item(id = null, name = "name01", price = 1)
        ).block()
        Thread.sleep(100)
        return savedItem
    }

    @AfterEach
    fun afterEach() {
        Thread.sleep(300)
        println("=================")
        itemService.deleteAll().block()
    }


    private val log = LoggerFactory.getLogger(javaClass)
}
