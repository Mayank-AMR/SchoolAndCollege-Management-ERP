package com.mayank_amr.schoolmanagementproduct.authentication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mayank_amr.schoolmanagementproduct.R
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

class AuthActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)


    }
}