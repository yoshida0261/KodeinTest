package jp.co.stah.kodeintest.di

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import jp.co.stah.kodeintest.MyApp
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein

abstract class InjectedActivity : AppCompatActivity(), KodeinAware {

    // closestKodein() automatically fetches app Kodein scope.
    private val appKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(appKodein)
        import(baseActivityModule(this@InjectedActivity), allowOverride = true)
        import(activityModule())
        (app().overrideBindings)()
    }

    /**
     * Optional to override, if your activity needs specific DI.
     */
    open fun activityModule() = Kodein.Module("activityModule") {
    }
}

fun Activity.app() = applicationContext as MyApp
