package jp.co.faith.playlog_android.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.faith.playlog_android.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDialog(viewModel: MainViewModel = hiltViewModel(),
) {
    DisposableEffect(Unit) {
        onDispose {
            viewModel.resetProperties()
        }
    }
    AlertDialog(
        onDismissRequest = { viewModel.isShowDialog = false },
        confirmButton = { /*TODO*/ },
        title = { Text(text = if (viewModel.isEditing) "タスク更新" else "新規作成") },
        text = {
            Column {
                Text(text = "タイトル")
                TextField(value = viewModel.title, onValueChange = {viewModel.title = it})
                Text(text = "詳細")
                TextField(value = viewModel.description, onValueChange = {viewModel.description = it})
            }
        },
        dismissButton = {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {
                        viewModel.isShowDialog = false
                    },
                ) {
                    Text(text = "キャンセル")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(modifier = Modifier.width(120.dp),
                    onClick = {
                        viewModel.isShowDialog = false
                        if (viewModel.isEditing) viewModel.updateTask()
                        else viewModel.createTask()
                    }
                ) {
                    Text(text = "OK")
                }
            }
        }
    )
}