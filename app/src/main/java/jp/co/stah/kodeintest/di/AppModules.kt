package jp.co.stah.kodeintest.di

//import retrofit2.converter.moshi.MoshiConverterFactory
import android.content.Context
import jp.co.stah.kodeintest.data.network.HeadersInterceptor
import jp.co.stah.kodeintest.data.network.httpClient
import jp.co.stah.kodeintest.data.network.loggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton



/**
 * Application scoped dependencies. Dependencies that we would need to reuse at any point in the
 * application lifecycle like singletons will be binded here.
 *
 * It brings into scope bindings defined in other app scoped modules for better modularity.
 */
fun appModule(appContext: Context) = Module("appModule") {
    bind<Context>() with provider { appContext }
   /*
    bind<Navigator>() with provider { PhotoAppNavigator(instance()) }
    bind<Logger>() with singleton { AndroidLogger() }
    bind<Invoker>() with singleton { UseCaseInvoker() }
*/
    import(httpAppModule())
   // import(photosAppModule())
}


fun httpAppModule() = Kodein.Module("httpModule") {
    bind<Interceptor>(tag = "headers") with singleton { HeadersInterceptor() }
    bind<Interceptor>(tag = "logging") with singleton { loggingInterceptor() }
    bind<OkHttpClient>() with singleton {
        httpClient(instance(tag = "headers"), instance(tag = "logging"))
    }
}
/*
fun photosAppModule() = Kodein.Module("photoAppModule") {
    bind<UnsplashService>() with singleton {
        Retrofit.Builder()
            .baseUrl("https://api.unsplash.com")
            .client(instance())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(UnsplashService::class.java)
    }

    constant(tag = "ttl") with TimeUnit.HOURS.toMillis(1)

    bind<PhotosLocalDataSource>() with singleton { InMemoryPhotosDataSource(instance(tag = "ttl")) }
    bind<PhotosNetworkDataSource>() with singleton { UnsplashPhotosDataSource(instance()) }
    bind<PhotosRepository>() with singleton { PhotosRepository(instance(), instance()) }
}*/
