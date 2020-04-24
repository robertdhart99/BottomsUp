package edu.uc.brown5a7.BottomsUp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.uc.brown5a7.BottomsUp.R

class SignUpFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.sign_up_fragment, container, false)

    companion object {
        fun newInstance(): SignUpFragment = SignUpFragment()
    }

}