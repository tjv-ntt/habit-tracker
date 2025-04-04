package org.ntt.habittracker.di

import org.koin.dsl.module
import org.ntt.habittracker.data.database.HabitsDatabase
import org.ntt.habittracker.database.getDatabaseBuilder

actual fun platformModule() = module {
    single<HabitsDatabase> { getDatabaseBuilder() }
}