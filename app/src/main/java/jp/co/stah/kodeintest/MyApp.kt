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

}