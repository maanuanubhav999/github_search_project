package com.asraven.speerassessment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asraven.speerassessment.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    viewModel: MainViewModel = hiltViewModel(),
    ){
    val uiState by viewModel.mainUi.collectAsStateWithLifecycle()

    val lazyListState = rememberLazyListState()
    var searchText by remember { mutableStateOf("") }
    val coroutineScope = CoroutineScope(Dispatchers.Main)


    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SearchBoxView(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
            onSearchFilter = {
                searchText = it
                if (searchText.isNullOrEmpty()) {
//                clearSearchResults()
                } else {
                    coroutineScope.launch {
                        delay(500)
                        viewModel.searchUser(searchText)
                    }
                }
            }
        )

        if (uiState.loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp)
            )
        } else {
            uiState.data?.items?.let {
                LazyColumn(
                    state = lazyListState,

                    ) {
                    itemsIndexed(items = it) { index, item ->
                        SearchRow(userName = item.login)
                    }
                }
            }
        }

    }



}

@Composable
fun SearchBarComponent(){}