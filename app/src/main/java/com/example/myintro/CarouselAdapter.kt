import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myintro.R

class CarouselAdapter(private val carouselDataList: List<Int>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val imageView = holder.imageView
        // Load image into imageView from the carouselDataList (assuming carouselDataList holds image resources)
        if (position < carouselDataList.size) {
            imageView.setImageResource(carouselDataList[position])
        }
    }

    override fun getItemCount(): Int {
        return carouselDataList.size
    }

}
