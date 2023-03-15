package com.bignerdranch.android.secretmessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class MessageFragment : Fragment() {

    lateinit var nextBtn: Button
    lateinit var editMessageView : EditText
    lateinit var btn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        initView(view)
        onClick(view)
        return view
    }

    private fun onClick(view: View) {
        var myMessage = 777
        val message = editMessageView.text.toString()
        val action = MessageFragmentDirections
            .actionMessageFragmentToEncryptFragment(message,myMessage)

        nextBtn.setOnClickListener {
            message                                  //FixMe перестало передовать String первый аргумент
            view.findNavController().navigate(action)
        }
        btn.setOnClickListener {
            view.findNavController().navigate(action)
        }
    }
    private fun initView(view: View){
        nextBtn = view.findViewById<Button?>(R.id.next)
        editMessageView = view.findViewById<EditText>(R.id.message)
        btn = view.findViewById(R.id.boolean_btn)
    }
}