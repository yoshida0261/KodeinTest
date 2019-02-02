package jp.co.stah.kodeintest

//import org.kodein.di.android.closestKodein
//import org.kodein.di.android.retainedKodein
//import org.kodein.di.android.x.androidXModule
import android.app.Application
import jp.co.stah.kodeintest.coffee.Coffee
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider


class MyApp : Application() , KodeinAware {

    /*
    override val kodein = Kodein {
        bind<String>() with instance("Hello, Kodein!")
    }*/


    override val kodein = Kodein.lazy {
        //import(androidXModule(this@MyApp))

        bind() from instance(Logger())

   //     import(electricHeaterModule)

        bind<Coffee>() with provider { Coffee(instance()) }

        // this is bound in the scope of an activity so any retrieval using the same activity will return the same Kettle instance
      //  bind<Kettle<Coffee>>() with scoped(WeakContextScope.of<Activity>()).singleton { Kettle<Coffee>(instance(), instance(),  provider()) }
    }


    override fun onCreate() {
        super.onCreate()
       // val k = kodein
       // println(k)
    }


}