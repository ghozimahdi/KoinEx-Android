package com.example.myapplication.ui.register

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.model.BodyRegister
import com.example.myapplication.ui.main.MainActivity
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject

class RegisterActivity : AppCompatActivity(), InterfaceRegister.View {
    private val dialog: AlertDialog by lazy {
        SpotsDialog.Builder().setContext(this).build()
    }
    private val presenter by inject<RegisterPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter.view = this

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val pwd = etPassword.text.toString()
            val username = etUsername.text.toString()

            presenter.register(
                BodyRegister(
                    password = pwd,
                    email = email,
                    username = username
                )
            )
        }
    }

    override fun hideLoading() {
        if (dialog.isShowing) dialog.dismiss()
    }

    override fun showLoading() {
        if (!dialog.isShowing) dialog.show()
    }

    override fun onError(msg: String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(msg: String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_LONG).show()
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
        }
    }
}
