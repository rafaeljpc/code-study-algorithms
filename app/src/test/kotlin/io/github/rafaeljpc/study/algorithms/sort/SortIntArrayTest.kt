import io.github.rafaeljpc.study.algorithms.IntArrayHeapSort
import io.github.rafaeljpc.study.algorithms.IntArrayMergeSort
import io.github.rafaeljpc.study.algorithms.IntArrayQuickSort
import io.github.rafaeljpc.study.algorithms.IntArraySortInterface
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SortIntArrayTest {
    companion object {
        private val inputArray = intArrayOf(5, 3, 8, 4, 2, 7, 6, 1, 9)
        private val inputArrayInverse = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
        private val inputArrayEmpty = intArrayOf()

        private val sortedArray = inputArray.sorted().toIntArray()
        private val sortedArrayInverse = inputArrayInverse.sorted().toIntArray()
        private val sortedArrayEmpty = inputArrayEmpty.sorted().toIntArray()

        private val defaultSortFunction = object : IntArraySortInterface {
            override fun sort(input: IntArray): IntArray {
                return input.sorted().toIntArray()
            }

            override fun toString(): String {
                return "DefaultJVMSort"
            }


        }

        @JvmStatic
        private fun provideData() =
            listOf(
                Arguments.of(defaultSortFunction, inputArray, sortedArray),
                Arguments.of(defaultSortFunction, inputArrayInverse, sortedArrayInverse),
                Arguments.of(defaultSortFunction, inputArrayEmpty, sortedArrayEmpty),

                Arguments.of(IntArrayQuickSort, inputArray, sortedArray),
                Arguments.of(IntArrayQuickSort, inputArrayInverse, sortedArrayInverse),
                Arguments.of(IntArrayQuickSort, inputArrayEmpty, sortedArrayEmpty),

                Arguments.of(IntArrayMergeSort, inputArray, sortedArray),
                Arguments.of(IntArrayMergeSort, inputArrayInverse, sortedArrayInverse),
                Arguments.of(IntArrayMergeSort, inputArrayEmpty, sortedArrayEmpty),


                Arguments.of(IntArrayHeapSort, inputArray, sortedArray),
                Arguments.of(IntArrayHeapSort, inputArrayInverse, sortedArrayInverse),
                Arguments.of(IntArrayHeapSort, inputArrayEmpty, sortedArrayEmpty),
            )
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun testSortIntArray(
        sortFunction: IntArraySortInterface,
        input: IntArray,
        expected: IntArray,
    ) {
        // When
        // Given
        val result = sortFunction.sort(input)
        // Then
        assertThat(result)
            .isEqualTo(expected)
            .containsExactlyInAnyOrder(input.toTypedArray())

    }
}
