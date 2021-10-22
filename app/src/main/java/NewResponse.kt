import androidx.annotation.Keep
import androidx.versionedparcelable.ParcelField

data class NewResponse(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class Source(
    val id: String,
    val name: String
)