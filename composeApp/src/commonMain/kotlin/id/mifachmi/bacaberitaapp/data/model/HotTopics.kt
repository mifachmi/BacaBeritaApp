package id.mifachmi.bacaberitaapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotTopics(

	@SerialName("topics")
	val topics: List<TopicsItem>,

	@SerialName("section")
	val section: String
)

@Serializable
data class TopicsItem(

	@SerialName("image_description")
	val imageDescription: String,

	@SerialName("title")
	val title: String
)
