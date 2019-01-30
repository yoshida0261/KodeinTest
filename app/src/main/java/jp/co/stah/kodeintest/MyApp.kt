package jp.co.stah.kodeintest

//import org.kodein.di.android.closestKodein
//import org.kodein.di.android.retainedKodein
import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

class MyApp : Application() , KodeinAware {

    override val kodein = Kodein {
        bind<String>() with instance("Hello, Kodein!")
    }

    /*
    override val kodein = Kodein.lazy {
        import(androidXModule(this@DemoApplication))

        bind() from instance(Logger())

        import(electricHeaterModule)

        bind<Coffee>() with provider { Coffee(instance()) }

        // this is bound in the scope of an activity so any retrieval using the same activity will return the same Kettle instance
        bind<Kettle<Coffee>>() with scoped(WeakContextScope.of<Activity>()).singleton { Kettle<Coffee>(instance(), instance(), instance(), provider()) }
    }

     */

}