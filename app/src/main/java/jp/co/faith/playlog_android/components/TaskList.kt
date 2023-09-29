package jp.co.faith.playlog_android.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import jp.co.faith.playlog_android.Task

@Composable
fun TaskList(
    tasks: List<Task>,
    onClickRow: (Task) -> Unit,
    onClickDelete: (Task) -> Unit,
) {
    LazyColumn {
        items(tasks) { task ->
            TaskRow(task = task,
                onClickRow = onClickRow,
                onClickDelete = onClickDelete)
        }
    }
}

