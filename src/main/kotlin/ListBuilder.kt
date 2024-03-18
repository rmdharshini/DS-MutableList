interface ListBuilder {
    fun size(): Int
    fun add(element: Int)
    fun addAll(elements: Collection<Int>)
    fun set(element: Int, index: Int)
    fun remove(element: Int)
    fun removeAt(index: Int)
    fun get(index: Int): Int?
}