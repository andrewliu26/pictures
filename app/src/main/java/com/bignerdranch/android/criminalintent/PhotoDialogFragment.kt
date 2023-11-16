package com.bignerdranch.android.criminalintent

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.bignerdranch.android.criminalintent.databinding.FragmentPhotoBinding

class PhotoDialogFragment : DialogFragment() {

    private var _binding: FragmentPhotoBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentPhotoBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(binding.root)
        builder.setPositiveButton("Close") { _, _ -> }
        return builder.create()
    }

    companion object {
        const val TAG = "PhotoDialogFragment"
    }
}