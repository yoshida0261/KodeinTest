package jp.co.stah.kodeintest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.*
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.kcontext


class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodeinContext: KodeinContext<*> = kcontext(this)

    private val _parentKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein, copy = Copy.All)
       // import(thermosiphonModule)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //    val greeting: String by instance()
    //    Log.d("tag",greeting)

        Log.i("Kodein", "=====================-BINDINGS-=====================")
        Log.i("Kodein", kodein.container.tree.bindings.description())
        Log.i("Kodein", "====================================================")

    }


    /*
    private val _parentKodein by closestKodein()
    override val kodein: Kodein by Kodein.lazy {
        extend(_parentKodein)
        /* activity specific bindings */
    }*/

}
