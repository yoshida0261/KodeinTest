package jp.co.stah.kodeintest.domain.model

data class Photo (val id: String,
                  val url: String,
                  val author: String,
                  val description: String?,
                  val created_at: String)