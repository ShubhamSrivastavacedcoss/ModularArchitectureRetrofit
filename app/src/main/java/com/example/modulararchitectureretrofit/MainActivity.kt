package com.example.modulararchitectureretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modulararchitectureretrofit.Adapter.BookAdapter
import com.example.modulararchitectureretrofit.api.EndpointInterface
import com.example.modulararchitectureretrofit.databinding.ActivityMainBinding
import com.example.modulararchitectureretrofit.repository.QuoteRepository
import com.example.modulararchitectureretrofit.viewmodels.QuoteViewModel
import com.example.modulararchitectureretrofit.viewmodels.QuoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var quoteViewModel: QuoteViewModel
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        activityMainBinding.rv.setLayoutManager(LinearLayoutManager(this))
        activityMainBinding.rv.setHasFixedSize(true)

        val bookAdapter = BookAdapter()
        activityMainBinding.rv.setAdapter(bookAdapter)


        val endpointInterface = com.example.retrofitmodule.Utils.RetrofitHelper.getInstance().create(EndpointInterface::class.java)

        val quoteRepository = QuoteRepository(endpointInterface)

        quoteViewModel = ViewModelProvider(this, QuoteViewModelFactory(quoteRepository))
            .get(QuoteViewModel::class.java)

        quoteViewModel.quotes.observe(this, androidx.lifecycle.Observer {
            // Log.i("HIT", " " + it.results.toString())

            bookAdapter.setdataList(it.data)


            //   activityMainBinding.dataTv.text = it.per_page.toString()

        })

        /*    GlobalScope.launch {
                val result = quotesApi.getQuotes(1)

                if(result!= null){
                    var quoteList= result.body()
                    if (quoteList != null) {
                        quoteList.results.forEach {
                            Log.i("HIT", " " + it.author)

                        }
                    }


                }
            }*/
    }



}