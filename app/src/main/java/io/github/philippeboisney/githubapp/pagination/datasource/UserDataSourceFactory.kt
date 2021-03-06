package io.github.philippeboisney.githubapp.pagination.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.github.philippeboisney.githubapp.model.User
import io.github.philippeboisney.githubapp.repository.UserRepository
import kotlinx.coroutines.CoroutineScope

class UserDataSourceFactory(private val repository: UserRepository,
                            private val query: String,
                            private val sort: String,
                            private val scope: CoroutineScope): DataSource.Factory<Int, User>() {
    val source = MutableLiveData<UserDataSource>()
    override fun create(): DataSource<Int, User> {
        val source = UserDataSource(repository, query, sort, scope)
        this.source.postValue(source)
        return source
    }
}