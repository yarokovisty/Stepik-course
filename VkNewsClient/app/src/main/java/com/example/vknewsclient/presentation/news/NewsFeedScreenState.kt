package com.example.vknewsclient.presentation.news

import com.example.vknewsclient.domain.FeedPost

sealed interface NewsFeedScreenState {

    data object Initial : NewsFeedScreenState
    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState
}