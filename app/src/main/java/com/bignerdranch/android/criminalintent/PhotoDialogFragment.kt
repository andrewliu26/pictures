package com.bignerdranch.android.criminalintent

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.bignerdranch.android.criminalintent.databinding.FragmentPhotoBinding
import java.io.File

class PhotoDialogFragment : DialogFragment() {

    private var _binding: FragmentPhotoBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentPhotoBinding.inflate(LayoutInflater.from(context))


        val photoFileName = arguments?.getString(ARG_PHOTO_FILE_NAME)
        val photoFile = photoFileName?.let {
            File(requireContext().applicationContext.filesDir, it)
        }

        if (photoFile?.exists() == true) {
            val bitmap = BitmapFactory.decodeFile(photoFile.absolutePath)
            binding.crimePhotoZoom.setImageBitmap(bitmap)
        }

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(binding.root)
        builder.setPositiveButton("Close") { _, _ -> }
        return builder.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "PhotoDialogFragment"
        const val ARG_PHOTO_FILE_NAME = "photo_file_name"
    }
}