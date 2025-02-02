package com.example.vknewsclient.presentation.comments

import com.example.vknewsclient.domain.FeedPost
import com.example.vknewsclient.domain.PostComment

sealed interface CommentsScreenState {

    data object Initial : CommentsScreenState
    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState
}