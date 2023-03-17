package com.bignerdranch.android.secretmessage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class EncryptFragment : Fragment() {

    lateinit var btnLook: Button
    lateinit var encryptedViewInt : TextView
    lateinit var encryptedViewString : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        initView(view)
        val messageString = EncryptFragmentArgs.fromBundle(requireArguments()).myStringMessage
        encryptedViewString.text = messageString

        btnLook.setOnClickListener {
            var messageInt = EncryptFragmentArgs.fromBundle(requireArguments()).myIntMessage.toString()
            encryptedViewInt.text = messageInt
        }
        return view
    }

    private fun initView(view: View) {
        encryptedViewInt = view.findViewById<TextView>(R.id.encrypted_message_int)
        encryptedViewString = view.findViewById<TextView>(R.id.encrypted_message_string)
        btnLook = view.findViewById<Button>(R.id.look_message_int)
    }
}
