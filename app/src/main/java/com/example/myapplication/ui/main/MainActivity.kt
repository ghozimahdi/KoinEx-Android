package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.myapplication.R
import com.example.myapplication.db.DataEntity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), InterfaceMain.View {
    private val presenter by inject<MainPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val presenter = get<MainPresenter>()

        presenter.view = this
        presenter.fetchData()
    }

    override fun hideLoading() {
        Thread.sleep(1000)
        if (progressBar.isVisible) progressBar.visibility = View.GONE
    }

    override fun showLoading() {
        if (!progressBar.isVisible) progressBar.visibility = View.VISIBLE
    }

    override fun showData(dataEntity: DataEntity) {
        tvID.text = dataEntity.id.toString()
        tvUsername.text = dataEntity.username
        tvEmail.text = dataEntity.email
    }
}
