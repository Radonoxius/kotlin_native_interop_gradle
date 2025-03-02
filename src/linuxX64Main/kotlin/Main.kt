import kotlinx.cinterop.*
import demo.*

fun main() {
    println("${nativeMul(3.0F, 5.0F)}")
}

@OptIn(ExperimentalForeignApi::class)
fun nativeMul(a: Float, b: Float) = mul(a, b)
