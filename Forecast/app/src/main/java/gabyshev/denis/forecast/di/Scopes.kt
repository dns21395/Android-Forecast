package gabyshev.denis.forecast.di

import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Created by denis on 22/12/2017.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentContext

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PreferenceInfo

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerService
