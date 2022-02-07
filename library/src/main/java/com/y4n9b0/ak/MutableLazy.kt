package com.y4n9b0.ak

import kotlin.reflect.KProperty

interface MutableLazy<T> {
    /**
     * Gets the lazily initialized value of the current Lazy instance.
     * Once the value was initialized it must not change during the rest of lifetime of this Lazy instance.
     */
    val value: T

    /**
     * Returns `true` if a value for this Lazy instance has been already initialized, and `false` otherwise.
     * Once this function has returned `true` it stays `true` for the rest of lifetime of this Lazy instance.
     */
    fun isInitialized(): Boolean

    /**
     * Re evaluate cached value with param block if block is not null, otherwise evaluate with initializer.
     */
    fun eval(block: (() -> T)? = null)
}

internal class MutableLazyImpl<T>(private val initializer: () -> T) : MutableLazy<T> {

    private var cached: T? = null

    override val value: T
        get() {
            if (cached == null) cached = initializer()
            @Suppress("UNCHECKED_CAST")
            return cached as T
        }

    override fun eval(block: (() -> T)?) {
        cached = if (block != null) block() else initializer()
    }

    override fun isInitialized(): Boolean = cached != null

    override fun toString(): String =
        if (isInitialized()) value.toString() else "MutableLazy value not initialized yet."
}

operator fun <T> MutableLazy<T>.getValue(thisRef: Any?, property: KProperty<*>): T = value

fun <T> mutableLazy(initializer: () -> T): MutableLazy<T> = MutableLazyImpl(initializer)
