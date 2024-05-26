package com.ajidres.myapplication.data.api.mapper

import com.ajidres.myapplication.data.api.model.FeedModel
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import com.ajidres.myapplication.domain.model.ChildrenFeedPreviewEntity
import com.ajidres.myapplication.domain.model.PreviewImageEntity
import com.ajidres.myapplication.domain.model.PreviewImageResolutionEntity
import com.ajidres.myapplication.domain.model.PreviewImageSourceEntity
import com.ajidres.myapplication.domain.model.PreviewImageVariantsEntity

//java.lang.NullPointerException: Attempt to invoke virtual method 'boolean com.ajidres.myapplication.data.api.model.ChildrenFeedPreview.getEnabled()' on a null object reference

fun FeedModel.toEntity(): List<ChildrenFeedDataEntity> =
    with(this) {
        return feedDataModel.children.map { children ->
            with(children.childrenFeedDataModel) {
                ChildrenFeedDataEntity(
                    title = title,
                    selftext = selftext,
                    subredditNamePrefixed = subredditNamePrefixed,
                    linkFlairCssClass = linkFlairCssClass ?: "",
                    ups = ups,
                    numComments = numComments,
                    urlOverriddenByDest = urlOverriddenByDest ?: "",
                    url = url,
                    created = created,
                    isVideo = isVideo,
                    author = author,
                    isGallery = isGallery ?: false,
                    childrenFeedPreviewEntity = if (childrenFeedPreview == null)
                        ChildrenFeedPreviewEntity(
                            enabled = false,
                            previewImageEntities = listOf(
                                PreviewImageEntity(
                                    id = "",
                                    previewImageResolutionsEntity = emptyList(),
                                    previewImageSourceEntity = PreviewImageSourceEntity(),
                                    previewImageVariantsEntity = PreviewImageVariantsEntity()
                                )
                            )
                        )
                    else
                        ChildrenFeedPreviewEntity(
                            enabled = childrenFeedPreview.enabled ?: false,
                            previewImageEntities = if (childrenFeedPreview.previewImageModels == null) emptyList() else childrenFeedPreview.previewImageModels.map { previewMap ->
                                PreviewImageEntity(
                                    id = previewMap.id,
                                    previewImageSourceEntity = PreviewImageSourceEntity(
                                        height = previewMap.previewImageSourceModel.height,
                                        url = previewMap.previewImageSourceModel.url,
                                        width = previewMap.previewImageSourceModel.width
                                    ),
                                    previewImageVariantsEntity = PreviewImageVariantsEntity(),

                                    previewImageResolutionsEntity = previewMap.previewImageResolutionModels.map { imageResolution ->
                                        PreviewImageResolutionEntity(
                                            height = imageResolution.height,
                                            url = imageResolution.url,
                                            width = imageResolution.width
                                        )
                                    },

                                    )
                            }
                        ),

                    )
            }
        }.toList()
    }
