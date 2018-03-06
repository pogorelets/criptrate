package ru.helen.cript.di

import dagger.Component
import javax.inject.Singleton

/**
 * AppComponent
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

}