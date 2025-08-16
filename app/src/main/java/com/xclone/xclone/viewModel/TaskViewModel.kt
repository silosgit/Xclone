package com.xclone.xclone.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.xclone.xclone.model.TaskModel
import com.xclone.xclone.repository.RepositoryTask
import kotlinx.coroutines.launch

class TaskViewModel(val repository: RepositoryTask): ViewModel() {

    val allTasks: LiveData<List<TaskModel>> = repository.allTasks
    fun insert(task: TaskModel) = viewModelScope.launch {
        repository.insert(task)
    }


}
class TaskViewModelFactory(private val repository: RepositoryTask) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}