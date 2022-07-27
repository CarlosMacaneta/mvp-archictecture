package com.cm.mvparchitecture.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.cm.mvparchitecture.data.db.AppDbHelper
import com.cm.mvparchitecture.data.db.repository.UserRepositoryImpl
import com.cm.mvparchitecture.domain.usecase.AppUseCase
import com.cm.mvparchitecture.domain.usecase.CreateUserUseCase
import com.cm.mvparchitecture.domain.usecase.GetUserByUsername
import com.cm.mvparchitecture.ui.home.HomePresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton fun providesContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton fun providesAppDBHelper(app: Application): AppDbHelper =
        Room.databaseBuilder(
            app,
            AppDbHelper::class.java,
            AppDbHelper.DB_NAME
        ).build()

    @Provides
    @Singleton fun providesUserRepository(appDbHelper: AppDbHelper): UserRepositoryImpl =
        UserRepositoryImpl(appDbHelper.userDao())

    @Provides
    @Singleton fun providesAppUseCase(repository: UserRepositoryImpl): AppUseCase =
        AppUseCase(
            CreateUserUseCase(repository),
            GetUserByUsername(repository)
        )

    @Provides
    @Singleton fun providesHomePresenter(appUseCase: AppUseCase): HomePresenter =
        HomePresenter(appUseCase)
}