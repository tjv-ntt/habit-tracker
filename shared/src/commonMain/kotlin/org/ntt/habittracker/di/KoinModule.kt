package org.ntt.habittracker.di

import org.koin.dsl.module
import org.ntt.habittracker.database.HabitsDao
import org.ntt.habittracker.database.getHabitsDatabase

val appModule = module {
	single { getHabitsDatabase(get()).getHabitsDao() }
}