import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class ZoomOutPageTransformer : ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val scale = 1f - abs(position)
        view.scaleX = scale
        view.scaleY = scale
        view.alpha = scale
    }
}