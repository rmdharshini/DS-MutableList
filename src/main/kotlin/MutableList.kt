class MutableList(private var size: Int) : ListBuilder {
    private var counter = 0
    private var array: Array<Int?> = arrayOfNulls(size)

    init {
        this.array = arrayOfNulls(size)
    }

    override fun size(): Int {
        return size
    }

    override fun add(element: Int) {
        if (counter >= size) {
            array = array.copyOf(size * 2)
        }
        array[counter++] = element
    }

    override fun addAll(elements: Collection<Int>) {
        if ((counter + elements.size) >= size) {
            array = array.copyOf(size * 2)
        }
        for (element in elements) {
            array[counter++] = element
        }
    }

    override fun set(element: Int, index: Int) {
        if (index >= size) {
            throw ArrayIndexOutOfBoundsException("Index out of bound")
        }
        array[index] = element
    }

    override fun remove(element: Int) {
        for (index in array.indices) {
            if (array[index] == element) {
                for (i in index until counter-1) {
                    array[i] = array[i+1]
                }
                array[counter-1] = null
                counter--
                return
            }
        }
    }

    override fun removeAt(index: Int) {
        if (index >= size) {
            throw ArrayIndexOutOfBoundsException("Index out of bound")
        }
        for (i in index until counter-1) {
            array[i] = array[i+1]
        }
        array[counter-1] = null
        counter--
    }

    override fun get(index: Int): Int? {
        if (index >= size) {
            throw ArrayIndexOutOfBoundsException("Index out of bound")
        }
        return array[index]
    }
}