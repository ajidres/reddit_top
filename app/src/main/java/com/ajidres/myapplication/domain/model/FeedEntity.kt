package com.ajidres.myapplication.domain.model


data class ChildrenFeedDataEntity(


    val title: String,
    val selftext: String,
    val subredditNamePrefixed: String,
    val linkFlairCssClass: String,
    val ups: Int,
    val numComments: Int,
    val urlOverriddenByDest: String,
    val childrenFeedPreviewEntity: ChildrenFeedPreviewEntity,
    val url: String,
    val created: Long,
    val isVideo: Boolean,
    val author: String,
    val isGallery: Boolean,

//    val allAwardings: List<Any>,
//    val allowLiveComments: Boolean,
//    val approvedAtUtc: Any,
//    val approvedBy: Any,
//    val archived: Boolean,
//    val author: String,
//    val authorFlairBackgroundColor: Any,
//    val authorFlairCssClass: Any,
//    val authorFlairRichtext: List<Any>,
//    val authorFlairTemplateId: Any,
//    val authorFlairText: Any,
//    val authorFlairTextColor: Any,
//    val authorFlairType: String,
//    val authorFullname: String,
//    val authorIsBlocked: Boolean,
//    val authorPatreonFlair: Boolean,
//    val authorPremium: Boolean,
//    val awarders: List<Any>,
//    val bannedAtUtc: Any,
//    val bannedBy: Any,
//    val canGild: Boolean,
//    val canModPost: Boolean,
//    val category: Any,
//    val clicked: Boolean,
//    val contentCategories: Any,
//    val contestMode: Boolean,
//    val created: Double,
//    val createdUtc: Double,
//    val discussionType: Any,
//    @SerializedName("distinguished")
//    val distinguished: Any,
//    @SerializedName("domain")
//    val domain: String,
//    @SerializedName("downs")
//    val downs: Int,
//    @SerializedName("edited")
//    val edited: Boolean,
//    @SerializedName("gilded")
//    val gilded: Int,
//    @SerializedName("gildings")
//    val childrenFeedGildings: ChildrenFeedGildings,
//    @SerializedName("hidden")
//    val hidden: Boolean,
//    @SerializedName("hide_score")
//    val hideScore: Boolean,
//    @SerializedName("id")
//    val id: String,
//    @SerializedName("is_created_from_ads_ui")
//    val isCreatedFromAdsUi: Boolean,
//    @SerializedName("is_crosspostable")
//    val isCrosspostable: Boolean,
//    @SerializedName("is_meta")
//    val isMeta: Boolean,
//    @SerializedName("is_original_content")
//    val isOriginalContent: Boolean,
//    @SerializedName("is_reddit_media_domain")
//    val isRedditMediaDomain: Boolean,
//    @SerializedName("is_robot_indexable")
//    val isRobotIndexable: Boolean,
//    @SerializedName("is_self")
//    val isSelf: Boolean,
//    @SerializedName("is_video")
//    val isVideo: Boolean,
//    @SerializedName("likes")
//    val likes: Any,
//    @SerializedName("link_flair_background_color")
//    val linkFlairBackgroundColor: String,
//    @SerializedName("link_flair_css_class")
//
//    @SerializedName("link_flair_richtext")
//
//    @SerializedName("link_flair_template_id")
//    val linkFlairTemplateId: String,
//    @SerializedName("link_flair_text")
//    val linkFlairText: String,
//    @SerializedName("link_flair_text_color")
//    val linkFlairTextColor: String,
//    @SerializedName("link_flair_type")
//    val linkFlairType: String,
//    @SerializedName("locked")
//    val locked: Boolean,
//    @SerializedName("media")
//    val media: Any,
//    @SerializedName("media_embed")
//    val childrenFeedMediaEmbed: ChildrenFeedMediaEmbed,
//    @SerializedName("media_only")
//    val mediaOnly: Boolean,
//    @SerializedName("mod_note")
//    val modNote: Any,
//    @SerializedName("mod_reason_by")
//    val modReasonBy: Any,
//    @SerializedName("mod_reason_title")
//    val modReasonTitle: Any,
//    @SerializedName("mod_reports")
//    val modReports: List<Any>,
//    @SerializedName("name")
//    val name: String,
//    @SerializedName("no_follow")
//    val noFollow: Boolean,
//    @SerializedName("num_comments")
//    val numComments: Int,
//    @SerializedName("num_crossposts")
//    val numCrossposts: Int,
//    @SerializedName("num_reports")
//    val numReports: Any,
//    @SerializedName("over_18")
//    val over18: Boolean,
//    @SerializedName("parent_whitelist_status")
//    val parentWhitelistStatus: String,
//    @SerializedName("permalink")
//    val permalink: String,
//    @SerializedName("pinned")
//    val pinned: Boolean,
//    @SerializedName("post_hint")
//    val postHint: String,
//    @SerializedName("preview")
//
//    @SerializedName("pwls")
//    val pwls: Int,
//    @SerializedName("quarantine")
//    val quarantine: Boolean,
//    @SerializedName("removal_reason")
//    val removalReason: Any,
//    @SerializedName("removed_by")
//    val removedBy: Any,
//    @SerializedName("removed_by_category")
//    val removedByCategory: Any,
//    @SerializedName("report_reasons")
//    val reportReasons: Any,
//    @SerializedName("saved")
//    val saved: Boolean,
//    @SerializedName("score")
//    val score: Int,
//    @SerializedName("secure_media")
//    val secureMedia: Any,
//    @SerializedName("secure_media_embed")
//    val childrenFeedSecureMediaEmbed: ChildrenFeedSecureMediaEmbed,
//    @SerializedName("selftext")
//
//    @SerializedName("selftext_html")
//    val selftextHtml: String,
//    @SerializedName("send_replies")
//    val sendReplies: Boolean,
//    @SerializedName("spoiler")
//    val spoiler: Boolean,
//    @SerializedName("stickied")
//    val stickied: Boolean,
//    @SerializedName("subreddit")
//
//    @SerializedName("subreddit_id")
//    val subredditId: String,
//    @SerializedName("subreddit_name_prefixed")
//
//    @SerializedName("subreddit_subscribers")
//    val subredditSubscribers: Int,
//    @SerializedName("subreddit_type")
//    val subredditType: String,
//    @SerializedName("suggested_sort")
//    val suggestedSort: Any,
//    @SerializedName("thumbnail")
//    val thumbnail: String,
//    @SerializedName("thumbnail_height")
//    val thumbnailHeight: Int,
//    @SerializedName("thumbnail_width")
//    val thumbnailWidth: Int,
//    @SerializedName("title")
//
//    @SerializedName("top_awarded_type")
//    val topAwardedType: Any,
//    @SerializedName("total_awards_received")
//    val totalAwardsReceived: Int,
//    @SerializedName("treatment_tags")
//    val treatmentTags: List<Any>,
//    @SerializedName("ups")
//
//    @SerializedName("upvote_ratio")
//    val upvoteRatio: Double,
//    @SerializedName("url")
//
//    @SerializedName("url_overridden_by_dest")
//
//    @SerializedName("user_reports")
//    val userReports: List<Any>,
//    @SerializedName("view_count")
//    val viewCount: Any,
//    @SerializedName("visited")
//    val visited: Boolean,
//    @SerializedName("whitelist_status")
//    val whitelistStatus: String,
//    @SerializedName("wls")
//    val wls: Int
)

//
//class ChildrenFeedGildings
//
//data class ChildrenFeedLinkFlairRichtext(
//    @SerializedName("e")
//    val e: String,
//    @SerializedName("t")
//    val t: String
//)
//
//class ChildrenFeedMediaEmbed
//
//class ChildrenFeedSecureMediaEmbed
//
data class ChildrenFeedPreviewEntity(
    val enabled: Boolean,
    val previewImageEntities: List<PreviewImageEntity>
)

data class PreviewImageEntity(
    val id: String,
    val previewImageResolutionsEntity: List<PreviewImageResolutionEntity>,
    val previewImageSourceEntity: PreviewImageSourceEntity,
    val previewImageVariantsEntity: PreviewImageVariantsEntity
)

data class PreviewImageResolutionEntity(
    val height: Int = 0,
    val url: String = "",
    val width: Int = 0
)

data class PreviewImageSourceEntity(
    val height: Int = 0,
    val url: String = "",
    val width: Int = 0
)

class PreviewImageVariantsEntity

