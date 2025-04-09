package org.ntt.habittracker.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ntt.habittracker.data.database.HabitsDatabase
import org.ntt.habittracker.data.datasource.HabitLocalDataSource
import org.ntt.habittracker.data.datasource.HabitLocalDataSourceImpl
import org.ntt.habittracker.data.repository.HabitRepository
import org.ntt.habittracker.data.repository.HabitRepositoryImpl
import org.ntt.habittracker.domain.usecase.DeleteHabitUseCase
import org.ntt.habittracker.domain.usecase.GetAllHabitsUseCase
import org.ntt.habittracker.domain.usecase.UpsertHabitUseCase
import org.ntt.habittracker.viewmodel.HomeViewModel

expect fun platformModule(): Module

fun initKoin(config: KoinAppDeclaration? = null) =
	startKoin {
		config?.invoke(this)
		modules(
			platformModule(),
			provideDataSourceModule,
			provideRepositoryModule,
			provideUseCaseModule,
			provideViewModelModule
		)
	}

val provideDataSourceModule = module {
	single { get<HabitsDatabase>().getDao() }
	singleOf(::HabitLocalDataSourceImpl).bind(HabitLocalDataSource::class)
}

val provideRepositoryModule = module {
	singleOf(::HabitRepositoryImpl).bind(HabitRepository::class)
}

val provideUseCaseModule = module {
	singleOf(::GetAllHabitsUseCase)
	singleOf(::DeleteHabitUseCase)
	singleOf(::UpsertHabitUseCase)
}

val provideViewModelModule = module {
	viewModelOf(::HomeViewModel)
}