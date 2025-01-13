package com.example.instagramcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.instagramcard.presentation.MainViewModel
import com.example.instagramcard.ui.InstagramProfileCard
import com.example.instagramcard.ui.theme.InstagramCardTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            Test(viewModel)
        }
    }
}

@Composable
private fun Test(viewModel: MainViewModel) {
    InstagramCardTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val models = viewModel.models.observeAsState(listOf())
            LazyColumn {
                items(models.value, key = { it.id }) { model ->
                    val dismissState = rememberSwipeToDismissBoxState(
                        confirmValueChange =  {
                            if (it == SwipeToDismissBoxValue.EndToStart) {
                                viewModel.delete(model)
                            }
                            return@rememberSwipeToDismissBoxState true
                        },
                    )
                    SwipeToDismissBox(
                        state = dismissState,
                        enableDismissFromStartToEnd = false,
                        backgroundContent = {
                           Row(
                               modifier = Modifier
                                   .padding(16.dp)
                                   .background(Color.Red.copy(0.5f))
                                   .fillMaxSize(),
                               verticalAlignment = Alignment.CenterVertically,
                               horizontalArrangement = Arrangement.End
                           ) {
                               Text(
                                   text = "Delete item",
                                   color = Color.White,
                                   fontSize = 24.sp
                               )
                           }
                        }
                    ) {
                        InstagramProfileCard(
                            model = model,
                            onFollowedButtonClickListener = {
                                viewModel.changeFollowingStatus(model)
                            }
                        )
                    }

                }
            }
        }
    }
}

